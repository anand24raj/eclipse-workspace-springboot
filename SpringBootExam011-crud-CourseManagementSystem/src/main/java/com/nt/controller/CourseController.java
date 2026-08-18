package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Course;
import com.nt.service.CourseService;

@Controller
public class CourseController {

	private final CourseService service;

	public CourseController(CourseService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String index() {
		return "redirect:/viewCourse";
	}

	@GetMapping("/viewCourse")
	public String viewCourse(Model model) {

		model.addAttribute("courseList", service.viewingallcourses());

		return "viewCourse";
	}

	@GetMapping("/addCourse")
	public String addCourse(Model model) {

		model.addAttribute("course", new Course());

		return "addCourse";
	}

	@PostMapping("/saveCourse")
	public String saveCourse(@ModelAttribute Course course, RedirectAttributes attributes) {

		service.addingnewcourses(course);

		attributes.addFlashAttribute("message", "Course added successfully");

		return "redirect:/viewCourse";
	}

	// Search page
	@GetMapping("/searchCourse")
	public String searchCoursePage() {

		return "searchCourse";
	}

	// Search by ID
	@GetMapping("/searchCourseById")
	public String searchCourseById(@RequestParam  Integer courseId, Model model) {

		try {

			Course course = service.searchingcoursesbyID(courseId);

			model.addAttribute("course", course);

		} catch (IllegalArgumentException exception) {

			model.addAttribute("errorMessage", exception.getMessage());
		}

		return "searchCourse";
	}

	// Open edit page
	@GetMapping("/editCourse/{courseId}")
	public String editCourse(@PathVariable Integer courseId, Model model) {

		Course course = service.searchingcoursesbyID(courseId);

		model.addAttribute("course", course);

		return "editCourse";
	}

	// Update course
	@PostMapping("/updateCourse")
	public String updateCourse(@ModelAttribute Course course, RedirectAttributes attributes) {

		service.updatingCourse(course);

		attributes.addFlashAttribute("message", "Course updated successfully");

		return "redirect:/viewCourse";
	}

	@GetMapping("/deleteCourse/{courseId}")
	public String deleteCourse(@PathVariable Integer courseId, RedirectAttributes attributes) {

		service.deletingCourse(courseId);

		attributes.addFlashAttribute("message", "Course deleted successfully");

		return "redirect:/viewCourse";
	}
}