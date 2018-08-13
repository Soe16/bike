package de.hsba.test.bike.bike.web;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    

    @GetMapping("/login")
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth instanceof AnonymousAuthenticationToken ? "login" : "redirect:/";
    }

    /*User customer = new User("Bernd", "be@mail.de", "test", "Customer");
    User deliverer = new User("Kuriere 2000 Inc. Co. KG", "test","mail@mail.mail", "Deliverer");

    Order order = new Order(
            deliverer,
            customer,
            "Mark's Street",
            "25",
            "12364",
            "Bob",
            "Bob's Street",
            "5",
            "69696"
    );

    @GetMapping("/deliverer")
    public String deliverer(Model model) {
        model.addAttribute("deliverer", order.deliverer.getName());
        return "index";
    }

    @GetMapping("/customer")
    public String customer(Model model) {
        model.addAttribute("deliverer", order.customer.getName());
        return "index";
    }

    @GetMapping("/status")
    public String status(Model model) {
        String stat = order.getState();
        model.addAttribute("stat", stat);
        return "index";
    }

    @GetMapping("/nextState")
    public String nextState(Model model) {
        order.nextState();
        return "index";
    }

    @PostMapping("/postOrder")
    public String addOrder(User deliverer, User customer, String customerStreet, String customerNumber, String customerZip, String deliveree, String deliverStreet, String deliverNumber, String deliverZip) {
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
    }*/
}