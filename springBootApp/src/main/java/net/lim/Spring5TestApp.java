package net.lim;

import net.lim.example.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5TestApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Spring5TestApp.class, args);

        FakeDataSource dataSource = context.getBean(FakeDataSource.class);

        System.out.println(dataSource.getUser());
    }
}
