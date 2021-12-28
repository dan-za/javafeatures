package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InterfacePrivateMethodsTest {

    interface CustomInterface {

        default String sayHello() {
            return createComplexString();
        }

        private String createComplexString() {
            return "abc";
        }
    }

    @Test
    void example() {

        CustomInterface c = new CustomInterface() {};
        Assertions.assertEquals("abc", c.sayHello());
    }

}
