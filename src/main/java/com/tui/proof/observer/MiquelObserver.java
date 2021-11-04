package com.tui.proof.observer;

import com.tui.proof.model.Order;

public class MiquelObserver implements Observer {
    @Override
    public void update(Order order) {
        System.out.println("Order received " + order);
    }
}
