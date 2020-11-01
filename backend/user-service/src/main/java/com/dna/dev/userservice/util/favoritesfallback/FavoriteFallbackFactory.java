package com.dna.dev.userservice.util.favoritesfallback;

import com.dna.dev.userservice.service.FavoriteServiceClient;
import feign.hystrix.FallbackFactory;

public class FavoriteFallbackFactory implements FallbackFactory<FavoriteServiceClient> {

    @Override
    public FavoriteServiceClient create(Throwable throwable) {
        return new FavoriteFallback(throwable);
    }
}
