package de.hsba.test.bike.bike.order;

import javax.persistence.*;

@Entity
@Table(name = "bestellung") //order ist ein reserviertes sql wort, daher anderer tabellenname
public class Order{

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    public int currentState; // 0 = new, 1 = accepted, 2 = inDelivery, 3 = Delivered, 4 = Canceled

    @Column(nullable = false)
    public String deliverer;

    @Column(nullable = false)
    public String customer;

    @Column(nullable = false)
    public String customerStreet;

    @Column(nullable = false)
    public String customerNumber;

    @Column(nullable = false)
    public String customerZip;

    @Column(nullable = false)
    public String deliveree;

    @Column(nullable = false)
    public String deliverStreet;

    @Column(nullable = false)
    public String deliverNumber;

    @Column(nullable = false)
    public String deliverZip;


    //setter
    public void setCurrentState(int newCurrentState) { currentState = newCurrentState; }
    public void setDeliverer(String newDeliverer){
        deliverer = newDeliverer;
    }
    public void setCustomer(String newCustomer){
        customer = newCustomer;
    }
    public void setCustomerStreet(String newCustomerStreet){
        customerStreet = newCustomerStreet;
    }
    public void setCustomerNumber(String newCustomerNumber){
        customerNumber = newCustomerNumber;
    }
    public void setCustomerZip(String newCustomerZip){
        customerZip = newCustomerZip;
    }
    public void setDeliveree(String newDeliveree){
        deliveree = newDeliveree;
    }
    public void setDeliverStreet(String newDeliverStreet){
        deliverStreet = newDeliverStreet;
    }
    public void setDeliverNumber(String newDeliverNumber){
        deliverNumber = newDeliverNumber;
    }
    public void setDeliverZip(String newDeliverZip){
        deliverZip = newDeliverZip;
    }

    //getter
    public int getCurrentState(){
        return currentState;
    }
    public String getDeliverer(){
        return deliverer;
    }
    public String getCustomer(){
        return customer;
    }
    public String getCustomerStreet(){
        return customerStreet;
    }
    public String getCustomerNumber(){
        return customerNumber;
    }
    public String getCustomerZip(){
        return customerZip;
    }
    public String getDeliveree(){
        return deliveree;
    }
    public String getDeliverStreet(){
        return deliverStreet;
    }
    public String getDeliverNumber(){
        return deliverNumber;
    }
    public String getDeliverZip(){
        return deliverZip;
    }

    //constructor

    public Order(
            String deliverer,
            String customer,
            String customerStreet,
            String customerNumber,
            String customerZip,
            String deliveree,
            String deliverStreet,
            String deliverNumber,
            String deliverZip
    ) {
        currentState = 0;
        this.deliverer = deliverer;
        this.customer = customer;
        this.customerStreet = customerStreet;
        this.customerNumber = customerNumber;
        this.customerZip = customerZip;
        this.deliveree = deliveree;
        this.deliverStreet = deliverStreet;
        this.deliverNumber = deliverNumber;
        this.deliverZip = deliverZip;
    }

    //methoden

    public void nextState() {
        if(currentState < 3) {
            currentState++;
        }
    }

    public void cancelOrder() {
        if(currentState < 3) {
            currentState = 4;
        }
    }

    public String getState() {
        switch (currentState) {
            case 0:  return "New order";
            case 1:  return "The order was accepted by a courier";
            case 2:  return "The package was picked up by the courier";
            case 3:  return "The package has been delivered succesfully";
            case 4:  return "Order canceled.";
            default: return null;
        }
    }
}
