package com.dna.dev.userservice.util.imagefallback;

import com.dna.dev.userservice.service.ImageServiceClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ImageFallbackFactory implements FallbackFactory<ImageServiceClient> {
    @Override
    public ImageServiceClient create(Throwable throwable) {
        return new ImageFallback(throwable);
    }
}
