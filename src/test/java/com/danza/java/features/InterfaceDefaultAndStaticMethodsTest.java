package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InterfaceDefaultAndStaticMethodsTest {

    public interface CustomInterface {

        default String getHello() { return "hello"; }

        static String myStaticMethod() { return "Static!";}
    }

    @Test
    void defaultMethod() {
        CustomInterface classUnderTest = new CustomInterface() {};
        Assertions.assertEquals("hello", classUnderTest.getHello());
    }

    @Test
    void defaultMethodOverride() {
        CustomInterface classUnderTest = new CustomInterface() {
            @Override
            public String getHello() {
                return "Bye";
            }
        };
        Assertions.assertEquals("Bye", classUnderTest.getHello());
    }

    @Test
    void staticMethod() {
        Assertions.assertEquals("Static!", CustomInterface.myStaticMethod());
    }

}
