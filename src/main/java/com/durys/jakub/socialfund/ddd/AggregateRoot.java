package com.durys.jakub.socialfund.ddd;

import com.durys.jakub.socialfund.ddd.event.DomainEvent;
import com.durys.jakub.socialfund.ddd.event.DomainEventsPublisher;

public abstract class AggregateRoot {

    protected final DomainEventsPublisher events;

    protected AggregateRoot(DomainEventsPublisher events) {
        this.events = events;
    }

    protected void addEvent(DomainEvent event) {
        events.addEvent(event);
    }
}
