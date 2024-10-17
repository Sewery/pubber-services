package com.overmighties.pubsdataservice.controller.clientdto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RatingsClientDto {
    private Float google;
    private Integer googleCount;
    private Float facebook;
    private Integer facebookCount;
    private Float tripAdvisor;
    private Integer tripAdvisorCount;
    private Float untapped ;
    private Integer untappedCount;
    private Float ourDrinksQuality;
    private Float ourServiceQuality;
    private Integer ourCost;
}
