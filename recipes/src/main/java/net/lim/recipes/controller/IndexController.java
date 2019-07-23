package net.lim.recipes.controller;

import lombok.extern.slf4j.Slf4j;
import net.lim.recipes.commands.CategoryCommand;
import net.lim.recipes.model.Category;
import net.lim.recipes.model.Recipe;
import net.lim.recipes.services.CategoryService;
import net.lim.recipes.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class IndexController {

    private RecipeService service;
    private CategoryService categoryService;

    public IndexController(RecipeService service, CategoryService categoryService) {
        this.service = service;
        this.categoryService = categoryService;
    }

    @RequestMapping(value = {"", "/", "index"})
    public String getIndexPage(Model model) {
        List<Recipe> recipeList = service.getListOfRecipes();
        model.addAttribute("recipe", recipeList);
        model.addAttribute("description", "All recipes list");
        log.debug("Get index page request. Available recipes size: " + recipeList.size());
        return "index";
    }

    @RequestMapping("/categories")
    public String getCategoriesPage(Model model) {
        Set<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @RequestMapping("/recipe/{id}")
    public String getRecipePage(@PathVariable String id, Model model) {
        model.addAttribute("recipe", service.getRecipeById(Long.valueOf(id)));
        return "recipe";
    }

    @RequestMapping("/add")
    public String getAddPage() {
        return "redirect:/add.html";
    }

    @GetMapping("/add/category")
    public String getAddCommandPage(Model model) {
        CategoryCommand command = new CategoryCommand();
        model.addAttribute("category", command);
        return "addcategory";
    }

    @PostMapping("/add/category")
    public String submitNewCommand(@ModelAttribute CategoryCommand command) {
        categoryService.addOrUpdateCategory(command);
        return "redirect:/categories";
    }

    @RequestMapping("/recipes/show/category/{id}")
    public String showRecipesForCategory(@PathVariable String id, Model model) {
        List<Recipe> allRecipesList = service.getListOfRecipes();
        Category category = categoryService.getCategoryById(Long.valueOf(id));

        List<Recipe> recipesFromCategory = allRecipesList.stream().filter(r -> r.getCategories().contains(category)).collect(Collectors.toList());
        model.addAttribute("recipe", recipesFromCategory);
        model.addAttribute("description", "Recipes from category " + category.getCategoryName());
        log.debug("Get category filtered recipes request. Available recipes size: " + recipesFromCategory.size());
        return "index";
    }

    @RequestMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable String id, Model model) {
        Category category = categoryService.getAllCategories().stream().filter(c -> c.getId().equals(Long.valueOf(id))).collect(Collectors.toList()).get(0);
        boolean success = categoryService.deleteCategory(category);
        if (success) {
            log.info("Category " + category.getCategoryName() + " was deleted");
            model.addAttribute("categories", categoryService.getAllCategories());
            return "categories";
        } else {
            log.error("Can't delete category");
            return "redirect:/index"; //todo show error
        }
    }
}
