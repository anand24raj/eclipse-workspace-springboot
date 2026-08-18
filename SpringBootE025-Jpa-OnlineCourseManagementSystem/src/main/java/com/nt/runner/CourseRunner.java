package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.CourseService;

@Component
public class CourseRunner implements CommandLineRunner {

	@Autowired
	private CourseService service;

	@Override
	public void run(String... args) throws Exception {

		while (true) {

			IO.println("\n===== ONLINE COURSE MANAGEMENT SYSTEM =====");
			IO.println("1. Display all courses in Java category");
			IO.println("2. Display courses taught by Anand Raj");
			IO.println("3. Display courses with price less than 2000");
			IO.println("4. Display courses with price greater than 5000");
			IO.println("5. Display courses having duration greater than 40 hours");
			IO.println("6. Display courses having rating greater than or equal to 4.5");
			IO.println("7. Display courses available in English language");
			IO.println("8. Display courses whose title contains Spring");
			IO.println("9. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

			switch (choice) {

			case 1 -> {
				IO.println("\nJava Category Courses:");
				service.findByCategory("Java").forEach(IO::println);
			}

			case 2 -> {
				IO.println("\nCourses taught by Anand Raj:");
				service.findByInstructorName("Anand Raj").forEach(IO::println);
			}

			case 3 -> {
				IO.println("\nCourses with price less than 2000:");
				service.findByPriceLessThan(2000.0).forEach(IO::println);
			}

			case 4 -> {
				IO.println("\nCourses with price greater than 5000:");
				service.findByPriceGreaterThan(5000.0).forEach(IO::println);
			}

			case 5 -> {
				IO.println("\nCourses having duration greater than 40 hours:");
				service.findByDurationInHoursGreaterThan(40).forEach(IO::println);
			}

			case 6 -> {
				IO.println("\nCourses having rating greater than or equal to 4.5:");
				service.findByRatingGreaterThanEqual(4.5).forEach(IO::println);
			}

			case 7 -> {
				IO.println("\nCourses available in English language:");
				service.findByLanguage("English").forEach(IO::println);
			}

			case 8 -> {
				IO.println("\nCourses whose title contains Spring:");
				service.findByCourseTitleContaining("Spring").forEach(IO::println);
			}

			case 9 -> {
				IO.println("Application Closed Successfully");
				System.exit(0);
			}

			default -> IO.println("Invalid Choice");
			}
		}
	}
}