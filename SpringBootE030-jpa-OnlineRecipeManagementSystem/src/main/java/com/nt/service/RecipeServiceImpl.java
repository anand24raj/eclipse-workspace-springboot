package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.entity.RecipeBook;
import com.nt.repository.RecipeBookRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeBookRepository repo;

	RecipeServiceImpl(RecipeBookRepository repo) {
		this.repo = repo;
	}

	@Override
	public String saveRecipe(RecipeBook rBook) {
		RecipeBook saved = repo.save(rBook);
		return saved != null ? "Recipe Saved Successfully" : "Recipe Not Saved";
	}

	@Override
	public Iterable<RecipeBook> getAllRecipes() {
		return repo.findAll();
	}

	@Override
	public RecipeBook getRecipeById(Long rid) {
		return repo.findById(rid).orElse(null);
	}

	@Override
	public String updateIngredients(List<String> ingredients, Long rid) {
		RecipeBook rBook = repo.findById(rid).orElse(null);

		if (rBook != null) {
			rBook.setIngredients(ingredients);
			repo.save(rBook);
			return "Ingredients Updated Successfully";
		}

		return "Recipe ID Not Found";
	}

	@Override
	public void deleteRecipe(Long rid) {
		if (repo.existsById(rid)) {
			repo.deleteById(rid);
			IO.println("Recipe Deleted Successfully");
		} else {
			IO.println("Recipe ID Not Found");
		}
	}
}