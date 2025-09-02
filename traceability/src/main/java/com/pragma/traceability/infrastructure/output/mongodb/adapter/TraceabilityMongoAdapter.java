package com.pragma.traceability.infrastructure.output.mongodb.adapter;

import com.pragma.traceability.domain.exception.DomainException;
import com.pragma.traceability.domain.model.Traceability;
import com.pragma.traceability.domain.spi.ITraceabilityPersistencePort;
import com.pragma.traceability.domain.utils.ConstantsErrorMessages;
import com.pragma.traceability.infrastructure.output.mongodb.entity.TraceabilityEntity;
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
        TraceabilityEntity entity = iTraceabilityEntityMapper.toEntity(traceability);
        TraceabilityEntity saved = iTraceabilityRepository.save(entity);
        return iTraceabilityEntityMapper.toDomain(saved);
    }

    @Override
    public Optional<Traceability> findLastTraceabilityByIdOrder(Long idOrder) {
        return iTraceabilityRepository.findTopByIdOrderOrderByDateTraceabilityDesc(idOrder)
                .map(iTraceabilityEntityMapper::toDomain);
    }
}
