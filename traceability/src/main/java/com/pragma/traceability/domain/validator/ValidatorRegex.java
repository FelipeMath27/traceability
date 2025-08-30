package com.pragma.traceability.domain.validator;

import java.util.Optional;

public class ValidatorRegex {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com(\\.co)?$";

    public static Optional<String> sanitize(String input) {
        return Optional.ofNullable(input).map(String::trim).
                filter(s -> !s.isEmpty());
    }

    public static Optional<String> validateEmail(String email){
        return sanitize(email)
                .filter(e -> e.matches(EMAIL_REGEX));
    }

}
