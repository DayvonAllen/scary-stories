package com.dna.dev.userservice.service;

import com.dna.dev.userservice.api.v1.domain.FavoriteDtoList;
import com.dna.dev.userservice.util.favoritesfallback.FavoriteFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "FAVORITE-WS", fallbackFactory = FavoriteFallbackFactory.class)
public interface FavoriteServiceClient {
    @GetMapping(value = "api/v1/favorites/{id}")
    FavoriteDtoList getUserFavorites(@PathVariable UUID id);
}
