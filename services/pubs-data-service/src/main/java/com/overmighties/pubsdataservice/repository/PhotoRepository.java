package com.overmighties.pubsdataservice.repository;

import com.overmighties.pubsdataservice.model.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Photo,Long> {
}
