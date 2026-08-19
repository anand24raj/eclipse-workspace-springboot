package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Movie;
import com.nt.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	private final MovieRepository repo;

	MovieServiceImpl(MovieRepository repo) {
		this.repo = repo;
	}

	@Override
	public Iterable<Movie> addMovies(List<Movie> movies) {
		return repo.saveAll(movies);
	}

	@Override
	public List<Movie> getMoviesSortedByName(boolean flag) {

		Sort name = Sort.by(flag ? Sort.Direction.ASC : Sort.Direction.DESC, Movie::getMovieName);

		return (List<Movie>) repo.findAll(name);
	}

	@Override
	public List<Movie> getMoviesSortedByPrice(boolean flag) {

		Sort price = Sort.by(flag ? Sort.Direction.ASC : Sort.Direction.DESC, Movie::getTicketPrice);

		return (List<Movie>) repo.findAll(price);
	}
}