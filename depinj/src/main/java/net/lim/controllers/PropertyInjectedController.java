package net.lim.controllers;

import net.lim.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Autowired
    public GreetingService greetingService;

    public void sayHello() {
        System.out.println(greetingService.getGreetingMessage());
    }
}
