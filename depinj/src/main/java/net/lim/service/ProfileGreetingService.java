package net.lim.service;

import net.lim.repositories.GreetingRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
//
//@Service
//@Profile("pr-1")
//@Primary
public class ProfileGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    public ProfileGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }


    @Override
    public String getGreetingMessage() {
        return greetingRepository.getGermanGreeting();
    }
}
