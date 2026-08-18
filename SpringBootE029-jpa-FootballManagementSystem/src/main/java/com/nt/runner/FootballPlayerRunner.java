package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.FootballPlayerRepository;

@Component
public class FootballPlayerRunner implements CommandLineRunner {

	@Autowired
	private FootballPlayerRepository repo;

	@Override
	public void run(String... args) throws Exception {

		while (true) {

			IO.println("\n===== FOOTBALL PLAYER MANAGEMENT SYSTEM =====");
			IO.println("1. Find Players by Club");
			IO.println("2. Find Players with Salary Greater Than");
			IO.println("3. Find Players by Position and Country");
			IO.println("4. Find Players Name Starts With");
			IO.println("5. Find Players by Jersey Number Range");
			IO.println("6. Count Players by Country");
			IO.println("7. Find Highest Paid Players");
			IO.println("8. Update Player Salary");
			IO.println("9. Delete Players by Club");
			IO.println("10. Display Player Name and Club");
			IO.println("11. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

			switch (choice) {

			case 1 -> {
				String club = IO.readln("Enter Club Name : ");
				IO.println("\nPlayers from Club : " + club);
				repo.findByClubIgnoreCase(club).forEach(IO::println);
			}

			case 2 -> {
				Double salary = Double.parseDouble(IO.readln("Enter Salary : "));

				IO.println("\nPlayers having salary greater than " + salary);

				repo.findPlayersWithSalaryGreaterThan(salary).forEach(IO::println);
			}

			case 3 -> {
				String position = IO.readln("Enter Position : ");
				String country = IO.readln("Enter Country : ");

				IO.println("\nPlayers Details:");

				repo.findByPositionAndCountryIgnoreCase(position, country).forEach(IO::println);
			}

			case 4 -> {
				String prefix = IO.readln("Enter Name Prefix : ");

				IO.println("\nPlayers Starting With " + prefix);

				repo.findByNameStartsWithIgnoreCase(prefix).forEach(IO::println);
			}

			case 5 -> {
				Integer start = Integer.parseInt(IO.readln("Enter Starting Jersey Number : "));

				Integer end = Integer.parseInt(IO.readln("Enter Ending Jersey Number : "));

				IO.println("\nPlayers Between Jersey Numbers " + start + " and " + end);

				repo.findByJerseyNumberBetween(start, end).forEach(IO::println);
			}

			case 6 -> {
				String country = IO.readln("Enter Country : ");

				Long count = repo.countPlayersByCountryIgnoreCase(country);

				IO.println("\nTotal Players from " + country + " : " + count);
			}

			case 7 -> {
				IO.println("\nHighest Paid Players:");

				repo.findHighestPaidPlayers().forEach(IO::println);
			}

			case 8 -> {
				Long id = Long.parseLong(IO.readln("Enter Player Id : "));

				Double salary = Double.parseDouble(IO.readln("Enter New Salary : "));

				int count = repo.updateSalary(id, salary);

				IO.println(count + " Record Updated Successfully");
			}

			case 9 -> {
				String club = IO.readln("Enter Club Name : ");

				int count = repo.deleteByClubIgnoreCase(club);

				IO.println(count + " Record(s) Deleted Successfully");
			}

			case 10 -> {

				List<Object[]> list = repo.getPlayerNameAndClubIgnoreCase();

				IO.println("\nPlayer Name\t\tClub");

				for (Object[] obj : list) 
				{
					IO.println(obj[0] + "\t\t" + obj[1]);
				}
			}

			case 11 -> {
				IO.println("Application Closed Successfully");
				System.exit(0);
			}

			default -> IO.println("Invalid Choice");
			}
		}
	}
}