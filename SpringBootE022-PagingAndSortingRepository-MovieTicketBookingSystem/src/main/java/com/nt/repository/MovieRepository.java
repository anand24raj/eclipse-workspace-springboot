package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Movie;
@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>,
        PagingAndSortingRepository<Movie, Long> {
}