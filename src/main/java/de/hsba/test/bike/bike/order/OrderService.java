package de.hsba.test.bike.bike.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

    //User customer = new User("Bernd", "be@mail.de", "test", "Customer");

    //User deliverer1 = new User("Kuriere 2000 Inc. Co. KG", "test","mail@mail.mail", "Deliverer");

    //User deliverer2 = new User("Deliver Inc. Co. KG", "test","mail23@mail.mail", "Deliverer");

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        this.orderRepository.deleteById(id);
    }

    public Order findOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

}
