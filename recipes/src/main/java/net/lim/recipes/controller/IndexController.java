package net.lim.recipes.controller;

import lombok.extern.slf4j.Slf4j;
import net.lim.recipes.model.Recipe;
import net.lim.recipes.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class IndexController {

    private RecipeService service;

    public IndexController(RecipeService service) {
        this.service = service;
    }

    @RequestMapping(value = {"", "/", "index"})
    public String getIndexPage(Model model) {
        List<Recipe> recipeList = service.getListOfRecipes();
        model.addAttribute("recipe", recipeList);
        log.debug("Get index page request. Available recipes size: " + recipeList.size());
        return "index";
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
}
