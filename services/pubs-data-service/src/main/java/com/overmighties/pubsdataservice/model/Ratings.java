package com.overmighties.pubsdataservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ratings")
public class Ratings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rating", nullable = false)
    private Long id;
    private Float google;
    @Column(name = "google_count")
    private Integer googleCount;
    private Float facebook;
    @Column(name = "facebook_count")
    private Integer facebookCount;
    @Column(name = "trip_advisor")
    private Float tripAdvisor;
    @Column(name = "trip_advisor_count")
    private Integer tripAdvisorCount;
    private Float untapped;
    @Column(name = "untapped_count")
    private Integer untappedCount;
    @Column(name = "our_drinks_quality")
    private Float ourDrinkQuality;
    @Column(name = "our_service_quality")
    private Float ourServiceQuality;
    @Column(name = "our_cost")
    private Integer ourCost;
}
