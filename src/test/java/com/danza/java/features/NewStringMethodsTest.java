package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

public class NewStringMethodsTest {

    /**
     * @since Java 11
     */
    @Test
    void lines() {

        var result = "hello\nworld".lines().collect(Collectors.toList());

        Assertions.assertEquals(2, result.size());
    }

    /**
     * @since Java 11
     */
    @Test
    void repeat() {

        var result = "hello".repeat(3);

        Assertions.assertEquals("hellohellohello", result);
    }

    /**
     * @since Java 11
     */
    @Test
    void strip() {
        var result = "   hello world!  ".strip();
        Assertions.assertEquals("hello world!", result);
    }

    /**
     * @since Java 11
     */
    @Test
    void isBlank() {
        Assertions.assertTrue("".isBlank());
        Assertions.assertTrue(" ".isBlank());
        Assertions.assertTrue("   ".isBlank());
    }

    /**
     * @since Java 12
     */
    @Test
    void indent() {
        var result = "hello\nworld".indent(2).lines().collect(Collectors.toList());

        Assertions.assertEquals(2, result.size());
        var iterator = result.iterator();
        Assertions.assertEquals("  hello", iterator.next());
        Assertions.assertEquals("  world", iterator.next());
    }

    /**
     * @since Java 12
     */
    @Test
    void transform() {
        var result = "hello".transform(c -> c + " world");
        Assertions.assertEquals("hello world", result);
    }

}
