package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.order.Order;
import de.hsba.test.bike.bike.order.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller("/makeorder")
public class MakeOrderController {

    private OrderService orderService;
    private final OrderFormAssembler formAssembler;

    public MakeOrderController(OrderService orderService, OrderFormAssembler formAssembler) {
        this.orderService = orderService;
        this.formAssembler = formAssembler;
    }

    @GetMapping("/makeorder")
    public String index(Model model) {
        model.addAttribute("orderForm", new OrderForm());
        return "makeorder";
    }

    @PostMapping
    @PreAuthorize("authenticated")
    public String create(@ModelAttribute("orderForm") @Valid OrderForm form, BindingResult orderBinding) {
        if(orderBinding.hasErrors()) {
            return"makeorder";
        }
        orderService.save(formAssembler.update(new Order(), form));
        return "redirect:/";
    }

}
