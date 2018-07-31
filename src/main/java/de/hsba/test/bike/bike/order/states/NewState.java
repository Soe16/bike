package de.hsba.test.bike.bike.order.states;

import de.hsba.test.bike.bike.order.Order;
import de.hsba.test.bike.bike.order.OrderState;

public class NewState implements OrderState {

    Order orderState;

    public NewState(Order newState){
        orderState = newState;
    }


    @Override
    public String getStatus() {
        return "The order is awaiting to be accepted by a deliverer.";
    }

    @Override
    public void nextStatus() {
        orderState.setOrderState(orderState.getAcceptedState());
    }

    @Override
    public void cancelOrder() {
        orderState.setOrderState(orderState.getCanceledState());
    }
}
