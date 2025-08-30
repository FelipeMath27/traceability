package com.pragma.traceability.application.handler;

import com.pragma.traceability.application.dto.TraceabilityDTORequest;
import com.pragma.traceability.application.dto.TraceabilityDTOResponse;
import com.pragma.traceability.application.mapper.ITraceabilityRequestMapper;
import com.pragma.traceability.application.mapper.ITraceabilityResponseMapper;
import com.pragma.traceability.domain.api.ITraceabilityServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TraceabilityHandler implements ITraceabilityHandler{
    private final ITraceabilityRequestMapper iTraceabilityRequestMapper;
    private final ITraceabilityResponseMapper iTraceabilityResponseMapper;
    private final ITraceabilityServicePort iTraceabilityServicePort;

    @Override
    public TraceabilityDTOResponse saveTraceability(TraceabilityDTORequest traceabilityDTORequest) {
        return iTraceabilityResponseMapper.toTraceabilityDTOResponse(
                iTraceabilityServicePort.saveTraceability(
                        iTraceabilityRequestMapper.toTraceability(traceabilityDTORequest)
                ));
    }

    @Override
    public TraceabilityDTOResponse getTraceabilityByOrderId(Long orderId) {
        return null;
    }

    @Override
    public List<TraceabilityDTOResponse> getAllTraceabilityByIdOrder(Long orderId) {
        return List.of();
    }
}
