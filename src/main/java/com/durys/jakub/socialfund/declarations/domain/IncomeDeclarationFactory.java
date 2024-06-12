package com.durys.jakub.socialfund.declarations.domain;

import com.durys.jakub.socialfund.ddd.event.DomainEventsPublisher;
import com.durys.jakub.socialfund.person.domain.PersonId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class IncomeDeclarationFactory {

    private final DomainEventsPublisher eventsPublisher;
    private final IncomeGroupResolver incomeGroupResolver;

    public static IncomeDeclarationFactory instance(DomainEventsPublisher eventsPublisher, IncomeGroupResolver incomeGroupResolver) {
        return new IncomeDeclarationFactory(eventsPublisher, incomeGroupResolver);
    }

    IncomeDeclarationFactory(DomainEventsPublisher eventsPublisher, IncomeGroupResolver incomeGroupResolver) {
       this.eventsPublisher = eventsPublisher;
       this.incomeGroupResolver = incomeGroupResolver;
    }


    public IncomeDeclaration create(PersonId personId, Integer year, BigDecimal income) {
        return new IncomeDeclaration(eventsPublisher, incomeGroupResolver,
                new DeclarationId(UUID.randomUUID()),
                personId, LocalDateTime.now(), year, income);
    }

}
