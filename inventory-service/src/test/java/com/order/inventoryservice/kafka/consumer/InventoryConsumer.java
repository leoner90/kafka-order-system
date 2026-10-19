
package com.order.inventoryservice.kafka.consumer;

import com.order.inventoryservice.kafka.event.OrderCreatedEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(OutputCaptureExtension.class)
class InventoryConsumerTest {

    private final InventoryConsumer consumer = new InventoryConsumer();

    @Test
    void shouldLogReceivedOrder(CapturedOutput output) {
        UUID orderId = UUID.randomUUID();
        OrderCreatedEvent event = new OrderCreatedEvent(orderId, 15L, "Laptop", 2, Instant.now());

        consumer.consume(event);

        assertTrue(output.getAll().contains(orderId.toString()));
        assertTrue(output.getAll().contains("Laptop"));
        assertTrue(output.getAll().contains("2"));
    }
}
