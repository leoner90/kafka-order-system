package com.order.inventoryservice.kafka.consumer;

import com.order.inventoryservice.kafka.event.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class InventoryConsumer {

    private static final Logger log = LoggerFactory.getLogger(InventoryConsumer.class);

    @KafkaListener(topics = "order-created")
    public void consume(OrderCreatedEvent event) {
        log.info(" Processing order: OrderId: {} Product: {}   Quantity: {}", event.orderId(),  event.product(), event.quantity());
    }
}