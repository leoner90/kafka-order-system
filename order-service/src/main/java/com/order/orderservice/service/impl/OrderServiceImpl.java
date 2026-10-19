package com.order.orderservice.service.impl;

import com.order.orderservice.dto.OrderRequestDto;
import com.order.orderservice.kafka.event.OrderCreatedEvent;
import com.order.orderservice.kafka.producer.OrderProducer;
import com.order.orderservice.mapper.OrderMapper;
import com.order.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl  implements OrderService {

    private final OrderProducer orderProducer;
    private final OrderMapper orderMapper;

    @Override
    public void createOrder(OrderRequestDto request) {
        OrderCreatedEvent event = orderMapper.toEvent(request); //kafka "dto"
        log.info("Creating order: orderId={}, customerId={}", event.orderId(), event.customerId());
        orderProducer.send(event);
    }
}
