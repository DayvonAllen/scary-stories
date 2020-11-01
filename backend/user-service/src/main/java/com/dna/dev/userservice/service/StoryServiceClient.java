package com.dna.dev.userservice.service;

import com.dna.dev.userservice.api.v1.domain.StoryDtoList;
import com.dna.dev.userservice.util.storyfallback.StoryFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "STORY-WS", fallbackFactory = StoryFallbackFactory.class)
public interface StoryServiceClient {
    @GetMapping(value = "api/v1/stories/{id}")
    StoryDtoList getUserStories(@PathVariable UUID id);
}
