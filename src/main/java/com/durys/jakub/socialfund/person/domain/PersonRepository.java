package com.durys.jakub.socialfund.person.domain;

public interface PersonRepository {
    Person load(PersonId id);
    void save(Person person);
}
