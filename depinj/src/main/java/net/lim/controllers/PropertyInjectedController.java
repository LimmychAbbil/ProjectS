package net.lim.controllers;

import net.lim.service.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    void sayHello() {
        System.out.println(greetingService.getGreetingMessage());
    }
}
