package com.pragma.traceability.infrastructure.output.mongodb.entity;

import com.pragma.traceability.domain.model.StatusOrder;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "traceability_logs")
public class TraceabilityEntity {

    @Id
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
