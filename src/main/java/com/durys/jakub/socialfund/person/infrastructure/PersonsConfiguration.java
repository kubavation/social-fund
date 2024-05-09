package com.durys.jakub.socialfund.person.infrastructure;

import com.durys.jakub.socialfund.person.domain.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonsConfiguration {

    @Bean
    public PersonRepository personRepository() {
        return new InMemoryPersonRepository();
    }

}
