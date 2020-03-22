package com.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Brand;
import com.api.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService service;

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/brands")
	public ResponseEntity getBrands() {
		List<Brand> brands = service.findAllBrands();
		if (brands.isEmpty()) {
			return ResponseEntity.badRequest().body("No Brands found");
		}
		return ResponseEntity.ok().body(brands);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/save")
	public ResponseEntity saveBrand(@RequestBody Brand brand) {
		boolean saved = service.saveBrand(brand);
		if (saved) {
			return ResponseEntity.ok().body("Brand saved");
		}
		return ResponseEntity.badRequest().body("Error saving brand");
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/find")
	public ResponseEntity getBrandById(@RequestParam String id) {
		Optional<Brand> brandById = service.findById(id);
		if (brandById.isPresent()) {
			return ResponseEntity.ok().body(brandById);
		}
		return ResponseEntity.badRequest().body("No Brand found");
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/find/name")
	public ResponseEntity findByBrandName(@RequestParam String name) {
		Brand brand = service.findByName(name);
		if (brand.isEmpty()) {
			return ResponseEntity.badRequest().body("No Brand found");
		}
		return ResponseEntity.ok().body(brand);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "/delete")
	public ResponseEntity deleteBrand(@RequestParam String id) {
		boolean deleted = service.deleteBrand(id);
		if (deleted) {
			return ResponseEntity.ok().body("Brand deleted");
		}
		return ResponseEntity.badRequest().body("Could not delete brand");
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping(value = "/update")
	public ResponseEntity updateBrand(@RequestBody Brand brand, @RequestParam String id) {
		boolean updated = service.updateBrand(brand, id);
		if(updated) {
			return ResponseEntity.ok().body("Brand updated");
		}
		return ResponseEntity.badRequest().body("Could not update brand");
	}
}
