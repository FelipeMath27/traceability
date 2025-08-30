package com.pragma.traceability.infrastructure.input.rest;

import com.pragma.traceability.application.dto.TraceabilityDTORequest;
import com.pragma.traceability.application.dto.TraceabilityDTOResponse;
import com.pragma.traceability.application.handler.ITraceabilityHandler;
import com.pragma.traceability.infrastructure.constant.ConstantInfrastructure;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/traceability")
@Slf4j
public class TraceabilityRestController {
    private final ITraceabilityHandler iTraceabilityHandler;

    @PostMapping
    public ResponseEntity<TraceabilityDTOResponse> createTraceability(@Valid @RequestBody TraceabilityDTORequest traceabilityDTORequest) {
        log.info(ConstantInfrastructure.LISTENER_CONTROLLER_START);
        TraceabilityDTOResponse traceabilityDTOResponse
                = iTraceabilityHandler.saveTraceability(traceabilityDTORequest);
        log.info(ConstantInfrastructure.LISTENER_CONTROLLER_END);
        return ResponseEntity.ok(traceabilityDTOResponse);
    }
}
