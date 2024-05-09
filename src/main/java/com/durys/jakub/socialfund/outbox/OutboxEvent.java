package com.durys.jakub.socialfund.outbox;

import java.util.UUID;

record OutboxEvent(UUID id, Class<?> clazz, boolean read, String object) {
}
