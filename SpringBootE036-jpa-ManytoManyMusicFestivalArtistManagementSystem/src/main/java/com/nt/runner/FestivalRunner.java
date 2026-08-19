package com.nt.runner;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Artist;
import com.nt.entity.Festival;
import com.nt.repository.ArtistRepository;
import com.nt.repository.FestivalRepository;

@Component
public class FestivalRunner implements CommandLineRunner {

	private final ArtistRepository artistRepo;
	private final FestivalRepository festivalRepo;

	public FestivalRunner(ArtistRepository artistRepo, FestivalRepository festivalRepo) {
		this.artistRepo = artistRepo;
		this.festivalRepo = festivalRepo;
	}

	@Override
	public void run(String... args) throws Exception {

		while (true) {

			System.out.println("\n===== MUSIC FESTIVAL ARTIST MANAGEMENT SYSTEM =====");
			System.out.println("1. Save Artist with Multiple Festivals");
			System.out.println("2. Save Festival with Multiple Artists");
			System.out.println("3. Find Artist by Artist Name");
			System.out.println("4. Find Festival by Festival Name");
			System.out.println("5. Find all Artists performing in a Festival");
			System.out.println("6. Find all Festivals attended by an Artist");
			System.out.println("7. Update Festival Ticket Price");
			System.out.println("8. Update Artist Experience Years");
			System.out.println("9. Delete an Artist");
			System.out.println("10. Delete a Festival");
			System.out.println("11. Display all Artists");
			System.out.println("12. Display all Festivals");
			System.out.println("13. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

			switch (choice) {

			case 1 -> {
				String artistName = IO.readln("Enter Artist Name : ");
				String genre = IO.readln("Enter Genre : ");
				String country = IO.readln("Enter Country : ");
				Integer experienceYears = Integer.parseInt(IO.readln("Enter Experience Years : "));

				Artist artist = new Artist(artistName, genre, country, experienceYears);

				int count = Integer.parseInt(IO.readln("How many festivals you want to add? : "));

				for (int i = 1; i <= count; i++) {
					System.out.println("\nEnter Festival " + i + " Details");

					String festivalName = IO.readln("Enter Festival Name : ");
					String city = IO.readln("Enter City : ");
					LocalDate eventDate = LocalDate.parse(IO.readln("Enter Event Date yyyy-mm-dd : "));
					Double ticketPrice = Double.parseDouble(IO.readln("Enter Ticket Price : "));

					Festival festival = new Festival(festivalName, city, eventDate, ticketPrice);

					artist.getFestivals().add(festival);
				}

				artistRepo.save(artist);
				System.out.println("Artist with Festivals Saved Successfully");
			}

			case 2 -> {
				String festivalName = IO.readln("Enter Festival Name : ");
				String city = IO.readln("Enter City : ");
				LocalDate eventDate = LocalDate.parse(IO.readln("Enter Event Date yyyy-mm-dd : "));
				Double ticketPrice = Double.parseDouble(IO.readln("Enter Ticket Price : "));

				Festival festival = new Festival(festivalName, city, eventDate, ticketPrice);

				int count = Integer.parseInt(IO.readln("How many artists you want to add? : "));

				for (int i = 1; i <= count; i++) {
					System.out.println("\nEnter Artist " + i + " Details");

					String artistName = IO.readln("Enter Artist Name : ");
					String genre = IO.readln("Enter Genre : ");
					String country = IO.readln("Enter Country : ");
					Integer experienceYears = Integer.parseInt(IO.readln("Enter Experience Years : "));

					Artist artist = new Artist(artistName, genre, country, experienceYears);

					artist.getFestivals().add(festival);

					artistRepo.save(artist);
				}

				System.out.println("Festival with Multiple Artists Saved Successfully");
			}

			case 3 -> {
				String artistName = IO.readln("Enter Artist Name : ");

				artistRepo.findByArtistName(artistName).ifPresentOrElse(a -> System.out.println("Artist Found : " + a),
						() -> System.out.println("Artist Not Found"));
			}

			case 4 -> {
				String festivalName = IO.readln("Enter Festival Name : ");

				festivalRepo.findByFestivalName(festivalName).ifPresentOrElse(
						f -> System.out.println("Festival Found : " + f),
						() -> System.out.println("Festival Not Found"));
			}

			case 5 -> {
				String festivalName = IO.readln("Enter Festival Name : ");

				System.out.println("\nArtists performing in " + festivalName + " :");

				artistRepo.findArtistsByFestivalName(festivalName).forEach(System.out::println);
			}

			case 6 -> {
				String artistName = IO.readln("Enter Artist Name : ");

				System.out.println("\nFestivals attended by " + artistName + " :");

				festivalRepo.findFestivalsByArtistName(artistName).forEach(System.out::println);
			}

			case 7 -> {
				String festivalName = IO.readln("Enter Festival Name : ");
				Double ticketPrice = Double.parseDouble(IO.readln("Enter New Ticket Price : "));

				festivalRepo.findByFestivalName(festivalName).ifPresentOrElse(f -> {
					f.setTicketPrice(ticketPrice);
					festivalRepo.save(f);
					System.out.println("Festival Ticket Price Updated Successfully");
				}, () -> System.out.println("Festival Not Found"));
			}

			case 8 -> {
				String artistName = IO.readln("Enter Artist Name : ");
				Integer experienceYears = Integer.parseInt(IO.readln("Enter New Experience Years : "));

				artistRepo.findByArtistName(artistName).ifPresentOrElse(a -> {
					a.setExperienceYears(experienceYears);
					artistRepo.save(a);
					System.out.println("Artist Experience Updated Successfully");
				}, () -> System.out.println("Artist Not Found"));
			}

			case 9 -> {
				String artistName = IO.readln("Enter Artist Name : ");

				artistRepo.findByArtistName(artistName).ifPresentOrElse(a -> {
					artistRepo.delete(a);
					System.out.println("Artist Deleted Successfully");
				}, () -> System.out.println("Artist Not Found"));
			}

			case 10 -> {
				String festivalName = IO.readln("Enter Festival Name : ");

				festivalRepo.findByFestivalName(festivalName).ifPresentOrElse(f -> {
					festivalRepo.delete(f);
					System.out.println("Festival Deleted Successfully");
				}, () -> System.out.println("Festival Not Found"));
			}

			case 11 -> {
				System.out.println("\nAll Artists:");
				artistRepo.findAll().forEach(System.out::println);
			}

			case 12 -> {
				System.out.println("\nAll Festivals:");
				festivalRepo.findAll().forEach(System.out::println);
			}

			case 13 -> {
				System.out.println("Application Closed Successfully");
				System.exit(0);
			}

			default -> System.out.println("Invalid Choice");
			}
		}
	}
}