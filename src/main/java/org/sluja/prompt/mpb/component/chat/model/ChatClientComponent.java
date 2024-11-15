package org.sluja.prompt.mpb.component.chat.model;

import groovyjarjarpicocli.CommandLine;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import reactor.core.publisher.Flux;

@Component
@Scope(value= WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChatClientComponent {

    private final ChatClient chatClient;

    public ChatClientComponent(final ChatClient.Builder builder) {
        final InMemoryChatMemory memory = new InMemoryChatMemory();
        this.chatClient = builder
                .defaultAdvisors(new PromptChatMemoryAdvisor(memory))
                .build();
    }

    public Flux<String> streamChat(final Prompt prompt) {
        return chatClient.prompt(prompt)
                .stream()
                .content();
    }
}
