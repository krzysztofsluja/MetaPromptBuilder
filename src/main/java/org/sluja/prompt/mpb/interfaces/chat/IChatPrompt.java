package org.sluja.prompt.mpb.interfaces.chat;

import org.sluja.prompt.mpb.exceptions.ExceptionWithErrorCodeAndDescription;
import org.springframework.ai.chat.prompt.Prompt;

@FunctionalInterface
public interface IChatPrompt<T> {
    T chat(Prompt prompt) throws ExceptionWithErrorCodeAndDescription;
}
