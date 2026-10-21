package com.order.orderservice.mapper;

import com.order.orderservice.dto.OrderRequestDto;
import com.order.orderservice.kafka.event.OrderCreatedEvent;
import java.time.Instant;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-21T11:07:23+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.12.1 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderCreatedEvent toOrderCreatedEvent(OrderRequestDto request) {
        if ( request == null ) {
            return null;
        }

        Long customerId = null;
        Integer quantity = null;

        customerId = request.customerId();
        quantity = request.quantity();

        UUID orderId = UUID.randomUUID();
        Instant createdTime = Instant.now();
        String productName = request.productName().trim();

        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent( orderId, customerId, productName, quantity, createdTime );

        return orderCreatedEvent;
    }
}
