package com.danza.java.features;

import org.junit.jupiter.api.Test;

/**
 * @since Java 14
 */
public class SwitchExpressionsTest {

    enum Days {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    @Test
    void oldStyle() {

        Days day = Days.FRIDAY;

        switch (day) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("No weekend");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekend");
                break;
            default:
                throw new IllegalStateException("Unknown day");
        }
    }

    @Test
    void newStyle() {
        Days day = Days.FRIDAY;

        switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("No weekend");
            case SATURDAY, SUNDAY -> System.out.println("Weekend");
            default -> throw new IllegalStateException("Unknown day");
        }
    }

}
