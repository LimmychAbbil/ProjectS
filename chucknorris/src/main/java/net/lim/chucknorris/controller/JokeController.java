package net.lim.chucknorris.controller;

import net.lim.chucknorris.service.StandardJokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private StandardJokeService service;

    public JokeController(StandardJokeService service) {
        this.service = service;
    }

    @RequestMapping({"/", ""})
    public String getAuthors(Model model) {
        model.addAttribute("joke", service.getRandomJoke());

        return "chucknorris";
    }
}
