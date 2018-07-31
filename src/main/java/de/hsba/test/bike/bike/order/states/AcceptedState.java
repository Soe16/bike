package de.hsba.test.bike.bike.order.states;

import de.hsba.test.bike.bike.order.Order;
import de.hsba.test.bike.bike.order.OrderState;

public class AcceptedState implements OrderState {

    Order orderState;

    public AcceptedState(Order newState){
        orderState = newState;
    }


    @Override
    public String getStatus() {
        return "The order was accepted and is being collected by a deliverer.";
    }

    @Override
    public void nextStatus() {
        orderState.setOrderState(orderState.getInDeliveryState());
    }

    @Override
    public void cancelOrder() {

    }
}
