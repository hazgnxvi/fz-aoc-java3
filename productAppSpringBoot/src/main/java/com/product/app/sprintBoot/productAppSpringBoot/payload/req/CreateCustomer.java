package com.product.app.sprintBoot.productAppSpringBoot.payload.req;

import lombok.Data;

@Data
public class CreateCustomer {
    private String firstName;
    private String lastName;
    private String email;
}
