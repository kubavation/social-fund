package com.durys.jakub.socialfund.declarations.domain;

import com.durys.jakub.socialfund.person.domain.PersonId;

import java.math.BigDecimal;

public interface IncomeDeclarationFactory {

    IncomeDeclaration create(PersonId personId, Integer year, BigDecimal income);
}
