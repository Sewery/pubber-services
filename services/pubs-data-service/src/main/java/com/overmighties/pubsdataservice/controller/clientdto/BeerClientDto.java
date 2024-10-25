package com.overmighties.pubsdataservice.controller.clientdto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BeerClientDto {
    private Long beerId;
    private String longDescription;
    private String shortDescription;
    private String photoUrl;
    private String maltiness;
    private String blg;
    private String alcoholContent;
}

