package com.durys.jakub.socialfund.ddd.event;

public interface DomainEventsPublisher {
    void addEvent(DomainEvent event);
}
