package de.hsba.test.bike.bike.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void init(){
        createOrder(
                "Deliver Inc. Co. KG",
                "Bob",
                "Bob's Street",
                "5",
                "69696",
                "John",
                "John's Street",
                "66",
                "69697"
        );
        createOrder(
                "Kuriere 2000 Inc. Co. KG",
                "Mark",
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
        String deliverer,
        String customer,
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

}
