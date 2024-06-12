package com.durys.jakub.socialfund.declarations.domain;

import com.durys.jakub.socialfund.common.DomainValidationException;
import com.durys.jakub.socialfund.ddd.AggregateRoot;
import com.durys.jakub.socialfund.ddd.event.DomainEventsPublisher;
import com.durys.jakub.socialfund.person.domain.PersonId;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class IncomeDeclaration extends AggregateRoot {

    public enum State {
        Draft, Submitted, Accepted, Rejected
    }

    private final IncomeGroupResolver incomeGroupResolver;

    private final DeclarationId id;
    private final PersonId personId;
    private final LocalDateTime submittedAt;
    private Integer version;
    private final Integer year;
    private Integer incomeGroup;
    private BigDecimal income;
    private State state;

    public IncomeDeclaration(DomainEventsPublisher events, IncomeGroupResolver incomeGroupResolver,
                      DeclarationId id, PersonId personId, LocalDateTime submittedAt, Integer year, BigDecimal income) {
        super(events);
        this.id = id;
        this.personId = personId;
        this.submittedAt = submittedAt;
        this.year = year;
        this.income = income;
        this.incomeGroupResolver = incomeGroupResolver;
    }

    public void saveDraft() {

        if (state != State.Draft) {
            throw new DomainValidationException("Invalid state for this operation");
        }

        incomeGroup = incomeGroupResolver.resolve(year, income);

        //todo event
    }

    public void submit() {

        if (state != State.Draft) {
            throw new DomainValidationException("Invalid state for this operation");
        }

        state = State.Submitted;

        //todo event
    }

}
