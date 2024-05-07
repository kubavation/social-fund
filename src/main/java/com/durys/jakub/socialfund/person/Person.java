package com.durys.jakub.socialfund.person;

public class Person {

    private final PersonId personId;
    private final PersonalData personalData;
    private PersonType type;

    Person(PersonId personId, PersonalData personalData, PersonType type) {
        this.personId = personId;
        this.personalData = personalData;
        this.type = type;
    }
}
