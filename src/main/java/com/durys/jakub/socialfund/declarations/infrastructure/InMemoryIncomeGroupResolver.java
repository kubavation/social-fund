package com.durys.jakub.socialfund.declarations.infrastructure;

import com.durys.jakub.socialfund.declarations.domain.IncomeGroupResolver;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InMemoryIncomeGroupResolver implements IncomeGroupResolver {

    @Override
    public Integer resolve(Integer year, BigDecimal income) {
        return 2;
    }
}
