package com.testcases.patientintake;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ClinicCalendarTest {
    private static ClinicCalendar calendar ;
    private static LocalDate today = LocalDate.now();

    @BeforeAll
    public static void setUp(){
        calendar = new ClinicCalendar() ;
    }

    @Test
    public void checkAddAppointment() {

        calendar.addAppointment("jim", "Halpert", "kavery");
        List<PatientAppointment> appointments = calendar.getAppointments();
        assertNotNull(appointments);
        PatientAppointment obj = appointments.get(0);
        assertEquals(1, appointments.size());
        assertEquals("jim", obj.getPatientFName());
        assertEquals("Halpert", obj.getPatientLName());
        assertSame(Doctor.kavery, obj.getDoctor());
    }

    @Test
    public void checkAppointmentConfirmation(){
        calendar.addAppointment("jim", "Halpert", "kavery");
        assertTrue(calendar.hasAppointment(today));
        //assertIterableEquals
    }


}