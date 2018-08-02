package de.hsba.test.bike.bike.order;

import de.hsba.test.bike.bike.order.states.*;

public class Order implements OrderState{


    //Attribute
    String id;
    String deliverer;

    String customer;
    String customerStreet;
    String customerNumber;
    String customerZip;

    String deliveree;
    String deliverStreet;
    String deliverNumber;
    String deliverZip;

    //Attribut-setter
    public void setId(String newId){
        id = newId;
    }
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

    //Attribut-getter
    public String getId(){
        return id;
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

    //Zustände definieren
    OrderState newState;
    OrderState acceptedState;
    OrderState inDeliveryState;
    OrderState deliveredState;
    OrderState canceledState;

    //gespeicherter Zustand
    OrderState orderState;

    //constructor
    public Order() {
        //Zustände initialisieren
        newState = new NewState(this);
        acceptedState = new AcceptedState(this);
        inDeliveryState = new InDeliveryState(this);
        deliveredState = new DeliveredState(this);
        canceledState = new CanceledState(this);

        //Ausgangszustand
        orderState = newState;
    }


    //State - getter
    public OrderState getNewState() { return newState; }
    public OrderState getAcceptedState() { return acceptedState; }
    public OrderState getInDeliveryState() { return inDeliveryState; }
    public OrderState getDeliveredState() { return deliveredState; }
    public OrderState getCanceledState() { return canceledState; }

    //State - setter
    public void setOrderState(OrderState newOrderState) {
        orderState = newOrderState;
    }

    //Methoden
    public void newOrder() {
        setOrderState(newState);
    }

    public String getStatus() {
        return orderState.getStatus();
    }

    public void nextStatus() {
        orderState.nextStatus();
    }

    public void cancelOrder() {
        orderState.cancelOrder();
    }

}