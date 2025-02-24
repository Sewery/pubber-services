package com.overmighties.pubsdataservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_add_photo", nullable = false)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    @Column(name = "photo_url")
    private String photoUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pub")
    @JsonBackReference
    private Pub pub;
}
