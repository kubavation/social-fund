package com.durys.jakub.socialfund.person.domain;

import com.durys.jakub.socialfund.ddd.AggregateRoot;
import com.durys.jakub.socialfund.ddd.event.DomainEventsPublisher;

import java.time.LocalDate;

public class Person extends AggregateRoot {

    private final PersonId personId;
    private final PersonalData personalData;
    private PersonType type;

    Person(DomainEventsPublisher events, PersonId personId, PersonalData personalData, PersonType type) {
        super(events);
        this.personId = personId;
        this.personalData = personalData;
        this.type = type;
    }


    public PersonId id() {
        return personId;
    }

    public Long age(LocalDate at) {
        return personalData.age(at);
    }

    public boolean is(PersonType type) {
        return this.type == type;
    }

    public boolean isEmployee() {
        return type == PersonType.Employee;
    }

    public boolean isFormerEmployee() {
        return type == PersonType.FormerEmployee;
    }

    public boolean isChild() {
        return type == PersonType.Child;
    }

    public boolean isPensioner() {
        return type == PersonType.Pensioner;
    }
}
