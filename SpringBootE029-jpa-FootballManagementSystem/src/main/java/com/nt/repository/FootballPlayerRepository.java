package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.nt.entity.FootballPlayer;

import jakarta.transaction.Transactional;

@EnableJpaRepositories

public interface FootballPlayerRepository extends JpaRepository<FootballPlayer, Long> {

	@Query("SELECT f FROM FootballPlayer f WHERE f.club = :club")
	List<FootballPlayer> findByClubIgnoreCase(@Param("club") String club);

	@Query("SELECT f FROM FootballPlayer f WHERE f.salary > :salary")
	List<FootballPlayer> findPlayersWithSalaryGreaterThan(@Param("salary") Double salary);

	@Query("SELECT f FROM FootballPlayer f WHERE f.position = :position AND f.country = :country")
	List<FootballPlayer> findByPositionAndCountryIgnoreCase(@Param("position") String position,
			@Param("country") String country);

	@Query("SELECT f FROM FootballPlayer f WHERE f.playerName LIKE CONCAT(:prefix, '%')")
	List<FootballPlayer> findByNameStartsWithIgnoreCase(@Param("prefix") String prefix);

	@Query("SELECT f FROM FootballPlayer f WHERE f.jerseyNumber BETWEEN :start AND :end")
	List<FootballPlayer> findByJerseyNumberBetween(@Param("start") Integer start, @Param("end") Integer end);

	@Query("SELECT COUNT(f) FROM FootballPlayer f WHERE f.country = :country")
	Long countPlayersByCountryIgnoreCase(@Param("country") String country);

	@Query("SELECT f FROM FootballPlayer f ORDER BY f.salary DESC")
	List<FootballPlayer> findHighestPaidPlayers();

	@Modifying
	@Transactional
	@Query("UPDATE FootballPlayer f SET f.salary = :salary WHERE f.playerId = :id")
	int updateSalary(@Param("id") Long id, @Param("salary") Double salary);

	@Modifying
	@Transactional
	@Query("DELETE FROM FootballPlayer f WHERE f.club = :club")
	int deleteByClubIgnoreCase(@Param("club") String club);

	@Query("SELECT f.playerName, f.club FROM FootballPlayer f")
	List<Object[]> getPlayerNameAndClubIgnoreCase();

}
