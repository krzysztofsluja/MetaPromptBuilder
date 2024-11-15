package org.sluja.prompt.mpb.component;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.sluja.prompt.mpb.exceptions.ExceptionWithErrorCodeAndDescription;
import org.sluja.prompt.mpb.exceptions.constructor.InvalidConstructorValueException;
import org.sluja.prompt.mpb.exceptions.files.UnavailableFileException;
import org.sluja.prompt.mpb.interfaces.files.IFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class OuterFileReader implements IFileReader {

    @Getter
    private final String filePath;
    public OuterFileReader(final String filePath) {
        if(StringUtils.isBlank(filePath))
            throw new InvalidConstructorValueException();
        this.filePath = filePath;
    }

    @Override
    public String readFileContent(String filePath) throws ExceptionWithErrorCodeAndDescription {
        try {
            final Path path = Paths.get(filePath);
            return Files.readString(path);
        } catch (final InvalidPathException | IOException ex) {
            throw new UnavailableFileException();
        }
    }

    protected String readFileContent() throws ExceptionWithErrorCodeAndDescription {
        return readFileContent(filePath);
    }
}
