package net.lim.controllers;

import net.lim.config.GreetingServiceConfig;
import net.lim.repositories.GreetingRepository;
import net.lim.service.GreetingServiceFactory;
import net.lim.service.GreetingServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PropertyInjectedControllerTest {

    PropertyInjectedController propertyInjectedController;
    private ByteArrayOutputStream byteArrayOutputStream;
    PrintStream defaultStream;

    @Before
    public void setUp() {
        defaultStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        this.propertyInjectedController = new PropertyInjectedController();
//        propertyInjectedController.anotherGreetingService = new GreetingServiceImpl();
    }

    @Test
    public void test1() {
        propertyInjectedController.sayHello();
        assertTrue(byteArrayOutputStream.toByteArray().length != 0);
        assertEquals("Hello lim" + System.lineSeparator(), new String(byteArrayOutputStream.toByteArray()));
    }

    @After
    public void reset() {
        System.setOut(defaultStream);
    }


}