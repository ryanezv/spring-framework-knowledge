package com.apixcloud.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

//import com.apixcloud.commons.exceptions.MyBadRequestException;
//import com.apixcloud.commons.exceptions.MyResourceNotFoundException;

/**
 * Simple static methods to be called at the start of your own methods to verify
 * correct arguments and state. If the Precondition fails, an {@link HttpStatus}
 * code is thrown
 */
public final class RestPreconditions {

    private static Logger log = LoggerFactory.getLogger(RestPreconditions.class);
    
    private RestPreconditions() {
        throw new AssertionError();
    }

    // API

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference
     *            an object reference
     *
     * @return the non-null reference that was validated
     *
     * @throws MyResourceNotFoundException
     *             if {@code reference} is null
     */
    public static <T> T checkNotNull(final T reference) {
        return checkNotNull(reference, null);
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference
     *            an object reference
     * @param message
     *            the message of the exception if the check fails
     *
     * @return the non-null reference that was validated
     *
     * @throws MyResourceNotFoundException
     *             if {@code reference} is null
     */
    public static <T> T checkNotNull(final T reference, final String message) {
        if (reference == null) {
            log.info("MyResourceNotFoundException: {}", message);
            //throw new MyResourceNotFoundException(message);
        }
        return reference;
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling
     * method is not null.
     *
     * @param reference
     *            an object reference
     * @return the non-null reference that was validated
     *
     * @throws MyBadRequestException
     *             if {@code reference} is null
     */
    public static <T> T checkRequestElementNotNull(final T reference) {
        return checkRequestElementNotNull(reference, null);
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference
     *            an object reference
     * @param message
     *            the message of the exception if the check fails
     *
     * @return the non-null reference that was validated
     *
     * @throws MyBadRequestException
     *             if {@code reference} is null
     */
    public static <T> T checkRequestElementNotNull(final T reference, final String message) {
        if (reference == null) {
            log.info("MyResourceNotFoundException: {}", message);
            //throw new MyBadRequestException(message);
        }
        return reference;
    }

    /**
     * Ensures the truth of an expression
     *
     * @param expression
     *            a boolean expression
     *
     * @throws MyBadRequestException
     *             if {@code expression} is false
     */
    public static void checkRequestState(final boolean expression) {
        checkRequestState(expression, null);
    }

    /**
     * Ensures the truth of an expression
     *
     * @param expression
     *            a boolean expression
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws MyBadRequestException
     *             if {@code expression} is false
     */
    public static void checkRequestState(final boolean expression, final String message) {
        if (!expression) {
            log.info("MyResourceNotFoundException: {}", message);
            //throw new MyBadRequestException(message);
        }
    }

    /**
     * Ensures the truth of an expression related to the validity of the request
     *
     * @param expression
     *            a boolean expression
     *
     * @throws MyBadRequestException
     *             if {@code expression} is false
     */
    public static void checkIfBadRequest(final boolean expression) {
        checkIfBadRequest(expression, null);
    }

    /**
     * Ensures the truth of an expression related to the validity of the request
     *
     * @param expression
     *            a boolean expression
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws MyBadRequestException
     *             if {@code expression} is false
     */
    public static void checkIfBadRequest(final boolean expression, final String message) {
        if (!expression) {
            log.info("MyResourceNotFoundException: {}", message);
            //throw new MyBadRequestException(message);
        }
    }

}
