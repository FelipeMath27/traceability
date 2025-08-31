package com.pragma.traceability.domain.usecase;


import com.pragma.traceability.domain.api.ITraceabilityServicePort;
import com.pragma.traceability.domain.exception.DomainException;
import com.pragma.traceability.domain.model.StatusOrder;
import com.pragma.traceability.domain.model.Traceability;
import com.pragma.traceability.domain.spi.ITraceabilityPersistencePort;
import com.pragma.traceability.domain.utils.ConstantsErrorMessages;
import com.pragma.traceability.domain.validator.StatusOrderValidators;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Slf4j
public class UseCaseTraceability implements ITraceabilityServicePort {

    private final ITraceabilityPersistencePort iTraceabilityPersistencePort;
    private static final StatusOrderValidators statusOrderValidators = new StatusOrderValidators();

    @Override
    public Traceability saveTraceability(Traceability traceability) {
        return iTraceabilityPersistencePort.findLastTraceabilityByIdOrder(traceability.getIdOrder())
                .map(lastTraceability -> {
                    StatusOrder previous = lastTraceability.getNewStatus();
                    StatusOrder next = traceability.getNewStatus();

                    if(!statusOrderValidators.isValidTransition(previous, next)) {
                        throw new DomainException(ConstantsErrorMessages.STATUS_INVALID_TO_CREATE_TRACEABILITY);
                    }

                    return persistTraceability(traceability, previous);
                })
                .orElseGet(() -> {
                    if(!StatusOrder.PENDING.equals(traceability.getNewStatus())) {
                        throw new DomainException(ConstantsErrorMessages.FIRST_TRACEABILITY_MUST_BE_PENDING);
                    }

                    return persistTraceability(traceability, null);
                });
    }

    private Traceability persistTraceability(Traceability traceability, StatusOrder previous) {
        traceability.setPreviousStatus(previous);
        traceability.setDateTraceability(LocalDateTime.now());
        return iTraceabilityPersistencePort.save(traceability);
    }
}
