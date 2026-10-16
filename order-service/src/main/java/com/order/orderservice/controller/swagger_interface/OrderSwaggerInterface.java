package com.order.orderservice.controller.swagger_interface;

import com.order.orderservice.dto.OrderRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderSwaggerInterface {
    @PostMapping("/orders")
    @Operation(summary = "Create an order", description = "Creates an order and publishes an event to Kafka.")

    @ApiResponse(responseCode = "201", description = "Order created")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "500", description = "Internal server error")

    ResponseEntity<Void> createOrder(@Valid @RequestBody OrderRequestDto request);
}