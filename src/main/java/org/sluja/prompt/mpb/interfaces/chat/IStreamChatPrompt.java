package org.sluja.prompt.mpb.interfaces.chat;

import reactor.core.publisher.Flux;

@FunctionalInterface
public interface IStreamChatPrompt extends IChatPrompt<Flux<String>>{
}
