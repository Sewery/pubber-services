package com.overmighties.pubsdataservice.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Drink")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_drink", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "drink_name")
    private String name;

    @NotNull
    private String type;

    @NotNull
    @Column(name = "drink_description")
    private String description;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_beer")
    private Beer beer;

    @ManyToMany(mappedBy = "drinks")
    private List<Pub> pubs;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Drink_Styles_Drink", joinColumns = @JoinColumn(name = "id_drink"), inverseJoinColumns = @JoinColumn(name = "id_drink_style"))
    private List<DrinkStyles> drinkStyles;

}
