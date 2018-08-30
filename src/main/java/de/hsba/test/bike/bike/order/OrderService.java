package de.hsba.test.bike.bike.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;


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

/*
    // Beispiel Order für Datenbank Bestellung
    @PostConstruct
    public void init() {

        if (orderRepository.count() == 0) {
            //siehe interface
            createOrder( "1","Peter", "hallo", "12", "22359", "Patrick", "hello", "23", "22359");
        }
    }
    //User user hinzufügen wegen Owner?
    private void createOrder(String ownerId, String customer, String customerStreet, String customerNumber, String customerZip, String deliveree, String deliverStreet, String deliverNumber, String deliverZip) {
        orderRepository.save(new Order(customer, customerStreet, customerNumber, customerZip, deliveree, deliverStreet, deliverNumber, deliverZip));
    }

    */


    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        this.orderRepository.deleteById(id);
    }

    public Order findOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findNewOrders() {
        return orderRepository.findNewOrders();
    }

}

