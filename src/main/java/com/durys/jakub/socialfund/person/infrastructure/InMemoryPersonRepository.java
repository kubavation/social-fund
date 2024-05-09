package com.durys.jakub.socialfund.person.infrastructure;

import com.durys.jakub.socialfund.person.domain.Person;
import com.durys.jakub.socialfund.person.domain.PersonId;
import com.durys.jakub.socialfund.person.domain.PersonRepository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class InMemoryPersonRepository implements PersonRepository {

    private static final ConcurrentMap<PersonId, Person> DB = new ConcurrentHashMap<>();

    @Override
    public Person load(PersonId id) {
        return DB.get(id);
    }

    @Override
    public void save(Person person) {
        DB.put(person.id(), person);
    }
}
