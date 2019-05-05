package net.lim.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("pr-1")
@Primary
public class ProfileGreetingService implements GreetingService {

    @Override
    public String getGreetingMessage() {
        return "profile hello";
    }
}
