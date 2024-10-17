package com.overmighties.pubsdataservice.controller.clientdto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;


@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PhotoClientDto {
    private String title;
    private String photoUrl;
}
