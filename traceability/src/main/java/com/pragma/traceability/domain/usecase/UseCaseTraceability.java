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
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
public class UseCaseTraceability implements ITraceabilityServicePort {

    private final ITraceabilityPersistencePort iTraceabilityPersistencePort;
    private static final StatusOrderValidators statusOrderValidators = new StatusOrderValidators();

    @Override
    public Traceability saveTraceability(Traceability traceability) {
        Optional<Traceability> lastTraceability = iTraceabilityPersistencePort.findLastTraceabilityByIdOrder(traceability.getIdOrder());
        if (lastTraceability.isPresent()){
            Traceability lastTrace = lastTraceability.get();
            StatusOrder previous = lastTrace.getNewStatus();
            StatusOrder next = traceability.getNewStatus();

            if (!statusOrderValidators.isValidTransition(previous,next)){
                throw new DomainException(ConstantsErrorMessages.STATUS_INVALID_TO_CREATE_TRACEABILITY);
            }

            if(next == StatusOrder.DELIVERED){
                Traceability pendingTrace = iTraceabilityPersistencePort
                        .getTraceabilityByIdOrderAndStatus(traceability.getIdOrder(),StatusOrder.PENDING)
                        .orElseThrow(() -> new DomainException(ConstantsErrorMessages.NOT_FOUND_ORIGIN_TRACEABILITY_PENDING));
                traceability.setStartOrderTraceability(pendingTrace.getStartOrderTraceability());
            }

            return persistTraceability(traceability,traceability.getNewStatus());
        } else {
            traceability.setStartOrderTraceability(LocalDateTime.now());
            return persistTraceability(traceability,StatusOrder.PENDING);
        }
    }

    private Traceability persistTraceability(Traceability traceability, StatusOrder status) {
        traceability.setNewStatus(status);
        log.info(String.valueOf(traceability.getNewStatus()));
        traceability.setDateTraceability(LocalDateTime.now());
        log.info(">>> Traceability to save: {}", String.valueOf(traceability));
        return iTraceabilityPersistencePort.save(traceability);
    }
}
