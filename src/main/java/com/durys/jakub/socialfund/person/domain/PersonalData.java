package com.durys.jakub.socialfund.person.domain;

import com.durys.jakub.socialfund.common.DomainValidationException;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

record PersonalData(String firstName, String lastName, LocalDate birthdayDate) {

    public PersonalData {

        if (StringUtils.isEmpty(firstName)) {
            throw new DomainValidationException("Invalid firstName");
        }

        if (StringUtils.isEmpty(lastName)) {
            throw new DomainValidationException("Invalid lastName");
        }

        if (Objects.isNull(birthdayDate) || birthdayDate.isAfter(LocalDate.now())) {
            throw new DomainValidationException("Invalid birthdayDate date");
        }

    }


    public Long age(LocalDate at) {
        return ChronoUnit.YEARS.between(birthdayDate, at);
    }

}
