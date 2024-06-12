package com.durys.jakub.socialfund.declarations.domain;

import java.math.BigDecimal;

public interface IncomeGroupResolver {
    Integer resolve(Long year, BigDecimal income);
}
