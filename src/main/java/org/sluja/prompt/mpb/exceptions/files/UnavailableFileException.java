package org.sluja.prompt.mpb.exceptions.files;

import org.sluja.prompt.mpb.exceptions.ExceptionWithErrorCodeAndDescription;

public class UnavailableFileException extends ExceptionWithErrorCodeAndDescription {

    public UnavailableFileException() {
        super(2001L, "error.file.unavailable");
    }
}
