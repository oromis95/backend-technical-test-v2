package com.tui.proof.service;

import com.tui.proof.model.Order;
import com.tui.proof.service.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order insertOrder(Order order) {
        Order result = orderRepository.save(order);
        return result;
    }

    public Boolean update(Order order) {
        int MS_PER_MINUTE = 60000;
        Optional<Order> itemOpt = orderRepository.findById(order.getId());

        if (itemOpt.isPresent()) {
            Date endTime = new Date(itemOpt.get().getOrderTime().getTime() + (5 * MS_PER_MINUTE));
            if (order.getOrderTime().before(endTime)) {
                Order result = orderRepository.save(order);
                if (result.getId() != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
