package com.order.orderservice.service;

import com.order.orderservice.dto.OrderRequestDto;
import com.order.orderservice.kafka.event.OrderCreatedEvent;
import com.order.orderservice.kafka.producer.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderProducer orderProducer;

    public void createOrder(OrderRequestDto request) {
        //kafka dto
        OrderCreatedEvent event = new OrderCreatedEvent(
                UUID.randomUUID(),
                request.customerId(),
                request.product(),
                request.quantity(),
                Instant.now()
        );

        orderProducer.send(event);
    }
}