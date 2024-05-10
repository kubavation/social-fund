package com.durys.jakub.socialfund.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventsConfiguration {

    @Bean
    public EventPublisher eventPublisher(ApplicationEventPublisher eventPublisher) {
        return new SpringEventPublisher(eventPublisher);
    }

}
