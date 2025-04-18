package com.testcases.patientintake;

public enum Doctor {
    kavery("k jacob"),
    tanishk("Tanya Sharma"),
    kaustuv("Kau Mangaraj");

    private String name;

    Doctor(String name) {this.name = name ;}

    public String getName() {
        return name;
    }
}
