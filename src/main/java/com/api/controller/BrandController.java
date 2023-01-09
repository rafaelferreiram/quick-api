package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
