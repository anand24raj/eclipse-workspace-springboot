package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.MovieService;

@Component
public class MovieRunner implements CommandLineRunner {

	private final MovieService service;

	MovieRunner(MovieService service) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * // Movie m=new Movie();
		 * 
		 * List<Movie> movies = List.of( new Movie("Pathaan", "Hindi", 250.0), new
		 * Movie("Jawan", "Hindi", 300.0), new Movie("Pushpa", "Telugu", 220.0), new
		 * Movie("RRR", "Telugu", 350.0), new Movie("KGF", "Kannada", 280.0), new
		 * Movie("Leo", "Tamil", 260.0), new Movie("Animal", "Hindi", 320.0), new
		 * Movie("Vikram", "Tamil", 240.0), new Movie("Bahubali", "Telugu", 400.0), new
		 * Movie("Dangal", "Hindi", 200.0) );
		 * 
		 * service.getMoviesSortedByName(false,m.getMovieName() );
		 */
		while (true) {

			System.out.println("\n===== MOVIE SORTING MENU =====");
			System.out.println("1. Movie Name ASC");
			System.out.println("2. Movie Name DESC");
			System.out.println("3. Ticket Price ASC");
			System.out.println("4. Ticket Price DESC");
			System.out.println("5. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Choice : "));

			switch (choice) {

			case 1 -> service.getMoviesSortedByName(true).forEach(IO::println);

			case 2 -> service.getMoviesSortedByName(false).forEach(IO::println);

			case 3 -> service.getMoviesSortedByPrice(true).forEach(IO::println);

			case 4 -> service.getMoviesSortedByPrice(false).forEach(IO::println);
			case 5 -> {
				IO.println("Application Closed...");
				System.exit(0);
			}

			default -> IO.println("Invalid Choice");
			}
		}
	}
}