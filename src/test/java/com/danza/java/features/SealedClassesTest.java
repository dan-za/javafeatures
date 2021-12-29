package com.danza.java.features;

import org.junit.jupiter.api.Test;

/**
 * @since Java 17
 */
public class SealedClassesTest {

    /**
     * No class can inherit vom final class
     */
    final class Circle implements Shape {

    }

    /**
     * Any class may inherit from non-sealed class
     */
    non-sealed class Square implements Shape {

    }

    /**
     * sealed classes/interfaces must define which classes are permitted to extend/implement it
     */
    sealed interface Shape permits Circle, Square {

    }

    @Test
    void instanceTest() {

        Shape myShape = new Circle();

        if (myShape instanceof Circle c) {
            System.out.println(c);
        } else if (myShape instanceof Square s) {
            System.out.println(s);
        } else {
            // Not needed, code block is unreachable!
            throw new RuntimeException("unreachable!");
        }

    }
}
