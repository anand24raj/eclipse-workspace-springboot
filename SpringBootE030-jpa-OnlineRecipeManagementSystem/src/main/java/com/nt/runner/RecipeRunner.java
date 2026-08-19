package com.nt.runner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.RecipeBook;
import com.nt.service.RecipeService;

@Component
public class RecipeRunner implements CommandLineRunner {

	private final RecipeService service;

	RecipeRunner(RecipeService service) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {

		while (true) {

			IO.println("\n========== Recipe Book Menu ==========");
			IO.println("1. Add Recipe");
			IO.println("2. View All Recipes");
			IO.println("3. View Recipe By ID");
			IO.println("4. Update Ingredients");
			IO.println("5. Delete Recipe");
			IO.println("6. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

			switch (choice) {

			case 1 -> {
				String recipeName = IO.readln("Enter Recipe Name : ");
				String cuisine = IO.readln("Enter Cuisine : ");

				int ingCount = Integer.parseInt(IO.readln("Enter Number of Ingredients : "));
				List<String> ingredients = new ArrayList<>();

				for (int i = 1; i <= ingCount; i++) {
					String ingredient = IO.readln("Enter Ingredient " + i + " : ");
					ingredients.add(ingredient);
				}

				int tipCount = Integer.parseInt(IO.readln("Enter Number of Cooking Tips : "));
				Set<String> cookingTips = new HashSet<>();

				for (int i = 1; i <= tipCount; i++) {
					String tip = IO.readln("Enter Cooking Tip " + i + " : ");
					cookingTips.add(tip);
				}

				RecipeBook recipe = new RecipeBook(null, recipeName, cuisine, ingredients, cookingTips);

				String result = service.saveRecipe(recipe);
				IO.println(result);
			}

			case 2 -> {
				IO.println("\nAll Recipes:");

				boolean found = false;

				for (RecipeBook recipe : service.getAllRecipes()) {
					displayRecipe(recipe);
					found = true;
				}

				if (!found) {
					IO.println("No Recipes Found");
				}
			}

			case 3 -> {
				Long recipeId = Long.parseLong(IO.readln("Enter Recipe ID : "));

				RecipeBook recipe = service.getRecipeById(recipeId);

				if (recipe != null) {
					displayRecipe(recipe);
				} else {
					IO.println("Recipe ID Not Found");
				}
			}

			case 4 -> {
				Long recipeId = Long.parseLong(IO.readln("Enter Recipe ID : "));

				int ingCount = Integer.parseInt(IO.readln("Enter Number of New Ingredients : "));
				List<String> ingredients = new ArrayList<>();

				for (int i = 1; i <= ingCount; i++) {
					String ingredient = IO.readln("Enter Ingredient " + i + " : ");
					ingredients.add(ingredient);
				}

				String result = service.updateIngredients(ingredients, recipeId);
				IO.println(result);
			}

			case 5 -> {
				Long recipeId = Long.parseLong(IO.readln("Enter Recipe ID : "));
				service.deleteRecipe(recipeId);
			}

			case 6 -> {
				IO.println("Application Closed Successfully");
				System.exit(0);
			}

			default -> IO.println("Invalid Choice");
			}
		}
	}

	private void displayRecipe(RecipeBook recipe) {
		IO.println("--------------------------------");
		IO.println("Recipe ID    : " + recipe.getRecipeId());
		IO.println("Recipe Name  : " + recipe.getRecipeName());
		IO.println("Cuisine      : " + recipe.getCuisine());
		IO.println("Ingredients  : " + recipe.getIngredients());
		IO.println("Cooking Tips : " + recipe.getCookingTips());
		IO.println("--------------------------------");
	}
}