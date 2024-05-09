package com.durys.jakub.socialfund.outbox;

import com.durys.jakub.socialfund.ddd.event.DomainEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

class InMemoryOutboxEventRepository implements OutboxEventRepository {


    private final ObjectMapper objectMapper;

    private static final ConcurrentMap<UUID, OutboxEvent> DB = new ConcurrentHashMap<>();

    InMemoryOutboxEventRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Override
    public void save(DomainEvent event) {
        try {
            String json = objectMapper.writeValueAsString(event);
            DB.put(event.id(), new OutboxEvent(event.id(), event.getClass(), false, json));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<DomainEvent> loadUnread() {
        return DB.values()
                .stream()
                .filter(event -> !event.read())
                .map(event -> (DomainEvent) objectMapper.convertValue(event, event.clazz()))
                .collect(Collectors.toSet());
    }
}
