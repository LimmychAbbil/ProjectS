package net.lim.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public String getGreeting() {
        return "Abc";
    }

    @Override
    public String getGermanGreeting() {
        return "DAS ABC";
    }
}
