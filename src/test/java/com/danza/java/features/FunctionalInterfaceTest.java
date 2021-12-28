package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FunctionalInterfaceTest {

    @FunctionalInterface
    public interface CustomFunctionalInterface {

        String addAndConvertToString(int first, long second);
    }

    @Test
    void usage() {

        CustomFunctionalInterface classUnderTest = (a, b) -> String.valueOf(a + b);

        Assertions.assertEquals("145", classUnderTest.addAndConvertToString(45, 100L));
    }
}
