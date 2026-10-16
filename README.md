\# Kafka Order System



A simple event-driven microservices application for order processing, inventory management, and email notifications.







\## Project Start Up

* Rename .env.example to just .env and replace user name and password in both microservices "Order" \&\& "Inventory"
* Start Kafka server on 9092 port
* Start All 3 microservices
* Postman Post , JSON{}







\## Technologies



\- \*\*Java 21\*\*

\- \*\*Spring Boot 4\*\*

\- \*\*Spring Data JPA / Hibernate\*\*

\- \*\*Apache Kafka 4.3.1\*\* — asynchronous communication between microservices

\- \*\*MySQL 8+\*\* — database

\- \*\*JavaMailSender\*\* — email notifications

\- \*\*Gradle\*\* — build automation

\- \*\*JUnit 5 / Mockito\*\* — testing









\## Microservices



\- \*\*Order Service\*\* — handles order creation and status updates.

\- \*\*Inventory Service\*\* — manages product stock and availability.

\- \*\*Notification Service\*\* — sends email notifications based on Kafka events.







\## Environment/.env Variables

username: ${DB\_USERNAME}

password: ${DB\_PASSWORD}

