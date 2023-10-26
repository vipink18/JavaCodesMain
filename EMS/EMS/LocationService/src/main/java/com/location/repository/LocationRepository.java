package com.location.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.location.model.Location;

@Repository
public interface LocationRepository extends MongoRepository<Location, Integer> {
	
}
