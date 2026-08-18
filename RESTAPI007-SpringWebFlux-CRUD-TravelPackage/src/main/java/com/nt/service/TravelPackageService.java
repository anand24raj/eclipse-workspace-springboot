package com.nt.service;

import com.nt.model.TravelPackage;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TravelPackageService {

	Mono<TravelPackage> createPackage(TravelPackage travelPackage);

	Flux<TravelPackage> getAllPackages();

	Mono<TravelPackage> getPackageById(Integer id);

	Mono<TravelPackage> updatePackage(Integer id, TravelPackage travelPackage);

	Mono<Void> deletePackage(Integer id);
}