package com.durys.jakub.socialfund.ddd.event;

import com.durys.jakub.socialfund.outbox.OutboxEventRepository;

class OutboxDomainEventPublisher implements DomainEventsPublisher {

    private final OutboxEventRepository outboxEventRepository;

    OutboxDomainEventPublisher(OutboxEventRepository outboxEventRepository) {
        this.outboxEventRepository = outboxEventRepository;
    }

    @Override
    public void addEvent(DomainEvent event) {
        outboxEventRepository.save(event);
    }
}
