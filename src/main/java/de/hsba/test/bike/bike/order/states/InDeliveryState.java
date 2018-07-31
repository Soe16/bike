package de.hsba.test.bike.bike.order.states;

import de.hsba.test.bike.bike.order.Order;
import de.hsba.test.bike.bike.order.OrderState;

public class InDeliveryState implements OrderState {

    Order orderState;

    public InDeliveryState(Order newState){
        orderState = newState;
    }


    @Override
    public String getStatus() {
        return "The order was collected by a deliverer and is currently in delivery.";
    }

    @Override
    public void nextStatus() {
        orderState.setOrderState(orderState.getDeliveredState());
    }

    @Override
    public void cancelOrder() {

    }
}
