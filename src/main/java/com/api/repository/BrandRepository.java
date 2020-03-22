package com.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.api.model.Brand;

public interface BrandRepository extends MongoRepository<Brand, String> {

	@Query("{ 'name': ?0 }")
	Brand findByName(String name);

}
