package com.overmighties.pubsdataservice.repository;

import com.overmighties.pubsdataservice.model.DrinkStyles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkStylesRepository extends JpaRepository<DrinkStyles,Long> {
}
