package com.nt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByArtistName(String artistName);

    @Query("SELECT a FROM Artist a JOIN a.festivals f WHERE f.festivalName = :festivalName")
    Iterable<Artist> findArtistsByFestivalName(String festivalName);
}