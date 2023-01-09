package com.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Brand;
import com.api.repository.BrandRepository;

@Component
public class BrandService {

	private static final Logger logger = LoggerFactory.getLogger(BrandService.class);

	@Autowired
	private BrandRepository repository;

	public List<Brand> findAllBrands() {
		return repository.findAll();
	}

	public Brand findByName(String name) {
		Brand brand = repository.findByName(name);
		if (brand.isEmpty()) {
			logger.info("No brand found with the name of -> ", name);
			return brand;
		}
		logger.info(brand.toString());
		return brand;
	}

}
