package com.nt.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Course;
import com.nt.entity.University;
import com.nt.repository.IUniversityRepository;

@Component
public class UniversityRunner implements CommandLineRunner {

	private final IUniversityRepository repo;

	UniversityRunner(IUniversityRepository repo) {
		this.repo = repo;
	}

	@Override
	public void run(String... args) throws Exception {

		University savedUniversity = null;

		if (repo.count() == 0) {

			University university = new University("Global University", "Hyderabad");

			Course c1 = new Course(null, "Java Full Stack", "6 Months", 25000.0, university);
			Course c2 = new Course(null, "Spring Boot", "3 Months", 15000.0, university);

			university.setCourses(Arrays.asList(c1, c2));

			savedUniversity = repo.save(university);

			// service.addUnivCourse(university);

			IO.println("Data inserted successfully");

		} else {
			IO.println("Data already exists, not inserted again");

			savedUniversity = repo.findAll().get(0);
		}

		IO.println("\nUniversity Details");
		IO.println("-------------------------");
		IO.println("University Id : " + savedUniversity.getUniversityId());
		IO.println("University Name : " + savedUniversity.getUniversityName());
		IO.println("City : " + savedUniversity.getCity());

		IO.println("\nCourse Details");
		IO.println("-------------------------");

		for (Course course : savedUniversity.getCourses()) {
			IO.println("Course Id : " + course.getCourseId());
			IO.println("Course Name : " + course.getCourseName());
			IO.println("Duration : " + course.getDuration());
			IO.println("Fee : " + course.getFee());
			IO.println();
		}
	}
}
