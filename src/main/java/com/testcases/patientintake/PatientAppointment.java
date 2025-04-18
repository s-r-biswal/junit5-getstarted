package com.testcases.patientintake;

import java.time.LocalDateTime;

public class PatientAppointment {
    private String patientFName;
    private String PatientLName;
    private LocalDateTime appointmentDate;
    private Doctor doctor;

    public PatientAppointment(String patientFName, String patientLName,
                              LocalDateTime appointmentDate, Doctor doc)
    {
        this.patientFName = patientFName;
        this.PatientLName = patientLName;
        this.appointmentDate = appointmentDate;
        this.doctor = doc;
    }

    public String getPatientFName() {
        return patientFName;
    }
    public String getPatientLName() {
        return PatientLName;
    }
    public LocalDateTime getAppointmentDateTime() {
        return appointmentDate;
    }
    public Doctor getDoctor(){
        return doctor;
    }
}
