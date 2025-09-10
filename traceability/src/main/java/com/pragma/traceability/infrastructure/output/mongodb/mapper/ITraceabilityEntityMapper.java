package com.pragma.traceability.infrastructure.output.mongodb.mapper;

import com.pragma.traceability.domain.model.Traceability;
import com.pragma.traceability.infrastructure.output.mongodb.entity.TraceabilityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ITraceabilityEntityMapper {
    @Mapping(target = "newStatus", source = "newStatus")
    TraceabilityEntity toEntity(Traceability traceability);

    @Mapping(target = "newStatus", source = "newStatus")
    Traceability toDomain(TraceabilityEntity entity);
}
