package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Cricketer;
import com.nt.repository.CricketerRepository;

@Component
public class CricketerRunner implements CommandLineRunner {

    @Autowired
    private CricketerRepository repo;

    @Override
    public void run(String... args) throws Exception {

        while (true) {

            IO.println("\n===== CRICKETER MANAGEMENT SYSTEM =====");
            IO.println("1. Find Cricketers by Country");
            IO.println("2. Find Players with Batting Average Greater Than");
            IO.println("3. Find All Batsmen");
            IO.println("4. Find Players Starting With Prefix");
            IO.println("5. Find Retired Players");
            IO.println("6. Find Players with More Centuries");
            IO.println("7. Find Players by Age Range");
            IO.println("8. Find Cricketers by Team");
            IO.println("9. Count Players by Country");
            IO.println("10. Find Top Batting Average Player");
            IO.println("11. Exit");

            int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

            switch (choice) {

                case 1 -> {
                    String country = IO.readln("Enter Country : ");
                    IO.println("\nCricketers from " + country + ":");
                    repo.findByCountryIgnoreCase(country).forEach(IO::println);
                }

                case 2 -> {
                    Double avg = Double.parseDouble(IO.readln("Enter Batting Average : "));
                    IO.println("\nPlayers with batting average greater than " + avg + ":");
                    repo.findPlayersWithAverageGreaterThan(avg).forEach(IO::println);
                }

                case 3 -> {
                    IO.println("\nAll Batsmen:");
                    repo.findAllBatsmen().forEach(IO::println);
                }

                case 4 -> {
                    String prefix = IO.readln("Enter Player Name Prefix : ");
                    IO.println("\nPlayers starting with " + prefix + ":");
                    repo.findByPlayerNameStartingWithIgnoreCase(prefix).forEach(IO::println);
                }

                case 5 -> {
                    IO.println("\nRetired Players:");
                    repo.findRetiredPlayers().forEach(IO::println);
                }

                case 6 -> {
                    Integer count = Integer.parseInt(IO.readln("Enter Century Count : "));
                    IO.println("\nPlayers with centuries greater than " + count + ":");
                    repo.findPlayersWithMoreCenturies(count).forEach(IO::println);
                }

                case 7 -> {
                    Integer minAge = Integer.parseInt(IO.readln("Enter Minimum Age : "));
                    Integer maxAge = Integer.parseInt(IO.readln("Enter Maximum Age : "));

                    IO.println("\nPlayers between age " + minAge + " and " + maxAge + ":");
                    repo.findPlayersByAgeRange(minAge, maxAge).forEach(IO::println);
                }

                case 8 -> {
                    String team = IO.readln("Enter Team : ");
                    IO.println("\nCricketers from team " + team + ":");
                    repo.findByTeamIgnoreCase(team).forEach(IO::println);
                }

                case 9 -> {
                    String country = IO.readln("Enter Country : ");
                    Long count = repo.countByCountryIgnoreCase(country);
                    IO.println("\nTotal Players from " + country + " : " + count);
                }

                case 10 -> {
                    Cricketer cricketer = repo.findTopAveragePlayer();
                    IO.println("\nTop Batting Average Player:");
                    IO.println(cricketer);
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