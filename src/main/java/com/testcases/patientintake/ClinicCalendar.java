package com.testcases.patientintake;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClinicCalendar {

    private List<PatientAppointment> appointments;

    public ClinicCalendar(){
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(String patientFirtName, String patientLastName
                                ,String doctorKey)

    {
       Doctor doc =  Doctor.valueOf(doctorKey.toLowerCase());
       LocalDateTime localDateTime = LocalDateTime.now();

       PatientAppointment appointment = new PatientAppointment(patientFirtName, patientLastName, localDateTime, doc);
       appointments.add(appointment);
    }

    public  List<PatientAppointment> getAppointments(){
        return this.appointments;
    }
}
