package net.lim;

import net.lim.controllers.ConstructorInjectedController;
import net.lim.controllers.GetterInjectedController;
import net.lim.controllers.MyController;
import net.lim.controllers.PropertyInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DepinjApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DepinjApplication.class, args);
        MyController controller = (MyController) ctx.getBean("myController");
        controller.hello();

        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        propertyInjectedController.sayHello();

        GetterInjectedController getterInjectedController = (GetterInjectedController) ctx.getBean("getterInjectedController");
        getterInjectedController.sayHello();

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        constructorInjectedController.sayHello();
    }

}
