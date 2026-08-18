package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.entity.Course;
import com.nt.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	private final CourseRepository repo;

	public CourseServiceImpl(CourseRepository repo) {
		this.repo = repo;
	}

	@Override
	public Course addingnewcourses(Course course) {
		return repo.save(course);
	}

	@Override
	public List<Course> viewingallcourses() {
		return repo.findAll();
	}

	@Override
	public Course searchingcoursesbyID(Integer courseId) {

		return repo.findById(courseId)
				.orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + courseId));
	}

	@Override
	public Course updatingCourse(Course course) {

		if (course.getCourseId() == null) {
			throw new IllegalArgumentException("Course ID is required for update");
		}

		if (!repo.existsById(course.getCourseId())) {
			throw new IllegalArgumentException("Course not found with ID: " + course.getCourseId());
		}

		return repo.save(course);
	}

	@Override
	public void deletingCourse(Integer courseId) {

		if (!repo.existsById(courseId)) {
			throw new IllegalArgumentException("Course not found with ID: " + courseId);
		}

		repo.deleteById(courseId);
	}
}