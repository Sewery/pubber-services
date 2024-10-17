package com.overmighties.pubsdataservice.repository;

import com.overmighties.pubsdataservice.model.Pub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface PubRepository extends JpaRepository<Pub, Long> {
    @Query("SELECT p FROM Pub p LEFT JOIN FETCH p.openingHours")
    List<Pub> findAllPubsFetchOpeningHours();
    @Query("SELECT p FROM Pub p LEFT JOIN FETCH p.photos")
    List<Pub> findAllPubsFetchPhotos();
    @Query("SELECT p FROM Pub p LEFT JOIN FETCH p.rating")
    List<Pub> findAllPubsFetchRating();
    @Query("SELECT p FROM Pub p LEFT JOIN FETCH p.drinks")
    List<Pub> findAllPubsFetchDrinks();
    @Query("SELECT p FROM Pub p LEFT JOIN FETCH p.openingHours WHERE p.city=?1")
    List<Pub> findAllPubsFetchOpeningHours(String city);
    @Query("SELECT p FROM Pub p LEFT JOIN FETCH p.photos  WHERE p.city=?1")
    List<Pub> findAllPubsFetchPhotos(String city);
    @Query("SELECT p FROM Pub p LEFT JOIN FETCH p.rating  WHERE p.city=?1")
    List<Pub> findAllPubsFetchRating(String city);
    @Query("SELECT p FROM Pub p LEFT JOIN FETCH p.drinks  WHERE p.city=?1")
    List<Pub> findAllPubsFetchDrinks(String city);
}

