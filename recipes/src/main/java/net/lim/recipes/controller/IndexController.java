package net.lim.recipes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = {"", "/", "index"})
    public String getIndexPage() {
        return "index";
    }
}
