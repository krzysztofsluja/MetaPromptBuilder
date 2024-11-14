package org.sluja.prompt.mpb.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExceptionWithErrorCodeAndDescription extends Exception {

    private final Long errorCode;
    private final String errorDescriptionCode;
}
