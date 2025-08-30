package com.pragma.traceability.infrastructure.output.mongodb.adapter;

import com.pragma.traceability.domain.exception.DomainException;
import com.pragma.traceability.domain.model.Traceability;
import com.pragma.traceability.domain.spi.ITraceabilityPersistencePort;
import com.pragma.traceability.domain.utils.ConstantsErrorMessages;
import com.pragma.traceability.infrastructure.output.mongodb.mapper.ITraceabilityEntityMapper;
import com.pragma.traceability.infrastructure.output.mongodb.repository.ITraceabilityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class TraceabilityMongoAdapter implements ITraceabilityPersistencePort {
    private final ITraceabilityRepository iTraceabilityRepository;
    private final ITraceabilityEntityMapper iTraceabilityEntityMapper;


    @Override
    public Traceability save(Traceability traceability) {
        return Optional.ofNullable(traceability)
                .map(iTraceabilityEntityMapper::toEntity)
                .map(iTraceabilityRepository::save)
                .map(iTraceabilityEntityMapper::toTraceability)
                .orElseThrow(()-> new DomainException(ConstantsErrorMessages.FAILED_TO_SAVE_TRACEABILITY));
    }

    @Override
    public Optional<Traceability> findLastTraceabilityByIdOrder(Long idOrder) {
        return iTraceabilityRepository.findTopByIdOrderOrderByDateDesc(idOrder)
                .map(iTraceabilityEntityMapper::toTraceability);
    }
}
