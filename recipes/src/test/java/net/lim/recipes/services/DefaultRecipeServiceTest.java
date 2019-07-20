package net.lim.recipes.services;

import net.lim.recipes.model.Recipe;
import net.lim.recipes.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultRecipeServiceTest {

    DefaultRecipeService service;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new DefaultRecipeService(recipeRepository);

    }

    @Test
    public void getListOfRecipes() {
        Recipe someRecipe = new Recipe();

        when(recipeRepository.findAll()).thenReturn(Collections.singletonList(someRecipe));

        List<Recipe> recipeSet = service.getListOfRecipes();

        verify(recipeRepository).findAll();
        assertEquals(1, recipeSet.size());

    }

}