package net.lim.service;

import net.lim.repositories.GreetingRepository;
import org.springframework.stereotype.Service;

//@Service
public class GreetingServiceImpl implements GreetingService {

    private GreetingRepository greetingRepository;

    public GreetingServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String getGreetingMessage() {
        return greetingRepository.getGreeting();
    }
}
