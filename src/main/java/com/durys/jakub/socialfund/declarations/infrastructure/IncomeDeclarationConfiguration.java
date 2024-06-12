package com.durys.jakub.socialfund.declarations.infrastructure;

import com.durys.jakub.socialfund.ddd.event.DomainEventsPublisher;
import com.durys.jakub.socialfund.declarations.domain.IncomeDeclarationFactory;
import com.durys.jakub.socialfund.declarations.domain.IncomeGroupResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IncomeDeclarationConfiguration {

    @Bean
    public IncomeGroupResolver incomeGroupResolver() {
        return new InMemoryIncomeGroupResolver();
    }

    @Bean
    public IncomeDeclarationFactory incomeDeclarationFactory(DomainEventsPublisher eventsPublisher, IncomeGroupResolver incomeGroupResolver) {
        return new SpringIncomeDeclarationFactory(eventsPublisher, incomeGroupResolver);
    }
}
