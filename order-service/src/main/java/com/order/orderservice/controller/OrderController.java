package com.order.orderservice.controller;

import com.order.orderservice.controller.swagger_interface.OrderSwaggerInterface;
import com.order.orderservice.dto.OrderRequestDto;
import com.order.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController implements OrderSwaggerInterface {

    private final OrderService orderService;

    @Override
    public ResponseEntity<Void> createOrder(OrderRequestDto request) {
        log.info("Received order request: customerId={}, product={}, quantity={}", request.customerId(), request.product(), request.quantity());
        orderService.createOrder(request);
        return ResponseEntity.status(201).build();
    }
}
