package com.durys.jakub.socialfund.events;

import org.springframework.context.ApplicationEventPublisher;

class SpringEventPublisher implements EventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    SpringEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publish(Event event) {
        eventPublisher.publishEvent(event);
    }
}
