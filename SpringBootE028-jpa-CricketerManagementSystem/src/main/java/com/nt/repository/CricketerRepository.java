package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Cricketer;

public interface CricketerRepository extends JpaRepository<Cricketer, Long> {

	@Query("SELECT c FROM Cricketer c WHERE c.country = :country")
	List<Cricketer> findByCountryIgnoreCase(String country);
	
	@Query("SELECT c FROM Cricketer c WHERE c.battingAverage > :avg")
	List<Cricketer> findPlayersWithAverageGreaterThan(Double avg);

	@Query("SELECT c FROM Cricketer c WHERE c.role = 'Batsman'")
	List<Cricketer> findAllBatsmen();

	@Query("SELECT c FROM Cricketer c WHERE c.playerName LIKE CONCAT(:prefix,'%')")
	List<Cricketer> findByPlayerNameStartingWithIgnoreCase(String prefix);
	
	@Query("SELECT c FROM Cricketer c WHERE c.retired = true")
	List<Cricketer> findRetiredPlayers();

	@Query("SELECT c FROM Cricketer c WHERE c.centuries > :count")
	List<Cricketer> findPlayersWithMoreCenturies(Integer count);

	@Query("SELECT c FROM Cricketer c WHERE c.age BETWEEN :minAge AND :maxAge")
	List<Cricketer> findPlayersByAgeRange(Integer minAge, Integer maxAge);

	@Query("SELECT c FROM Cricketer c WHERE c.team = :team")
	List<Cricketer> findByTeamIgnoreCase(String team);

	@Query("SELECT COUNT(c) FROM Cricketer c WHERE c.country = :country")
	Long countByCountryIgnoreCase(String country);
	
	@Query("SELECT c FROM Cricketer c WHERE c.battingAverage = "
			+ "(SELECT MAX(x.battingAverage) FROM Cricketer x)")
	Cricketer findTopAveragePlayer();

}
