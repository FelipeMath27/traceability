package com.pragma.traceability.application.mapper;

import com.pragma.traceability.application.dto.TraceabilityDTORequest;
import com.pragma.traceability.domain.model.Traceability;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ITraceabilityRequestMapper {

    Traceability toTraceability(TraceabilityDTORequest traceabilityDTORequest);
}
