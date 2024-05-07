package com.durys.jakub.socialfund.person;

import com.durys.jakub.socialfund.common.DomainValidationException;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.Objects;

record PersonalData(String firstName, String lastName, LocalDate birthday) {

    public PersonalData {

        if (StringUtils.isEmpty(firstName)) {
            throw new DomainValidationException("Invalid firstName");
        }

        if (StringUtils.isEmpty(lastName)) {
            throw new DomainValidationException("Invalid lastName");
        }

        if (Objects.isNull(birthday) || birthday.isAfter(LocalDate.now())) {
            throw new DomainValidationException("Invalid birthday date");
        }

    }

}
