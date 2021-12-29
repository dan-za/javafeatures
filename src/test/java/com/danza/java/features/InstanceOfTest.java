package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InstanceOfTest {

    private Object myObject;

    @BeforeEach
    void beforeEach() {
        myObject = "Hello";
    }

    @Test
    void instanceOfOldStyle() {

        if (myObject instanceof String) {
            String myString = (String) myObject;
            Assertions.assertEquals("Hello", myString);
        }
    }

    /**
     * @since Java 16
     */
    @Test
    void instanceOfNewStyle() {

        if (myObject instanceof String myString) {
            Assertions.assertEquals("Hello", myString);
        }
    }

}
