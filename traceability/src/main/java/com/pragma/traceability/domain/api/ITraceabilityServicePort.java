package com.pragma.traceability.domain.api;

import com.pragma.traceability.domain.model.Traceability;

public interface ITraceabilityServicePort {
    Traceability saveTraceability(Traceability traceability);
}
