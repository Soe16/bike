package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.order.OrderRepository;
import de.hsba.test.bike.bike.user.User;
import de.hsba.test.bike.bike.web.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/customerOrder")
public class CustomerOrderController {


    @Autowired
    private OrderRepository orderRepository;


    @GetMapping
    public String listOrders(Model model) {

            User user = User.getCurrentUser();
            if (user == null) {
                throw new ForbiddenException();
            }
            long currentUserId = user.getId();

        //veränderncurrentuser!!
        model.addAttribute("customerOrder", orderRepository.customerOrders(currentUserId));
//        model.addAttribute("customerOrder", orderRepository.customerOrders(currentUserId));
        return "customerOrder";
    }

    //https://stackoverflow.com/questions/42945495/getting-the-selected-values-from-a-checkbox-list-to-the-controller-with-spring-b
    @PostMapping
    public String update(@RequestParam("idChecked") List<String> idOrders) {

        User user = User.getCurrentUser();
        if (user == null) {
            throw new ForbiddenException();
        }
        long currentUserId = user.getId();

        if (idOrders != null) {
            for (String idOrdersUp : idOrders) {
                int id = Integer.parseInt(idOrdersUp);
                orderRepository.deleteOrder(currentUserId,id);

            }
        }
        return "index";


    }
}
