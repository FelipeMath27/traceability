package com.pragma.traceability.application.dto;

import com.pragma.traceability.domain.model.StatusOrder;
import com.pragma.traceability.domain.utils.ConstantsErrorMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TraceabilityDTORequest {
    @NotNull(message = ConstantsErrorMessages.ID_REQUIRED)
    @Positive(message = ConstantsErrorMessages.ID_GREATER_THAN_ZERO)
    private Long idOrder;

    @NotNull(message = ConstantsErrorMessages.ID_REQUIRED)
    @Positive(message = ConstantsErrorMessages.ID_GREATER_THAN_ZERO)
    private Long idClient;

    @NotBlank(message = ConstantsErrorMessages.EMAIL_REQUIRED)
    @Email(message = ConstantsErrorMessages.EMAIL_INVALID)
    private String emailClient;

    @NotNull(message = ConstantsErrorMessages.STATUS_IS_REQUIRED)
    private StatusOrder newStatus;

    @NotNull(message = ConstantsErrorMessages.ID_REQUIRED)
    @Positive(message = ConstantsErrorMessages.ID_GREATER_THAN_ZERO)
    private Long idEmployee;

    @NotBlank(message = ConstantsErrorMessages.EMAIL_REQUIRED)
    @Email(message = ConstantsErrorMessages.EMAIL_INVALID)
    private String emailEmployee;
}
