package com.overmighties.pubsdataservice.repository;


import com.overmighties.pubsdataservice.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag,Long> {
}
