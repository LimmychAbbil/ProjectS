package net.lim.recipes.services;

import net.lim.recipes.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getListOfRecipes();
    Recipe getRecipeById(Long id);
}
