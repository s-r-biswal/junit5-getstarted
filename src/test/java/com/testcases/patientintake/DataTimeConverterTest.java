package com.testcases.patientintake;

import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DataTimeConverterTest {

    @org.junit.jupiter.api.Nested
    @DisplayName("Testing given date and time validity")
    class TestDateAndTime {

        @Test
        @DisplayName("With proper data")
        public void convertTodayStriongCorrectly() {
            LocalDateTime result = DataTimeConverterForProject.convertStringToDateTime(
                    "today 1:00 pm", LocalDate.of(2018, 9, 1));
            assertEquals(result, LocalDateTime.of(2018, 9, 1, 13, 0));
        }

        @Test
        @DisplayName("Regardless of")
        public void checkExceptionThrownForIncorrectTime() {
            Throwable e = assertThrows(RuntimeException.class, () ->
                    DataTimeConverterForProject.convertStringToDateTime(
                            "today 100 pm", LocalDate.of(2018, 9, 1)
                    )
            );
            assertEquals("text", e.getMessage());
        }
    }


}