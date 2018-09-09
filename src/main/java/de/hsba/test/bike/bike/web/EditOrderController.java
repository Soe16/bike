package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.order.Order;
import de.hsba.test.bike.bike.order.OrderRepository;
import de.hsba.test.bike.bike.order.OrderService;
import de.hsba.test.bike.bike.user.UserService;
import de.hsba.test.bike.bike.web.exceptions.ConflictException;
import de.hsba.test.bike.bike.web.exceptions.ForbiddenException;
import de.hsba.test.bike.bike.web.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/editorder/{id}")
public class EditOrderController {

    @Autowired
    private OrderRepository orderRepository;

    private final OrderService orderService;

    private final UserService userService;

    private final OrderFormAssembler formAssembler;

    public EditOrderController(OrderService orderService, UserService userService, OrderFormAssembler formAssembler) {
        this.orderService = orderService;
        this.userService = userService;
        this.formAssembler = formAssembler;
    }

    @ModelAttribute("order")
    public Order findOrder(@PathVariable("id") Long id) {
        Order order = orderService.findOrder(id);
        if (order == null) {
            throw new NotFoundException();
        }
        return order;
    }

    @GetMapping
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("orderForm", formAssembler.toForm(findOrder(id)));
        if(orderService.findOrder(id).isOwnedByCurrentUser()) {
            return "editorder";
        } else {
            throw new NotFoundException();
        }
    }

    @PostMapping
    public String change(Model model, @PathVariable("id") Long id,
                         @ModelAttribute("orderForm") @Valid OrderForm orderForm, BindingResult orderBinding) {
        //user kann editpage nicht offen lassen und später editieren wenn die order bereits in delivery (oder storniert oder abgegebgen ist)
        // bzw. html code client side editieren und die "disabled" attribute löschen und somit die order im nachhinein editieren
        if (findOrder(id).getCurrentState() > 1) {
            throw new ConflictException();
        }
        //user kann die Abholdaten nicht mehr ändern wenn die Bestellung von einem Kurier angenommen wurde
        if (findOrder(id).getCurrentState() == 1) {
            if (!orderForm.getFromName().equals(findOrder(id).getCustomer()) ||
                !orderForm.getFromStreetName().equals(findOrder(id).getCustomerStreet()) ||
                !orderForm.getFromStreetNumber().equals(findOrder(id).getCustomerNumber()) ||
                !orderForm.getFromZip().equals(findOrder(id).getCustomerZip()) ||
                !orderForm.getPackageType().equals(findOrder(id).getPackageType())
                ) {
                throw new ConflictException();
            }
        }

        if (orderBinding.hasErrors()) {
            return "editorder";
        }
        orderService.save(formAssembler.update(findOrder(id), orderForm));
        return "redirect:/customerOrder";
    }

    @PostMapping(path = "/cancel")
    public String cancel(@PathVariable("id") Long id) {
    if (findOrder(id).getCurrentState() > 0) {
        throw new ConflictException();
    }
       orderRepository.cancelOrder(id);
       return "redirect:/customerOrder";
    }


/*
    @PostMapping
    public String update(@RequestParam("button") Long orderId) {
        orderRepository.cancelOrder(orderId);
        return "redirect:/customOrder";
    }

    */

}

