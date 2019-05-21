package net.lim.repositories;

import net.lim.service.GreetingService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository  {
    String getGreeting();

    String getGermanGreeting();
}
