package de.hsba.test.bike.bike.order.states;

import de.hsba.test.bike.bike.order.Order;
import de.hsba.test.bike.bike.order.OrderState;

public class DeliveredState implements OrderState {

    Order orderState;

    public DeliveredState(Order newState){
        orderState = newState;
    }


    @Override
    public String getStatus() {
        return "The order was successfully delivered to the destination.";
    }

    @Override
    public void nextStatus() {

    }

    @Override
    public void cancelOrder() {

    }
}
