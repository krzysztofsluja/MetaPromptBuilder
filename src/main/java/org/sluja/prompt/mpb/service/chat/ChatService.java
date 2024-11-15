package org.sluja.prompt.mpb.service.chat;

import lombok.RequiredArgsConstructor;
import org.sluja.prompt.mpb.component.MetaPromptStructureReader;
import org.sluja.prompt.mpb.component.chat.model.ChatClientComponent;
import org.sluja.prompt.mpb.exceptions.ExceptionWithErrorCodeAndDescription;
import org.sluja.prompt.mpb.interfaces.chat.IStreamChat;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService implements IStreamChat {

    private final ChatClientComponent chatClientComponent;
    private final MetaPromptStructureReader metaPromptStructureReader;

    @Override
    public Flux<String> chat(final String message) {
        try {
            return chatClientComponent.streamChat(buildPrompt(message));
        } catch (final ExceptionWithErrorCodeAndDescription e) {
            return null;
        }
    }

    private Prompt buildPrompt(final String message) throws ExceptionWithErrorCodeAndDescription {
        final SystemMessage systemMetaPrompt = new SystemMessage(metaPromptStructureReader.getMetaPromptSystemMessage());
        final UserMessage userMessage = new UserMessage(message);
        return new Prompt(List.of(systemMetaPrompt, userMessage));
    }

}
