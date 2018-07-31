package de.hsba.test.bike.bike.order;

public interface OrderState {

    public String getStatus();
    public void nextStatus();
    public void cancelOrder();

}