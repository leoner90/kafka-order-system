package com.order.orderservice.kafka.producer;

import com.order.orderservice.kafka.event.OrderCreatedEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.Instant;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class OrderProducerTest {

    @Mock
    private KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    @InjectMocks
    private OrderProducer orderProducer;

    @Test
    void shouldSendOrderCreatedEventToKafka() {
        UUID orderId = UUID.randomUUID();
        OrderCreatedEvent event = new OrderCreatedEvent(orderId, 1L, "Laptop", 2, Instant.now());

        orderProducer.send(event);

        verify(kafkaTemplate).send(eq("order-created"), eq(orderId.toString()), same(event));
        verifyNoMoreInteractions(kafkaTemplate);
    }
}