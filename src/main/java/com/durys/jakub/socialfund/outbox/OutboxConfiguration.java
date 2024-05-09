package com.durys.jakub.socialfund.outbox;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OutboxConfiguration {


    @Bean
    public OutboxEventRepository outboxEventRepository(ObjectMapper objectMapper) {
        return new InMemoryOutboxEventRepository(objectMapper);
    }

}
