package com.durys.jakub.socialfund.person;

public interface PersonRepository {
    Person load(PersonId id);
    void save(Person person);
}
