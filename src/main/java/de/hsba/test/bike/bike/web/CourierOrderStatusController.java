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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/courierorderstatus")
public class CourierOrderStatusController {


    @Autowired
    private OrderRepository orderRepository;

    //alle Kurieraufträge finden
    @GetMapping
    public String listOrders(Model model){

        User user = User.getCurrentUser();
        if (user == null) {
            throw new ForbiddenException();
        }
        long currentCourierId = user.getId();

        List<Order> orders = orderRepository.findCourierOrders(currentCourierId);
        if (orders.isEmpty()){
            throw new NotFoundException();
        }
        model.addAttribute("courierorderstatus", orderRepository.findCourierOrders(currentCourierId));

        return "courierorderstatus";
    }

    //Status über Button "Next Status" in der Datenbank verändern (Status +1 = neuer Status)
    @PostMapping
    public String update(@RequestParam("button") Long orderId) {
        orderRepository.updateStatus(orderId);
        return "redirect:/courierorderstatus";
    }
}

