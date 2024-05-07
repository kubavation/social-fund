package com.durys.jakub.socialfund.person.domain;

import com.durys.jakub.socialfund.common.DomainValidationException;

import java.util.Objects;
import java.util.UUID;

public record PersonId(UUID value) {

    public PersonId {

        if (Objects.isNull(value)) {
            throw new DomainValidationException("Invalid personId value");
        }

    }

}
