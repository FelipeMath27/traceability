package com.pragma.traceability.domain.spi;

import com.pragma.traceability.domain.model.Traceability;

import java.util.Optional;

public interface ITraceabilityPersistencePort {
    Traceability save(Traceability traceability);
    Optional<Traceability> findLastTraceabilityByIdOrder(Long idOrder);
}
