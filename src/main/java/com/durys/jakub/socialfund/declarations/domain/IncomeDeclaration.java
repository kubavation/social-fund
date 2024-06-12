package com.durys.jakub.socialfund.declarations.domain;

import com.durys.jakub.socialfund.ddd.AggregateRoot;
import com.durys.jakub.socialfund.ddd.event.DomainEventsPublisher;
import com.durys.jakub.socialfund.person.domain.PersonId;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class IncomeDeclaration extends AggregateRoot {

    private final DeclarationId id;
    private final PersonId personId;
    private final LocalDateTime submittedAt;
    private final Integer version;
    private final Integer year;
    private final BigDecimal income;

    IncomeDeclaration(DomainEventsPublisher events, DeclarationId id, PersonId personId, LocalDateTime submittedAt, Integer version, Integer year, BigDecimal income) {
        super(events);
        this.id = id;
        this.personId = personId;
        this.submittedAt = submittedAt;
        this.version = version;
        this.year = year;
        this.income = income;
    }
}
