package com.testcases.patientintake;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClinicCalendar {

    private List<PatientAppointment> appointments;

    public ClinicCalendar(){
        this.appointments = new ArrayList<>();
    }

    LocalDate today = LocalDate.now();

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

    public  List<PatientAppointment> getTodayAppointments(){
        return appointments.stream().filter(app -> app.getAppointmentDateTime().toLocalDate().equals(today))
                .collect(Collectors.toUnmodifiableList());
    }

    public  boolean hasAppointment(LocalDate date){
        return  appointments.stream().anyMatch( app ->
                app.getAppointmentDateTime().toLocalDate().equals(today));
    }
}
