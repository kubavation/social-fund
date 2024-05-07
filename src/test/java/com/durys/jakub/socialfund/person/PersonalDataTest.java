package com.durys.jakub.socialfund.person;

import com.durys.jakub.socialfund.common.DomainValidationException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonalDataTest {


    @Test
    void shouldCreatePersonalData() {
        LocalDate birthday = LocalDate.of(1990, 5, 1);
        PersonalData personalData = new PersonalData("John", "Doe", birthday);
        assertNotNull(personalData);
    }

    @Test
    void shouldNotCreatePersonalData_whenFirstNameIsNotValid() {
        LocalDate birthday = LocalDate.of(1990, 5, 1);
        assertThrows(DomainValidationException.class, () -> new PersonalData("", "Doe", birthday));
    }

    @Test
    void shouldNotCreatePersonalData_whenLastNameIsNotValid() {
        LocalDate birthday = LocalDate.of(1990, 5, 1);
        assertThrows(DomainValidationException.class, () -> new PersonalData("John", "", birthday));
    }

    @Test
    void shouldNotCreatePersonalData_whenBirthdayDateIsNotValid() {
        LocalDate birthday = LocalDate.of(2025, 5, 1);
        assertThrows(DomainValidationException.class, () -> new PersonalData("John", "Doe", birthday));
    }

    @Test
    void shouldReturnCorrectAge() {
        LocalDate birthday = LocalDate.of(1990, 5, 1);
        PersonalData personalData = new PersonalData("John", "Doe", birthday);
        LocalDate currentDate = LocalDate.of(2024, 5, 7);
        assertEquals(34L, personalData.age(currentDate));
    }

}