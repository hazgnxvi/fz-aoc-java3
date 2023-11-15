package com.product.app.sprintBoot.productAppSpringBoot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.product.app.sprintBoot.productAppSpringBoot.payload.req.CreateCustomer;

public class CustomerController {
    @PostMapping("/customer/create")
    public ResponseEntity<CreateCustomer> customerPost(@RequestBody CreateCustomer payload) {
        // code
        return null;
    }
}
