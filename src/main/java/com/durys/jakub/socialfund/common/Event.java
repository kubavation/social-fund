package com.durys.jakub.socialfund.common;

import java.time.Instant;
import java.util.UUID;

public interface Event {
    UUID id();
    Instant at();
}
