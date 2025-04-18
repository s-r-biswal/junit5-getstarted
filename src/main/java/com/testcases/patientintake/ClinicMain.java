package com.testcases.patientintake;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;
import java.util.stream.Stream;

public class ClinicMain {

    private static ClinicCalendar calendar;

    public static void main(String args[]) throws Throwable {
        calendar = new ClinicCalendar();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the patient Intake computer system:7 \n\n");
        String lastoption = "";
        while(!lastoption.equalsIgnoreCase("x"))  {
            lastoption = displayMenu(scanner);
        }
        System.out.println("\n Exiting System ... \n");
    }


    private static String displayMenu(Scanner scanner) throws Throwable {
        System.out.println("Please select an option :");
        System.out.println("1. Enter a patient appointment");
        System.out.println("2. View All appointments");
        System.out.println("x. Exit System.");
        System.out.println("Option: ");

        String option = scanner.next();
        switch(option) {
            case "1": performPatientEntry(scanner);
                    return option;
            case "2": fetchAllAppointments(scanner);
                    return option;
            default: System.out.println("Invalid option, please re-enter");
                    return option;
        }
    }

    private static void performPatientEntry(Scanner scanner) {
        scanner.nextLine();
        System.out.println("\n\n Please Enter Appointment info: ");
        System.out.println("Patient first name : ");
        String pStartName = scanner.nextLine();
        System.out.println("Patient first name : ");
        String pLastName = scanner.nextLine();
        System.out.println("Appointment date (M/d/yyyy h:m a) :");
        String when = scanner.nextLine();
        System.out.println("Doctor lastname : ");
        String doc = scanner.next();

        try{
            calendar.addAppointment(pStartName, pLastName, when, doc);
        }catch (Exception e){
            System.out.println("Error !s");
            return ;
        }
    System.out.println("Successfully recorded Patient details");
    }

    private static void fetchAllAppointments(Scanner scanner) {
        System.out.println("\n\nAll appointments in system");
        for(PatientAppointment appointment: calendar.getAppointments()){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a");
            String appTime = formatter.format(appointment.getAppointmentDateTime());
            System.out.println(String.format("%s:  %s,  %s\t\tDoctor: %s", appTime, appointment.getPatientFName(),
                    appointment.getPatientLName(), appointment.getDoctor().getName()));
        }
    }
}