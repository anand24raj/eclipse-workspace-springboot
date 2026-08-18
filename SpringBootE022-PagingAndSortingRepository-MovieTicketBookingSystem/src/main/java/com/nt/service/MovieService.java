package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.entity.Movie;

@Service
public interface MovieService {

	Iterable<Movie> addMovies(List<Movie> movies);

	List<Movie> getMoviesSortedByName(boolean flag);

	List<Movie> getMoviesSortedByPrice(boolean flag);
}