package net.lim;

import net.lim.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DepinjApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DepinjApplication.class, args);
        MyController controller = (MyController) ctx.getBean("myController");
        controller.hello();
    }

}
