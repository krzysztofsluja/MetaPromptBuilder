package org.sluja.prompt.mpb.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.ai.chat.messages.Message;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public Caffeine<Object, Object> caffeineConfig() {
        return Caffeine.newBuilder()
                .maximumSize(60);
    }

    @Bean
    public Cache<String, List<Message>> conversationMessages(final Caffeine<Object, Object> caffeineConfig) {
        return caffeineConfig.build();
    }
}
