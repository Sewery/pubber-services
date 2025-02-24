package com.overmighties.pubsdataservice.controller.clientdto.mappers;


import com.overmighties.pubsdataservice.controller.clientdto.BeerClientDto;
import com.overmighties.pubsdataservice.model.Beer;

public class BeerClientDtoMapper {
    private BeerClientDtoMapper() {throw new IllegalStateException("Utility class, calling constructor forbidden");}

    public static BeerClientDto mapToDto(Beer beer)
    {
        return beer == null ? null : BeerClientDto.builder()
                .beerId( beer.getIdBeer())
                .longDescription( beer.getLongDescription() )
                .shortDescription( beer.getShortDescription() )
                .photoUrl( beer.getPhotoUrl() )
                .maltiness( beer.getMaltiness() )
                .blg( beer.getBlg() )
                .alcoholContent(beer.getAlcoholContent())
                .build();
    }

}
