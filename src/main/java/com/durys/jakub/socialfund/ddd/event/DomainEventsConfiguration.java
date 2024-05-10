package com.durys.jakub.socialfund.ddd.event;

import com.durys.jakub.socialfund.outbox.OutboxEventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainEventsConfiguration {

    @Bean
    public DomainEventsPublisher domainEventsPublisher(OutboxEventRepository outboxEventRepository) {
        return new OutboxDomainEventPublisher(outboxEventRepository);
    }

}
