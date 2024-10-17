package com.overmighties.pubsdataservice.controller.clientdto.mappers;

import com.overmighties.pubsdataservice.controller.clientdto.RatingsClientDto;
import com.overmighties.pubsdataservice.model.Ratings;

public class RatingsClientDtoMapper {
    private RatingsClientDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static RatingsClientDto mapToDto(Ratings ratings)
    {
        return null==ratings?null:RatingsClientDto.builder()
                .google(ratings.getGoogle())
                .googleCount(ratings.getGoogleCount())
                .facebook(ratings.getFacebook())
                .facebookCount(ratings.getFacebookCount())
                .untapped(ratings.getUntapped())
                .untappedCount(ratings.getUntappedCount())
                .tripAdvisor(ratings.getTripAdvisor())
                .tripAdvisorCount(ratings.getTripAdvisorCount())
                .ourDrinksQuality(ratings.getOurDrinkQuality())
                .ourServiceQuality(ratings.getOurServiceQuality())
                .ourCost(ratings.getOurCost())
                .build();
    }
}
