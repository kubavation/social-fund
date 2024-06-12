package com.durys.jakub.socialfund.declarations.domain;

import java.math.BigDecimal;

public interface IncomeGroupResolver {
    Integer resolve(Integer year, BigDecimal income);
}
