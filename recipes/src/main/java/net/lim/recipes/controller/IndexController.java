package net.lim.recipes.controller;

import net.lim.recipes.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private RecipeService service;

    public IndexController(RecipeService service) {
        this.service = service;
    }

    @RequestMapping(value = {"", "/", "index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipe", service.getListOfRecipes());
        return "index";
    }
}
