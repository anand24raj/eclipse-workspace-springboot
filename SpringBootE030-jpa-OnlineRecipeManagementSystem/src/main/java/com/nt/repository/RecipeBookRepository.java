package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.RecipeBook;

@Repository
public interface RecipeBookRepository extends JpaRepository<RecipeBook ,Long> 
{
	

}
