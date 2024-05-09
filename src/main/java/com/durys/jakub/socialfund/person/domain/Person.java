package com.durys.jakub.socialfund.person.domain;

import java.time.LocalDate;

public class Person {

    private final PersonId personId;
    private final PersonalData personalData;
    private PersonType type;

    Person(PersonId personId, PersonalData personalData, PersonType type) {
        this.personId = personId;
        this.personalData = personalData;
        this.type = type;
    }


    public Long age(LocalDate at) {
        return personalData.age(at);
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
