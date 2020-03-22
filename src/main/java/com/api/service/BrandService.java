package com.api.service;

import java.util.List;
import java.util.Optional;

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

	public boolean saveBrand(Brand brand) {
		boolean saved = Boolean.FALSE;
		try {
			if (brand.isValid()) {
				repository.save(brand);
				saved = Boolean.TRUE;
				logger.info("Brand saved successfully");
			}
			logger.info("Brand invalid");
		} catch (Exception e) {
			logger.error("ERROR - Could not save Brand. ", e);
			logger.error(e.getMessage());
		}
		return saved;
	}

	public Optional<Brand> findById(String id) {
		Optional<Brand> brand = repository.findById(id);
		if (brand.isPresent()) {
			logger.info(brand.toString());
			return brand;
		}
		logger.info("No brand found with id -> ", id);
		return brand;
	}

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

	public boolean updateBrand(Brand brand, String id) {
		boolean updated = Boolean.FALSE;
		try {
			brand.setId(id);
			repository.save(brand);
			updated = Boolean.TRUE;
			logger.info("Brand updated successfully");
		} catch (Exception e) {
			logger.error("ERROR - Could not update Brand. ", e);
			logger.error(e.getMessage());
		}
		return updated;
	}

	public boolean deleteBrand(String id) {
		boolean deleted = Boolean.FALSE;
		try {
			repository.deleteById(id);
			deleted = Boolean.TRUE;
			logger.info("Brand deleted successfully");
		} catch (Exception e) {
			logger.error("ERROR - Could not delete Brand. ", e);
			logger.error(e.getMessage());
		}
		return deleted;
	}

}
