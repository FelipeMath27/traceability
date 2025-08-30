package com.pragma.traceability.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Traceability {
    private String idTraceability;
    private Long idOrder;
    private Long idClient;
    private String emailClient;
    private LocalDateTime dateTraceability;
    private StatusOrder previousStatus;
    private StatusOrder newStatus;
    private Long idEmployee;
    private String emailEmployee;
}
