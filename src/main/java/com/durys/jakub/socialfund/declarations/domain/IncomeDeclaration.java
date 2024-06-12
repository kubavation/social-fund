package com.durys.jakub.socialfund.declarations.domain;

import com.durys.jakub.socialfund.ddd.AggregateRoot;
import com.durys.jakub.socialfund.ddd.event.DomainEventsPublisher;
import com.durys.jakub.socialfund.person.domain.PersonId;

import java.time.LocalDateTime;

public class IncomeDeclaration extends AggregateRoot {

    private final IncomeGroupResolver incomeGroupResolver;

    private final DeclarationId id;
    private final PersonId personId;
    private final LocalDateTime submittedAt;
    private final Integer version;
    private final Integer year;
    private final Integer incomeGroup;

    IncomeDeclaration(DomainEventsPublisher events, IncomeGroupResolver incomeGroupResolver,
                      DeclarationId id, PersonId personId, LocalDateTime submittedAt, Integer version, Integer year, Integer incomeGroup) {
        super(events);
        this.id = id;
        this.personId = personId;
        this.submittedAt = submittedAt;
        this.version = version;
        this.year = year;
        this.incomeGroup = incomeGroup;
        this.incomeGroupResolver = incomeGroupResolver;
    }
}
