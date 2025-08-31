package com.pragma.traceability.infrastructure.constant;

public class ConstantInfrastructure {
    public static final String START_PROCESS_TO_GET_USER_BY_ID_FEIGN = "Start process to get user by id using feign client";
    public static final String ERROR_GETTING_USER_BY_ID_FEIGN = "Error getting user by id";
    public static final String ERROR_GETTING_FEIGN_USER_BY_ID = "Error getting user by id using feign client";

    /**Logs infrastructure*/
    public static final String LISTENER_CONTROLLER_START = "Start ListenerController";
    public static final String LISTENER_CONTROLLER_END = "End ListenerController";
    public static final String CONSTANT_HEADER_AUTHENTICATION = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";
    public static final int BEARER_SUBSTRING = 7;
    public static final String START_PROCESS_TO_GET_USER_BY_ID = "Start process to get user by id";
    public static final String END_PROCESS_TO_GET_USER_BY_ID = "End process to get user by id";
    public static final String ERROR_GETTING_USER_BY_ID = "Error getting user by id";
    public static final String ERROR_PROCESS_TOKEN = "Error process token";
    public static final String EXPIRED_TOKEN = "Token has expired";
    public static final String ERROR_TO_VALIDATE_TOKEN = "There is a error to validate token JWT";



    private ConstantInfrastructure() {
    }
}
