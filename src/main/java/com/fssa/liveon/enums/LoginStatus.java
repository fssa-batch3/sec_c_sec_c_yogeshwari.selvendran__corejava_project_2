package com.fssa.liveon.enums;

public enum LoginStatus {
    /**
     * Represents a successful login attempt.
     */
    SUCCESS,
    
    /**
     * Represents a login attempt where the user was not found in the system.
     */
    USER_NOT_FOUND,
    
    /**
     * Represents a login attempt where the provided password was incorrect.
     */
    INCORRECT_PASSWORD
}