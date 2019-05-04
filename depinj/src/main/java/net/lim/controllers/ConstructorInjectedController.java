package net.lim.controllers;

import net.lim.service.GreetingService;

public class ConstructorInjectedController {

    private GreetingService greetingService;

    void sayHello() {
        System.out.println(greetingService.getGreetingMessage());
    }

    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
