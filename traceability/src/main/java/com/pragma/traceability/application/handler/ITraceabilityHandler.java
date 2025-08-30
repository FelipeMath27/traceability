package com.pragma.traceability.application.handler;

import com.pragma.traceability.application.dto.TraceabilityDTORequest;
import com.pragma.traceability.application.dto.TraceabilityDTOResponse;

import java.util.List;

public interface ITraceabilityHandler {
    TraceabilityDTOResponse saveTraceability(TraceabilityDTORequest traceabilityDTORequest);

    TraceabilityDTOResponse getTraceabilityByOrderId(Long orderId);

    List<TraceabilityDTOResponse> getAllTraceabilityByIdOrder(Long orderId);

}
