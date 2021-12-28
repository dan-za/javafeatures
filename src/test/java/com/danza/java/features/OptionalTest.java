package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    void of() {
        String value = "123";

        Optional<String> optionalValue = Optional.of(value);
        Assertions.assertTrue(optionalValue.isPresent());
        Assertions.assertEquals(value, optionalValue.get());
    }

    @Test
    void map() {
        Assertions.assertEquals(123, Optional.of("123").map(Integer::valueOf).orElse(-1));
    }

    @Test
    void ofWithNull() {
        Assertions.assertThrows(NullPointerException.class, () -> Optional.of(null));
    }

    @Test
    void ofNullable() {

        Optional<String> optionalValue = Optional.ofNullable(null);
        Assertions.assertFalse(optionalValue.isPresent());
        Assertions.assertEquals("123", optionalValue.orElse("123"));
    }

}
