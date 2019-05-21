package net.lim.controllers;

import net.lim.service.GreetingServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class GetterInjectedControllerTest {

    GetterInjectedController propertyInjectedController;
    private ByteArrayOutputStream byteArrayOutputStream;
    PrintStream defaultStream;

    @Before
    public void setUp() {
        defaultStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        this.propertyInjectedController = new GetterInjectedController();
//        propertyInjectedController.setGreetingService(new GreetingServiceImpl());
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