package com.nt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Festival;

public interface FestivalRepository extends JpaRepository<Festival, Long> {

    Optional<Festival> findByFestivalName(String festivalName);

    @Query("SELECT f FROM Festival f JOIN f.artists a WHERE a.artistName = :artistName")
    Iterable<Festival> findFestivalsByArtistName(String artistName);
}