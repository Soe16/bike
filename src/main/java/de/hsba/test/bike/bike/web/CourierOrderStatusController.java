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


    @PostMapping
    public String update(@RequestParam("button") Long orderId) {
        orderRepository.updateStatus(orderId);
        return "redirect:/courierorderstatus";
    }





    /*
    @PostMapping
    public String nextOrderStatus(@RequestParam("${order.id}") Long orderId) {
        orderRepository.updateStatus(orderId);
        return "courierorderstatus";
    }
*/




/*
    @GetMapping
    public String changeStatus(@RequestParam(value="changestatus") long orderId){
    orderRepository.updateStatus(orderId);
    return "redirect:/";
    }

    */

/* letzter Versuch

    @PostMapping
    public String nextOrderStatus(@PathVariable("id") Long orderId) {
        orderRepository.updateStatus(orderId);
        return "courierorderstatus";
    }

    */

/*
      <form sec:authorize="authenticated"
    th:action="${'/journals/' + journal.id + '/entries'}" method="post" th:object="${journalEntryForm}">
      <div class="form-group">
*/

    /* https://www.mkyong.com/spring-mvc/spring-mvc-dropdown-box-example/ für kommendes...




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

        */
    }

