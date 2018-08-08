package de.hsba.test.bike.bike.order;

import de.hsba.test.bike.bike.order.states.*;

import javax.persistence.*;

/*
@Entity
*/
public class Order implements OrderState{

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


    //Attribut-setter
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

    //Attribut-getter
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
        currentState = 0;
        orderState = newState;
    }


    //State - getter
    public OrderState getNewState() {
        setCurrentState(0);
        return newState; }
    public OrderState getAcceptedState() {
        setCurrentState(1);
        return acceptedState; }
    public OrderState getInDeliveryState() {
        setCurrentState(2);
        return inDeliveryState; }
    public OrderState getDeliveredState() {
        setCurrentState(3);
        return deliveredState; }
    public OrderState getCanceledState() {
        setCurrentState(4);
        return canceledState; }

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

    public void loadStatus(int currentState) {
        switch (currentState) {
            case 0:
                setOrderState(getNewState());
                break;
            case 1:
                setOrderState(getAcceptedState());
                break;
            case 2:
                setOrderState(getInDeliveryState());
                break;
            case 3:
                setOrderState(getDeliveredState());
                break;
            case 4:
                setOrderState(getCanceledState());
                break;
        }
    }

}
