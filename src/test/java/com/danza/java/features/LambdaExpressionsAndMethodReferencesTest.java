package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class LambdaExpressionsAndMethodReferencesTest {

    List<String> names = Arrays.asList("Ruth", "Catherine", "Gerry", "Rodger");

    @Test
    void startsWithR() {

        Predicate<? super String> predicate = e -> e.startsWith("R");

        Assertions.assertEquals(2, names.stream().filter(predicate).count());
    }

    @Test
    void methodReference() {
        Assertions.assertEquals("abc", Optional.of("ABC").map(String::toLowerCase).get());
    }

    @Test
    void customMethodReference() {
        Assertions.assertEquals("Value=332", Optional.of(332).map(this::getNeatString).orElseThrow());
    }

    String getNeatString(int value) {
        return "Value=" + value;
    }
}
