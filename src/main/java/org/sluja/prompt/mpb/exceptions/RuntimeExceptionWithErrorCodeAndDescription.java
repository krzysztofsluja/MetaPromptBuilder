package org.sluja.prompt.mpb.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RuntimeExceptionWithErrorCodeAndDescription extends RuntimeException {

    private final Long errorCode;
    private final String errorDescriptionCode;
}

