package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.order.OrderRepository;
import de.hsba.test.bike.bike.user.User;
import de.hsba.test.bike.bike.web.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/finishedCustomerOrder")
public class FinishedCustomerOrderController {


    @Autowired
    private OrderRepository orderRepository;


    @GetMapping
    public String finishedCustomerOrders(Model model) {

        User user = User.getCurrentUser();
        if (user == null) {
            throw new ForbiddenException();
        }
        long currentUserId = user.getId();

        model.addAttribute("finishedCustomerOrder", orderRepository.finishedCustomerOrders(currentUserId));

        return "finishedCustomerOrder";
    }

}