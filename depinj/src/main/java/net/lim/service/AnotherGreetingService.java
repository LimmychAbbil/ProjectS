package net.lim.service;

import org.springframework.stereotype.Service;

@Service
public class AnotherGreetingService implements GreetingService {
    @Override
    public String getGreetingMessage() {
        return "No greeting today";
    }
}
