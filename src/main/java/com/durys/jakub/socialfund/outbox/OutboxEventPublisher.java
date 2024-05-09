package com.durys.jakub.socialfund.outbox;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
class OutboxEventPublisher {

    private final OutboxEventRepository outboxEventRepository;

    OutboxEventPublisher(OutboxEventRepository outboxEventRepository) {
        this.outboxEventRepository = outboxEventRepository;
    }

    @Scheduled(fixedDelayString = "${outbox.delay}")
    void publish() {
        outboxEventRepository.loadUnread()
                .stream()
                .forEach(s -> System.out.println("todo publisher"));
    }

}
