package com.overmighties.pubsdataservice.repository;

import com.overmighties.pubsdataservice.model.OpeningHours;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpeningHoursRepository extends CrudRepository<OpeningHours,Long> {
}
