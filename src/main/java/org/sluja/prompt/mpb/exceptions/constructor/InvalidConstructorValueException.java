package org.sluja.prompt.mpb.exceptions.constructor;


import org.sluja.prompt.mpb.exceptions.RuntimeExceptionWithErrorCodeAndDescription;

public class InvalidConstructorValueException extends RuntimeExceptionWithErrorCodeAndDescription {

    public InvalidConstructorValueException() {
        super(1001L, "error.constructor.incorrect.value");
    }
}
