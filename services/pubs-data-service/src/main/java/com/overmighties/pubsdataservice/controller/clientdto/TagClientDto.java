package com.overmighties.pubsdataservice.controller.clientdto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class TagClientDto {
    @NotBlank
    private String name;
}
