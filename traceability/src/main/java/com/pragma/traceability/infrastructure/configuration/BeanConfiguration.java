package com.pragma.traceability.infrastructure.configuration;


import com.pragma.traceability.domain.api.ITraceabilityServicePort;
import com.pragma.traceability.domain.spi.ITraceabilityPersistencePort;
import com.pragma.traceability.domain.usecase.UseCaseTraceability;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {
    private final ITraceabilityPersistencePort iTraceabilityPersistencePort;

    @Bean
    public ITraceabilityServicePort iTraceabilityServicePort(ITraceabilityPersistencePort iTraceabilityPersistencePort){;
        return new UseCaseTraceability(iTraceabilityPersistencePort);
    }
}
