package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.entity.Course;
import com.nt.repository.CourseRepository;

@Service
public class CourseService {

	final CourseRepository repo;

	CourseService(CourseRepository repo) {
		this.repo = repo;
	}

	public List<Course> findByCategory(String category) {
		return repo.findByCategory(category);
	}

	public List<Course> findByInstructorName(String instructorName) {
		return repo.findByInstructorName(instructorName);
	}

	public List<Course> findByPriceLessThan(Double price) {
		return repo.findByPriceLessThan(price);
	}

	public List<Course> findByPriceGreaterThan(Double price) {
		return repo.findByPriceGreaterThan(price);
	}

	public List<Course> findByDurationInHoursGreaterThan(Integer hours) {
		return repo.findByDurationInHoursGreaterThan(hours);
	}

	public List<Course> findByRatingGreaterThanEqual(Double rating) {
		return repo.findByRatingGreaterThanEqual(rating);
	}

	public List<Course> findByLanguage(String language) {
		return repo.findByLanguage(language);
	}

	public List<Course> findByCourseTitleContaining(String keyword) {
		return repo.findByCourseTitleContaining(keyword);
	}

}
