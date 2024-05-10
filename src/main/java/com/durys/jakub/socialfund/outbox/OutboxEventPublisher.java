package com.durys.jakub.socialfund.outbox;

import com.durys.jakub.socialfund.events.EventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
class OutboxEventPublisher {

    private final OutboxEventRepository outboxEventRepository;
    private final EventPublisher eventPublisher;

    OutboxEventPublisher(OutboxEventRepository outboxEventRepository, EventPublisher eventPublisher) {
        this.outboxEventRepository = outboxEventRepository;
        this.eventPublisher = eventPublisher;
    }

    @Scheduled(fixedDelayString = "${outbox.delay}")
    void publish() {
        outboxEventRepository.loadUnread()
                .stream()
                .forEach(eventPublisher::publish);
    }

}
