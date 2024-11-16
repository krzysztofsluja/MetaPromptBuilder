package org.sluja.prompt.mpb.interfaces.chat;

import org.sluja.prompt.mpb.exceptions.ExceptionWithErrorCodeAndDescription;

@FunctionalInterface
public interface IChat<T> {

    T chat(String message) throws ExceptionWithErrorCodeAndDescription;
}
