/*
 * Created on Jul 16, 2004
 */
package com.example.demo.CPUInformation;

/**
 * @author Iakin
 *
 */
public class UnknownCPUException extends RuntimeException {
    public UnknownCPUException() {
        super();
    }

    public UnknownCPUException(String message) {
        super(message);
    }
}
