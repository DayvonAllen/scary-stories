package com.dna.dev.userservice.service;

import com.dna.dev.userservice.api.v1.domain.ImageDto;
import com.dna.dev.userservice.util.imagefallback.ImageFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "IMAGE-WS", fallbackFactory = ImageFallbackFactory.class)
public interface ImageServiceClient {
    @GetMapping(value = "api/v1/images/{id}")
    ImageDto getProfilePic(@PathVariable UUID id);
}
