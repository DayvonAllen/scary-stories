package com.dna.dev.userservice.util.storyfallback;

import com.dna.dev.userservice.service.StoryServiceClient;
import feign.hystrix.FallbackFactory;

public class StoryFallbackFactory implements FallbackFactory<StoryServiceClient> {
    @Override
    public StoryServiceClient create(Throwable throwable) {
        return new StoryFallback(throwable);
    }
}
