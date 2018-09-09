package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.order.Order;
import de.hsba.test.bike.bike.order.OrderRepository;
import de.hsba.test.bike.bike.user.User;
import de.hsba.test.bike.bike.web.exceptions.ForbiddenException;
import de.hsba.test.bike.bike.web.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/finishedCustomerOrder")
public class FinishedCustomerOrderController {


    @Autowired
    private OrderRepository orderRepository;

    // alle fertigen Kundenaufträge finden mit Status: abgeschlossen oder storniert
    @GetMapping
    public String finishedCustomerOrders(Model model) {

        User user = User.getCurrentUser();
        if (user == null) {
            throw new ForbiddenException();
        }
        long currentUserId = user.getId();

        List<Order> orders = orderRepository.finishedCustomerOrders(currentUserId);
        if (orders.isEmpty()){
            throw new NotFoundException();
        }

        model.addAttribute("finishedCustomerOrder", orderRepository.finishedCustomerOrders(currentUserId));

        return "finishedCustomerOrder";
    }

}