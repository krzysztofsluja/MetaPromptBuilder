package org.sluja.prompt.mpb.interfaces.files;

import org.sluja.prompt.mpb.exceptions.ExceptionWithErrorCodeAndDescription;

@FunctionalInterface
public interface IFileReader {
    String readFileContent(String filePath) throws ExceptionWithErrorCodeAndDescription;
}
