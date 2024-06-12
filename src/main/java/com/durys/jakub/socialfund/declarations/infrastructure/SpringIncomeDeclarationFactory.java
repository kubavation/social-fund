package com.durys.jakub.socialfund.declarations.infrastructure;

import com.durys.jakub.socialfund.ddd.event.DomainEventsPublisher;
import com.durys.jakub.socialfund.declarations.domain.DeclarationId;
import com.durys.jakub.socialfund.declarations.domain.IncomeDeclaration;
import com.durys.jakub.socialfund.declarations.domain.IncomeDeclarationFactory;
import com.durys.jakub.socialfund.declarations.domain.IncomeGroupResolver;
import com.durys.jakub.socialfund.person.domain.PersonId;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class SpringIncomeDeclarationFactory implements IncomeDeclarationFactory {

    private final DomainEventsPublisher eventsPublisher;
    private final IncomeGroupResolver incomeGroupResolver;

    SpringIncomeDeclarationFactory(DomainEventsPublisher eventsPublisher, IncomeGroupResolver incomeGroupResolver) {
        this.eventsPublisher = eventsPublisher;
        this.incomeGroupResolver = incomeGroupResolver;
    }

    public IncomeDeclaration create(PersonId personId, Integer year, BigDecimal income) {
        return new IncomeDeclaration(eventsPublisher, incomeGroupResolver,
                new DeclarationId(UUID.randomUUID()),
                personId, LocalDateTime.now(), year, income);
    }


}
