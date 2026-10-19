package com.order.orderservice.mapper;

import com.order.orderservice.dto.OrderRequestDto;
import com.order.orderservice.kafka.event.OrderCreatedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper
{
    @Mapping(target = "orderId", expression = "java(UUID.randomUUID())")
    @Mapping(target = "createdTime", expression = "java(Instant.now())")
    OrderCreatedEvent toEvent(OrderRequestDto request);
}
