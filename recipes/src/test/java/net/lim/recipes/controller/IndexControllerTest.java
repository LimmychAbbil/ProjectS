package net.lim.recipes.controller;

import net.lim.recipes.commands.CategoryCommand;
import net.lim.recipes.model.Category;
import net.lim.recipes.model.Recipe;
import net.lim.recipes.services.CategoryService;
import net.lim.recipes.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    IndexController indexController;

    @Mock
    Model model;

    @Mock
    RecipeService recipeService;

    @Mock
    CategoryService categoryService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService, categoryService);
    }

    @Test
    public void testMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
    @Test
    public void getIndexPage() {
        String expectedString = "index";

        String resultString = indexController.getIndexPage(model);
        assertEquals(expectedString, resultString);
        verify(recipeService).getListOfRecipes();
        verify(model).addAttribute(eq("recipe"), any());
    }

    @Test
    public void deleteEmptyCategoryTest() {
        String expectedString = "categories";
        Category category = new Category();
        category.setId(1L);
        category.setCategoryName("Some empty category");
        Mockito.when(categoryService.getAllCategories()).thenReturn(Collections.singleton(category));
        Mockito.when(categoryService.deleteCategory(category)).thenReturn(true);
        String resultString = indexController.deleteCategory(String.valueOf(category.getId()), model);

        assertEquals(expectedString, resultString);
        verify(categoryService).deleteCategory(category);
    }


    @Test
    public void deleteNotEmptyCategoryTest() {
        String expectedString = "redirect:/index";
        Category category = new Category();
        category.setId(1L);
        category.setRecipes(new HashSet<>());
        category.getRecipes().add(new Recipe());
        category.setCategoryName("Some not empty category");

        Mockito.when(categoryService.getAllCategories()).thenReturn(Collections.singleton(category));

        String resultString = indexController.deleteCategory(String.valueOf(category.getId()), model);

        assertEquals(expectedString, resultString);
        verify(categoryService).deleteCategory(category);
    }
}