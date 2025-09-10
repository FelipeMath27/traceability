package com.pragma.traceability.domain.utils;


public class ConstantsErrorMessages {

    public static final String EMAIL_INVALID = "Email is not valid";
    public static final String EMAIL_REQUIRED = "Email is required";
    public static final String ID_REQUIRED = "Id is required";
    public static final String ID_GREATER_THAN_ZERO = "Id must be greater than zero";
    public static final String STATUS_IS_REQUIRED = "Status is required";
    public static final String STATUS_INVALID_TO_CREATE_TRACEABILITY = "The status is not valid to create a traceability entry";
    public static final String NOT_FOUND_TRACEABILITY_FOR_ID_ORDER = "No traceability found for the given order ID";
    public static final String FIRST_TRACEABILITY_MUST_BE_PENDING = "The first traceability entry must have a status of PENDING";
    public static final String FAILED_TO_SAVE_TRACEABILITY = "Failed to save traceability";
    public static final String NOT_FOUND_ORIGIN_TRACEABILITY_PENDING = "Not found the beginning of the order";

    private ConstantsErrorMessages() {
    }
}
