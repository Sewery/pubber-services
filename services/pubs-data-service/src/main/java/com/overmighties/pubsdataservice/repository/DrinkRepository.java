package com.overmighties.pubsdataservice.repository;

import com.overmighties.pubsdataservice.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink,Long> {
    @Query("SELECT p FROM Drink p LEFT JOIN FETCH p.drinkStyles")
    List<Drink> findAllDrinks();

    @Query("SELECT p FROM Drink p LEFT JOIN FETCH p.beer WHERE p.beer IS NOT NULL")
    List<Drink> findAllBeers();
}
