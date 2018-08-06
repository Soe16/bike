package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.order.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    Order order = new Order();

    @GetMapping("/newOrder")
    public String newOrder() {
        order.newOrder();
        return "index";
    }

    @GetMapping("/deliverer")
    public String deliverer(Model model) {
        model.addAttribute("deliverer", order.getDeliverer());
        return "index";
    }

    @GetMapping("/customer")
    public String customer(Model model) {
        model.addAttribute("deliverer", order.getCustomer());
        return "index";
    }

    @GetMapping("/status")
    public String status(Model model) {
        String stat = order.getStatus();
        model.addAttribute("stat", stat);
        return "index";
    }

    @GetMapping("/nextState")
    public String nextState(Model model) {
        order.nextStatus();
        return "index";
    }

    @PostMapping("/postOrder")
    public String add(int currentState, String deliverer, String customer, String customerStreet, String customerNumber, String customerZip, String deliveree, String deliverStreet, String deliverNumber, String deliverZip) {
        order.newOrder();
        order.setCurrentState(currentState);
        order.setDeliverer(deliverer);
        order.setCustomer(customer);
        order.setCustomerStreet(customerStreet);
        order.setCustomerNumber(customerNumber);
        order.setCustomerZip(customerZip);
        order.setDeliveree(deliveree);
        order.setDeliverStreet(deliverStreet);
        order.setDeliverNumber(deliverNumber);
        order.setDeliverZip(deliverZip);
        return "redirect:/";
    }

    @GetMapping("/cZip")
    public String cZip(Model model) {
        model.addAttribute("cZip", order.getCustomerZip());
        return "index";
    }
}