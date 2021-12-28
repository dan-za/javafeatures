package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateAndTimeAPITest {

    /**
     * ISO format (yyyy-MM-dd)
     */
    @Nested
    class LocalDateTests {

        @Test
        void parse() {

            LocalDate expectedResult = LocalDate.of(2019, Month.MARCH, 22);

            Assertions.assertEquals(expectedResult, LocalDate.parse("2019-03-22"));

            LocalDate actualResult = LocalDate.parse("22.03.2019", DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.GERMAN));
            Assertions.assertEquals(expectedResult, actualResult);
        }

        @Test
        void plus() {

            LocalDate localDate = LocalDate.parse("2019-03-22");

            Assertions.assertEquals("2019-03-23", localDate.plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE));
            Assertions.assertEquals("2021-03-22", localDate.plusYears(2).format(DateTimeFormatter.ISO_LOCAL_DATE));
            Assertions.assertEquals("2019-08-22", localDate.plusMonths(5).format(DateTimeFormatter.ISO_LOCAL_DATE));

        }

        @Test
        void minus() {

            LocalDate localDate = LocalDate.parse("2019-03-22");

            Assertions.assertEquals("2019-01-22", localDate.minusMonths(2).format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

        @Test
        void isEqual() {

            LocalDate localDate = LocalDate.parse("2019-03-22");

            Assertions.assertFalse(localDate.isEqual(LocalDate.parse("2019-03-21")));
            Assertions.assertTrue(localDate.isEqual(LocalDate.parse("2019-03-22")));
            Assertions.assertFalse(localDate.isEqual(LocalDate.parse("2019-03-23")));
        }

        @Test
        void isBefore() {

            LocalDate localDate = LocalDate.parse("2019-03-22");

            Assertions.assertFalse(localDate.isBefore(LocalDate.parse("2019-03-21")));
            Assertions.assertFalse(localDate.isBefore(LocalDate.parse("2019-03-22")));
            Assertions.assertTrue(localDate.isBefore(LocalDate.parse("2019-03-23")));
        }

        @Test
        void isAfter() {

            LocalDate localDate = LocalDate.parse("2019-03-22");

            Assertions.assertTrue(localDate.isAfter(LocalDate.parse("2019-03-21")));
            Assertions.assertFalse(localDate.isAfter(LocalDate.parse("2019-03-22")));
            Assertions.assertFalse(localDate.isAfter(LocalDate.parse("2019-03-23")));
        }
    }

    @Nested
    class LocalTimeTests {

        @Test
        void parse() {

            LocalTime localTimeWithoutSeconds = LocalTime.parse("10:15");
            Assertions.assertEquals("10:15:00", localTimeWithoutSeconds.format(DateTimeFormatter.ISO_LOCAL_TIME));

            LocalTime localTimeWithSecondsAndNanoSeconds = LocalTime.parse("10:15:30.100");
            Assertions.assertEquals("10:15:30.1", localTimeWithSecondsAndNanoSeconds.format(DateTimeFormatter.ISO_LOCAL_TIME));
        }

        @Test
        void plus() {
            LocalTime localTime = LocalTime.parse("10:15");

            LocalTime result = localTime.plus(1, ChronoUnit.HOURS);
            Assertions.assertEquals("11:15:00", result.format(DateTimeFormatter.ISO_LOCAL_TIME));
        }

        @Test
        void minus() {
            LocalTime localTime = LocalTime.parse("10:15");

            LocalTime result = localTime.minusMinutes(9);
            Assertions.assertEquals("10:06:00", result.format(DateTimeFormatter.ISO_LOCAL_TIME));
        }

        @Test
        void getter() {

            LocalTime localTime = LocalTime.parse("10:15");
            Assertions.assertEquals(10, localTime.getHour());
            Assertions.assertEquals(15, localTime.getMinute());
            Assertions.assertEquals(0, localTime.getSecond());
            Assertions.assertEquals(0, localTime.getNano());
        }

        @Test
        void isBefore() {

            LocalTime localTime = LocalTime.parse("10:15");
            Assertions.assertTrue(localTime.isBefore(LocalTime.parse("10:15:01")));
        }

        @Test
        void isAfter() {
            LocalTime localTime = LocalTime.parse("10:15");
            Assertions.assertTrue(localTime.isAfter(LocalTime.parse("10:14:59")));
        }

    }

    @Nested
    class LocalDateTimeTests {

        @Test
        void of() {

            LocalDateTime localDateTime = LocalDateTime.of(2019, Month.MARCH, 22, 10, 15);
            Assertions.assertEquals("2019-03-22T10:15:00", localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }

        @Test
        void parse() {

            LocalDateTime localDateTime = LocalDateTime.parse("2019-03-22T10:15:00");
            Assertions.assertEquals("2019-03-22T10:15:00", localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }

        @Test
        void plus() {
            LocalDateTime localDateTime = LocalDateTime.parse("2019-03-22T10:15:00");

            LocalDateTime result = localDateTime.plusDays(2);
            Assertions.assertEquals("2019-03-24T10:15:00", result.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }

        @Test
        void minus() {
            LocalDateTime localDateTime = LocalDateTime.parse("2019-03-22T10:15:00");

            LocalDateTime result = localDateTime.minusDays(2);
            Assertions.assertEquals("2019-03-20T10:15:00", result.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }


    }

    @Nested
    class ZonedDateTimeAndOffsetDateTimeTests {

        @Test
        void convertFromLocalDateTimeToZonedDateTime() {

            LocalDateTime localDateTime = LocalDateTime.parse("2019-03-22T10:15:00");

            ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Berlin"));
            Assertions.assertEquals("2019-03-22T10:15:00+01:00[Europe/Berlin]", zonedDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
            Assertions.assertEquals("2019-03-22T10:15:00+01:00", zonedDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));

            Assertions.assertEquals("2019-03-22T09:15Z[UTC]", zonedDateTime.toOffsetDateTime().atZoneSameInstant(ZoneId.of("UTC")).toString());
            Assertions.assertEquals("2019-03-22T06:15-03:00[America/Santiago]", zonedDateTime.toOffsetDateTime().atZoneSameInstant(ZoneId.of("America/Santiago")).toString());
            Assertions.assertEquals("2019-03-22T18:15+09:00[Asia/Tokyo]", zonedDateTime.toOffsetDateTime().atZoneSameInstant(ZoneId.of("Asia/Tokyo")).toString());
            Assertions.assertEquals("2019-03-22T11:15+02:00[Europe/Helsinki]", zonedDateTime.toOffsetDateTime().atZoneSameInstant(ZoneId.of("Europe/Helsinki")).toString());
        }

        @Test
        void convertFromInstantToOffsetDateTime() {

            // valid instant in UTC
            Instant instant = Instant.parse("2019-03-22T10:15:00Z");

            OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant, ZoneId.of("Europe/Berlin"));

            Assertions.assertEquals("2019-03-22T11:15+01:00", offsetDateTime.toString());
            Assertions.assertEquals("2019-03-22T07:15-03:00", offsetDateTime.atZoneSameInstant(ZoneId.of("America/Santiago")).toOffsetDateTime().toString());
            Assertions.assertEquals("2019-03-22T19:15+09:00", offsetDateTime.atZoneSameInstant(ZoneId.of("Asia/Tokyo")).toOffsetDateTime().toString());
            Assertions.assertEquals("2019-03-22T12:15+02:00", offsetDateTime.atZoneSameInstant(ZoneId.of("Europe/Helsinki")).toOffsetDateTime().toString());
        }

        @Test
        void parseToOffsetDateTime() {
            // date --iso-8601=ns
            // comma-separated fraction seconds are not allowed! Replaced with '.'
            String toParse = "2021-12-28T20:21:07.013064591+01:00";

            OffsetDateTime offsetDateTime = OffsetDateTime.parse(toParse);
            Assertions.assertEquals("2021-12-28T20:21:07.013064591+01:00", offsetDateTime.toString());
        }
    }

    @Nested
    class PeriodAndDurationTests {

        @Test
        void addPeriod() {

            Period threeDays = Period.ofDays(3);

            LocalDate localDate = LocalDate.of(2017, Month.AUGUST, 10);

            Assertions.assertEquals("2017-08-13", localDate.plus(threeDays).toString());
        }

        @Test
        void periodBetween() {

            LocalDate startInc = LocalDate.of(2017, Month.AUGUST, 10);
            LocalDate endExc = LocalDate.of(2021, Month.JULY, 3);

            Period between = Period.between(startInc, endExc);
            Assertions.assertEquals("P3Y10M23D", between.toString());

            Assertions.assertEquals(3, between.getYears());
            Assertions.assertEquals(10, between.getMonths());
            Assertions.assertEquals(23, between.getDays());
        }

        @Test
        void addDuration() {

            Duration duration = Duration.ofSeconds(45);

            LocalTime localTime = LocalTime.of(13, 31);

            Assertions.assertEquals(LocalTime.of(13, 31, 45), localTime.plus(duration));
        }

        @Test
        void durationBetween() {

            LocalTime startInc = LocalTime.of(13, 31, 3);
            LocalTime endExc = LocalTime.of(13, 31, 45);

            Assertions.assertEquals(42, Duration.between(startInc, endExc).getSeconds());
        }
    }

}
