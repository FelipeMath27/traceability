package com.pragma.traceability.application.mapper;

import com.pragma.traceability.application.dto.TraceabilityDTOResponse;
import com.pragma.traceability.domain.model.Traceability;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ITraceabilityResponseMapper {
    TraceabilityDTOResponse toTraceabilityDTOResponse(Traceability traceability);
}
