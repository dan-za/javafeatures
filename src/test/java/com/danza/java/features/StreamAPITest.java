package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPITest {

    List<Integer> container = Arrays.asList(54, 33, 12, 32);

    @Test
    void count() {

        long count = container.stream().count();
        Assertions.assertEquals(4, count);
    }

    @Test
    void filter() {
        long count = container.stream().filter(e -> e < 50).count();
        Assertions.assertEquals(3, count);
    }

    @Test
    void mapAndCollect() {
        List<String> result = container.stream().map(Object::toString).collect(Collectors.toList());
        Assertions.assertEquals(Arrays.asList("54", "33", "12", "32"), result);
    }

    @Test
    void mapAndJoin() {
        String result = container.stream().map(Object::toString).collect(Collectors.joining(","));
        Assertions.assertEquals("54,33,12,32", result);
    }

     @Test
    void anyMatch() {
        Assertions.assertTrue(container.stream().anyMatch(e -> Integer.valueOf(54).equals(e)));
        Assertions.assertFalse(container.stream().anyMatch(e -> Integer.valueOf(93).equals(e)));
    }

    @Test
    void noneMatch() {
        boolean result = container.stream().noneMatch(e -> e > 100);
        // Is no number greater 100?
        Assertions.assertTrue(result);
    }

    @Test
    void allMatch() {
        boolean result = container.stream().allMatch(e -> e > 1);
        // Are all numbers greater than one?
        Assertions.assertTrue(result);
    }

    @Test
    void reduce() {
        Optional<Integer> result = container.stream().reduce((a, b) -> a + b);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(131, result.get());
    }

    @Test
    void print() {
        container.forEach(System.out::println);
    }
}
