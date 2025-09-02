package com.pragma.traceability.domain.validator;

import com.pragma.traceability.domain.model.StatusOrder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class StatusOrderValidators {
    private static final Map<StatusOrder, Set<StatusOrder>> VALID_TRANSITIONS =
            new HashMap<>();
    static {
        VALID_TRANSITIONS.put(StatusOrder.PENDING, Set.of(StatusOrder.IN_PROGRESS, StatusOrder.REJECTED));
        VALID_TRANSITIONS.put(StatusOrder.IN_PROGRESS, Set.of(StatusOrder.DISH_READY, StatusOrder.REJECTED));
        VALID_TRANSITIONS.put(StatusOrder.DISH_READY, Set.of(StatusOrder.DELIVERED, StatusOrder.REJECTED));
        VALID_TRANSITIONS.put(StatusOrder.DELIVERED, Set.of());
        VALID_TRANSITIONS.put(StatusOrder.REJECTED, Set.of());
    }

    public boolean isValidTransition(StatusOrder previous, StatusOrder next) {
        if (previous == null) {
            return true;
        }
        return Optional.ofNullable(VALID_TRANSITIONS.get(previous))
                .map(nextStates -> nextStates.contains(next))
                .orElse(false);
    }
}
