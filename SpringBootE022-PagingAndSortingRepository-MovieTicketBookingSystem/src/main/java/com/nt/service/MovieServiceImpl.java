package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Movie;
import com.nt.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repo;

	@Override
	public Iterable<Movie> addMovies(List<Movie> movies) {
		return repo.saveAll(movies);
	}

	@Override
	public List<Movie> getMoviesSortedByName(boolean flag) {
		Sort nam = Sort.by(flag ? Sort.Direction.ASC : Sort.Direction.DESC, "movieName");
		return (List<Movie>) repo.findAll(nam);
	}

	@Override
	public List<Movie> getMoviesSortedByPrice(boolean flag) {
		Sort price = Sort.by(flag ? Sort.Direction.ASC : Sort.Direction.DESC, "ticketPrice");
		return (List<Movie>) repo.findAll(price);
	}
}