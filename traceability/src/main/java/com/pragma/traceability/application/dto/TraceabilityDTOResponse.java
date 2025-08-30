package com.pragma.traceability.application.dto;

import com.pragma.traceability.domain.model.StatusOrder;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TraceabilityDTOResponse {
    private String idTraceability;
    private Long idOrder;
    private Long idClient;
    private String emailClient;
    private LocalDateTime dateTraceability;
    private StatusOrder previousStatus;
    private StatusOrder newStatus;
    private Long employeeUser;
    private String emailEmployee;
}
