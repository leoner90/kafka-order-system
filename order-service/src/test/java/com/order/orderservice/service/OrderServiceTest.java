package com.order.orderservice.service;

import com.order.orderservice.dto.OrderRequestDto;
import com.order.orderservice.kafka.event.OrderCreatedEvent;
import com.order.orderservice.kafka.producer.OrderProducer;
import com.order.orderservice.mapper.OrderMapper;
import com.order.orderservice.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderProducer orderProducer;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void createOrder_shouldMapRequestAndSendEvent() {
        OrderRequestDto request = new OrderRequestDto(15L, "Laptop", 2);

        OrderCreatedEvent event = new OrderCreatedEvent(UUID.randomUUID(), 15L, "Laptop", 2, Instant.now());

        when(orderMapper.toEvent(request)).thenReturn(event);

        orderService.createOrder(request);

        verify(orderMapper).toEvent(request);
        verify(orderProducer).send(event);
    }
}