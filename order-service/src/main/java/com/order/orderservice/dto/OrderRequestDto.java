package com.order.orderservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderRequestDto(
        @NotNull(message = "Customer ID is required")
        Long customerId,

        @NotBlank(message = "Product must not be blank")
        String product,

        @NotNull(message = "Quantity is required")
        @Min(value = 1, message = "Quantity must be at least 1")
        Integer quantity
) {}