package com.nt.service;

import java.util.List;

import com.nt.entity.RecipeBook;

public interface RecipeService {

	String saveRecipe(RecipeBook rBook);

	Iterable<RecipeBook> getAllRecipes();

	RecipeBook getRecipeById(Long rid);

	String updateIngredients(List<String> ingredients, Long rid);

	void deleteRecipe(Long rid);
}