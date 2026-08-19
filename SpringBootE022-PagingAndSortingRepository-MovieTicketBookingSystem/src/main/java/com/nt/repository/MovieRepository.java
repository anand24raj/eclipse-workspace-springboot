package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long>, PagingAndSortingRepository<Movie, Long> {
}