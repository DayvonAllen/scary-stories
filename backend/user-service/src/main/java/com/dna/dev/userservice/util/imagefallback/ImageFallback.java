package com.dna.dev.userservice.util.imagefallback;

import com.dna.dev.userservice.api.v1.domain.ImageDto;
import com.dna.dev.userservice.service.ImageServiceClient;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class ImageFallback implements ImageServiceClient {

    private final Throwable cause;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public ImageFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public ImageDto getProfilePic(UUID id) {
        if(cause instanceof FeignException && ((FeignException) cause).status() == 404){
            LOGGER.error("404 error took place while trying to execute the getAlbum method wit usedId: "
                    + id + ". Error Message: "
                    + cause.getLocalizedMessage());
        } else {
            LOGGER.error("Other exception took place: " + cause.getLocalizedMessage());
        }
        return new ImageDto();
    }
}
