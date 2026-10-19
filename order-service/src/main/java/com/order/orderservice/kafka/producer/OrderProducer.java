package com.order.orderservice.kafka.producer;

import com.order.orderservice.kafka.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public void send(OrderCreatedEvent event) {
        kafkaTemplate.send("order-created", event.orderId().toString(), event)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        log.error("Failed to publish order: orderId={}", event.orderId(), ex);
                    } else {
                        log.info("Order published to Kafka: orderId={}, topic={}", event.orderId(), result.getRecordMetadata().topic());
                    }
                });
    }
}