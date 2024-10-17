package com.overmighties.pubsdataservice.controller.clientdto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Positive;
import lombok.*;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PubClientDto {
    private Long id;
    private String name;
    private String address;
    private String placeId;
    private String city;
    @Pattern(regexp = "^(\\+\\d{2}\\s?)?((\\d{9})|(\\d{2}\\s\\d{3}\\s\\d{2}\\s\\d{2})|((\\d{3}\\s){2}\\d{3}))")
    private String phoneNumber;
    @Pattern(regexp = "^(https?:\\/\\/).*")
    private String websiteUrl;
    @Pattern(regexp = "^(https?:\\/\\/).*")
    private String iconUrl;
    private String description;
    private Double latitude;
    private Double longitude;
    private Boolean reservable;
    private Boolean takeout;
    private RatingsClientDto ratings;
    private List<OpeningHoursClientDto> openingHours;
    private List<DrinkClientDto> drinks;
    private List<PhotoClientDto> photos;
    private List<TagClientDto> tags;
}
