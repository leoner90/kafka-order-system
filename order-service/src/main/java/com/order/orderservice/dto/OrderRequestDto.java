package com.order.orderservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderRequestDto(
        @NotNull Long customerId,
        @NotBlank String product,
        @NotNull @Min(1) Integer quantity
) {}