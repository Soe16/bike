package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.order.Order;

public class OrderFormAssembler { //command object pattern (Folien 17 und 80)

    OrderForm toForm(Order order) {
        OrderForm form = new OrderForm();
        form.setFromName(order.getCustomer());
        form.setFromStreetName(order.getCustomerStreet());
        form.setFromStreetNumber(order.getCustomerNumber());
        form.setFromZip(order.getCustomerZip());
        form.setToName(order.getDeliveree());
        form.setToStreetName(order.getDeliverStreet());
        form.setToStreetNumber(order.getDeliverNumber());
        form.setToZip(order.getDeliverZip());
        form.setPackageType(order.getPackageType());
        return form;
    }

    Order update(Order order, OrderForm form) {
        order.setCustomer(form.getFromName());
        order.setCustomerStreet(form.getFromStreetName());
        order.setCustomerNumber(form.getFromStreetNumber());
        order.setCustomerZip(form.getToZip());
        order.setDeliveree(form.getToName());
        order.setDeliverStreet(form.getToStreetName());
        order.setDeliverNumber(form.getToStreetNumber());
        order.setDeliverZip(form.getToZip());
        order.setPackageType(form.getPackageType());
        return order;
    }
}

