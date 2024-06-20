package com.bekprotek.bekprotek.controllers;

import org.springframework.web.bind.annotation.*;
import com.bekprotek.bekprotek.entities.*;
import com.bekprotek.bekprotek.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/orders")
public class orderController {

    private final orderService service;

    @Autowired
    public orderController (orderService service)
    {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> getOrders() {
        return new ResponseEntity<>(service.getOrders(), HttpStatus.OK);

    }


    @GetMapping("/{id}")
    public ResponseEntity<orderEntity> getOrder(@PathVariable("id") Long id) {
        Optional<orderEntity> optionalOrder = service.getOrder(id);

        if (optionalOrder.isPresent()) {
            orderEntity order = optionalOrder.get();
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addorder")
    public ResponseEntity<orderEntity> createOrder(@RequestBody orderEntity order) {
        try {
            orderEntity savedOrder = service.saveOrder(order);
            return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}