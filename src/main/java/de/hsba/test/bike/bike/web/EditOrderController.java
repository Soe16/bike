package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.order.Order;
import de.hsba.test.bike.bike.order.OrderRepository;
import de.hsba.test.bike.bike.order.OrderService;
import de.hsba.test.bike.bike.user.UserService;
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
        return "editorder";
    }

    @PostMapping
    public String change(Model model, @PathVariable("id") Long id,
                         @ModelAttribute("orderForm") @Valid OrderForm orderForm, BindingResult orderBinding) {
        if (orderBinding.hasErrors()) {
            return "editorder";
        }
        orderService.save(formAssembler.update(findOrder(id), orderForm));
        return "redirect:/customerOrder";
    }

    @PostMapping(path = "/cancel")
    public String cancel(@PathVariable("id") Long id) {
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

