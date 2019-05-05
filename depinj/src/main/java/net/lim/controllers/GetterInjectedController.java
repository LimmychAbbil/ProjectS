package net.lim.controllers;

import net.lim.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GetterInjectedController {
    
    private GreetingService greetingService;

    public void sayHello() {
        System.out.println(greetingService.getGreetingMessage());
    }
    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        System.out.println("123");
        this.greetingService = greetingService;
    }
}
