package org.sluja.prompt.mpb.component;

import org.sluja.prompt.mpb.exceptions.ExceptionWithErrorCodeAndDescription;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MetaPromptStructureReader extends OuterFileReader {

    public MetaPromptStructureReader(@Value("${meta.prompt.file.location}") final String promptFilePath) {
        super(promptFilePath);
    }

    public String getMetaPromptSystemMessage() throws ExceptionWithErrorCodeAndDescription {
        return super.readFileContent();
    }
}
