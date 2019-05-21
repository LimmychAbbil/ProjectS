package net.lim.service;

import net.lim.repositories.GreetingRepository;

public class GreetingServiceFactory {

    private GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String lang) {
        switch (lang) {
            case "de":
                return new ProfileGreetingService(greetingRepository);
                default:
                    return new GreetingServiceImpl(greetingRepository);
        }
    }


}
