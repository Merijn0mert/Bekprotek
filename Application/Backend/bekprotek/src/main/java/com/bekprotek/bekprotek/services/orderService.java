package com.bekprotek.bekprotek.services;

import com.bekprotek.bekprotek.controllers.*;
import com.bekprotek.bekprotek.repositories.*;
import com.bekprotek.bekprotek.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Optional;
import java.util.*;

@Service
public class orderService {

    private orderRepository orderrepo;

    @Autowired
    public orderService(orderRepository orderrepo) {
        this.orderrepo = orderrepo;
    }


    public Collection<orderEntity> getOrders() {
        return orderrepo.findAll();
    }

    public Optional<orderEntity> getOrder(Long id) {
        return orderrepo.findById(id);
    }

    public orderEntity saveOrder(orderEntity order) {
        return orderrepo.save(order);
    }

}