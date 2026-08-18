package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.TravelPackage;
import com.nt.service.TravelPackageService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {

	private final TravelPackageService service;

	public TravelPackageController(TravelPackageService service) {
		this.service = service;
	}

	// CREATE
	@PostMapping
	public Mono<ResponseEntity<TravelPackage>> createPackage(@Valid @RequestBody TravelPackage travelPackage) {

		return service.createPackage(travelPackage)
				.map(savedPackage -> ResponseEntity.status(HttpStatus.CREATED).body(savedPackage));
	}

	// GET ALL
	@GetMapping
	public Flux<TravelPackage> getAllPackages() {
		return service.getAllPackages();
	}

	// GET BY ID
	@GetMapping("/{id}")
	public Mono<ResponseEntity<TravelPackage>> getPackageById(@PathVariable Integer id) {

		return service.getPackageById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	// UPDATE
	@PutMapping("/{id}")
	public Mono<ResponseEntity<TravelPackage>> updatePackage(@PathVariable Integer id,
			@Valid @RequestBody TravelPackage travelPackage) {

		return service.updatePackage(id, travelPackage).map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	// DELETE
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> deletePackage(@PathVariable Integer id) {

		return service.getPackageById(id).flatMap(
				existingPackage -> service.deletePackage(id).thenReturn(ResponseEntity.noContent().<Void>build()))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
}