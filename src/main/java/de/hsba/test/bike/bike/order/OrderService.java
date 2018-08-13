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

    /*User customer = new User("Bernd", "be@mail.de", "test", "Customer");

    User deliverer1 = new User("Kuriere 2000 Inc. Co. KG", "test","mail@mail.mail", "Deliverer");

    User deliverer2 = new User("Deliver Inc. Co. KG", "test","mail23@mail.mail", "Deliverer");

    @PostConstruct
    public void init(){
        createOrder(
                deliverer1,
                customer,
                "Bob's Street",
                "5",
                "69696",
                "John",
                "John's Street",
                "66",
                "69697"
        );
        createOrder(
                deliverer2,
                customer,
                "Mark's Street",
                "25",
                "12364",
                "Bob",
                "Bob's Street",
                "5",
                "69696"
        );
    }

    private void createOrder(
            User deliverer,
            User customer,
            String customerStreet,
            String customerNumber,
            String customerZip,
            String deliveree,
            String deliverStreet,
            String deliverNumber,
            String deliverZip
    )
    {
        orderRepository.save(new Order(
                deliverer,
                customer,
                customerStreet,
                customerNumber,
                customerZip,
                deliveree,
                deliverStreet,
                deliverNumber,
                deliverZip
        ));
    }
*/
}
