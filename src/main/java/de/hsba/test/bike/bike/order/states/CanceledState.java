package de.hsba.test.bike.bike.order.states;

import de.hsba.test.bike.bike.order.Order;
import de.hsba.test.bike.bike.order.OrderState;

public class CanceledState implements OrderState {

    Order orderState;

    public CanceledState(Order newState){
        orderState = newState;
    }


    @Override
    public String getStatus() {
        return "This order was canceled by you.";
    }

    @Override
    public void nextStatus() {

    }

    @Override
    public void cancelOrder() {

    }
}
