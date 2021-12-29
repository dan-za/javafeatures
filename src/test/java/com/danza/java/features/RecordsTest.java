package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @since Java 16
 */
public class RecordsTest {

    record NewPoint(int x, int y) {
    }

    @Test
    void testNewPoint() {
        // implicit constructor
        var newPoint = new NewPoint(1, 3);
        // implicit getter
        Assertions.assertEquals(1, newPoint.x());
        Assertions.assertEquals(3, newPoint.y());
        // implicit toString
        Assertions.assertEquals("NewPoint[x=1, y=3]", newPoint.toString());
        // implicit equals/hashcode
        Assertions.assertEquals(new NewPoint(1, 3), newPoint);
        Assertions.assertNotEquals(new NewPoint(2, 3), newPoint);
    }

}
