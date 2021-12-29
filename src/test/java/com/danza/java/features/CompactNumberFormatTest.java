package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @since Java 12
 */
public class CompactNumberFormatTest {

    @Test
    void format() {

        long thousands = 123_456L;

        Assertions.assertEquals("123.456", NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.SHORT).format(thousands));
        Assertions.assertEquals("123 Tausend", NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.LONG).format(thousands));

        Assertions.assertEquals("123K", NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT).format(thousands));
        Assertions.assertEquals("123 thousand", NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG).format(thousands));

        long millions = 123_456_982L;

        Assertions.assertEquals("123 Mio.", NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.SHORT).format(millions));
        Assertions.assertEquals("123 Millionen", NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.LONG).format(millions));

        Assertions.assertEquals("123M", NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT).format(millions));
        Assertions.assertEquals("123 million", NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG).format(millions));
    }

}
