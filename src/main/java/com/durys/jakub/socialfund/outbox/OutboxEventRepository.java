package com.durys.jakub.socialfund.outbox;

import com.durys.jakub.socialfund.ddd.event.DomainEvent;

import java.util.Set;

public interface OutboxEventRepository {
    void save(DomainEvent event);
    Set<DomainEvent> loadUnread();
}
