package com.testcases.patientintake;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataTimeConverterForProject {

    public static LocalDateTime convertStringToDateTime(String dateTimeString, LocalDate today) {
        LocalDateTime localDateTime = null;
        try{
            if(dateTimeString.toLowerCase().startsWith("today")) {
                String[] parts = dateTimeString.split(" ",2);
                LocalTime time = LocalTime.parse(parts[1].toUpperCase(),
                        DateTimeFormatter.ofPattern("h:mm a", Locale.US));
                localDateTime = LocalDateTime.of(today, time);
            }
        } catch(Throwable e) {
            throw new RuntimeException("text");
        }
        return localDateTime;
    }
}
