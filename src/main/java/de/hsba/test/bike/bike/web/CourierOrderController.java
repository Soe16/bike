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
@RequestMapping("/orders")
public class CourierOrderController {


    @Autowired
    private OrderRepository orderRepository;

    //alle neuen Aufträge finden
    @GetMapping
        public String listOrders(Model model){

        List<Order> orders = orderRepository.findNewOrders();

            if (orders.isEmpty()){
                throw new NotFoundException();

            }

            model.addAttribute("orders", orderRepository.findNewOrders());

            return "orders";
    }

    // Checkboxen Liste mit Schleife auslesen und bei Aufträgen mit gecheckter Checkbox den Kurier hinterlegen und den Status auf "angenommen" setzten
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
}