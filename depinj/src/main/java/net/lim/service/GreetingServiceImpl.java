package net.lim.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String getGreetingMessage() {
        return "Hello lim";
    }
}
