package com.durys.jakub.socialfund.person;

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
}
