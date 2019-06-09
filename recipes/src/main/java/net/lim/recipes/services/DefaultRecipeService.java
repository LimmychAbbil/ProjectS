package net.lim.recipes.services;

import net.lim.recipes.model.Recipe;
import net.lim.recipes.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultRecipeService implements RecipeService{
    private RecipeRepository recipeRepository;

    public DefaultRecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<String> getListOfRecipes() {
        List<String> recipes = new ArrayList<>();
        recipeRepository.findAll().forEach(recipe -> recipes.add(recipe.getDescriptions()));
        return recipes;
    }
}
