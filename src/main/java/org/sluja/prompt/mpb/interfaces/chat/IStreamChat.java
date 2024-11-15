package org.sluja.prompt.mpb.interfaces.chat;

import reactor.core.publisher.Flux;

@FunctionalInterface
public interface IStreamChat extends IChat<Flux<String>>{

}
