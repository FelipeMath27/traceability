package com.pragma.traceability.infrastructure.output.mongodb.mapper;

import com.pragma.traceability.domain.model.Traceability;
import com.pragma.traceability.infrastructure.output.mongodb.entity.TraceabilityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ITraceabilityEntityMapper {
    TraceabilityEntity toEntity(Traceability traceability);

    Traceability toTraceability(TraceabilityEntity traceabilityEntity);
}
