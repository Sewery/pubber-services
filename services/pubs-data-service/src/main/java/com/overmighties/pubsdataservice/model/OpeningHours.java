package com.overmighties.pubsdataservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Opening_Hours")
public class OpeningHours {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_opening_hours",nullable = false)
    private Long id;
    @Column(name="weekday")
    private String weekday;
    @Column(name="time_open")
    private LocalTime timeOpen;
    @Column(name="time_close")
    private LocalTime timeClose;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_pub")
    @JsonBackReference
    private Pub pub;
}

