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
@RequestMapping("/products")
public class productController {

    private final productService service;

    @Autowired
    public productController (productService service)
    {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);

    }


    @GetMapping("/{id}")
    public ResponseEntity<productEntity> getProduct(@PathVariable("id") Long id) {
        Optional<productEntity> optionalProduct = service.getProduct(id);

        if (optionalProduct.isPresent()) {
            productEntity product = optionalProduct.get();
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addproduct")
    public ResponseEntity<productEntity> createProduct(@RequestBody productEntity product) {
        try {
            productEntity savedProduct = service.saveProduct(product);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}