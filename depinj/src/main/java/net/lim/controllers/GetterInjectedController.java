package net.lim.controllers;

import net.lim.service.GreetingService;

public class GetterInjectedController {

    private GreetingService greetingService;

    void sayHello() {
        System.out.println(greetingService.getGreetingMessage());
    }

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
