package com.pragma.traceability.infrastructure.output.mongodb.repository;

import com.pragma.traceability.domain.model.StatusOrder;
import com.pragma.traceability.infrastructure.output.mongodb.entity.TraceabilityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ITraceabilityRepository extends MongoRepository<TraceabilityEntity, String> {
    List<TraceabilityEntity> findByIdOrder(Long idOrder);
    Optional<TraceabilityEntity> findTopByIdOrderOrderByDateTraceabilityDesc(Long idOrder);
    Optional<TraceabilityEntity> findFirstByIdOrderAndNewStatus(Long idOrder, StatusOrder newStatus);
}
