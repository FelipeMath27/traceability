package com.pragma.traceability.domain.model;

import lombok.*;

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
    private LocalDateTime startOrderTraceability;
    private LocalDateTime dateTraceability;
    private StatusOrder newStatus;
    private Long idEmployee;
    private String emailEmployee;
}
