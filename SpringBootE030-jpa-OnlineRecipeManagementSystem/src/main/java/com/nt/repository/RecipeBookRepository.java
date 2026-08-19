package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.RecipeBook;

public interface RecipeBookRepository extends JpaRepository<RecipeBook, Long> {

}
