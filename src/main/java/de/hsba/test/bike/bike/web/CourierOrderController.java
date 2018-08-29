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
@RequestMapping("/orders")
public class CourierOrderController {


    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
        public String listOrders(Model model){

            model.addAttribute("orders", orderRepository.findNewOrders());

            return "orders";
    }

    //https://stackoverflow.com/questions/42945495/getting-the-selected-values-from-a-checkbox-list-to-the-controller-with-spring-b
    @PostMapping
    public String update(@RequestParam("idChecked") List<String> idOrders) {

        User user = User.getCurrentUser();
        if (user == null) {
            throw new ForbiddenException();
        }
        long currentCourierId = user.getId();


        if(idOrders != null) {
                for(String idOrdersUp : idOrders){
                    int id = Integer.parseInt(idOrdersUp);
                    orderRepository.updateOrder(currentCourierId, id);

                }
            }
        return "index";
    }


    // checkboxes die gecheckt sind, wird in datenbank bestellung geladen, dass 1. currentstatus verändern auf: (1) "The order was accepted by a courier" dementsprechen name des couriers hinterlegen..
    // aufträge verwalten, neue seite für Kurier, same shit mit bestellung abgeholt und bestellung abgeliefert.


}