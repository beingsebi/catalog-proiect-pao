package models;

import shared.Constants.Gender;

import java.time.LocalDate;

public class Teacher extends Person {

    private int yearsOfExperience;
    private String department;
    private String specialization;

    public Teacher(int id, String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Gender gender, String phoneString, int yearsOfExperience, String department, String specialization) {
        super(id, firstName, lastName, dateOfBirth, address, email, gender, phoneString);
        this.yearsOfExperience = yearsOfExperience;
        this.department = department;
        this.specialization = specialization;
    }

    public Teacher(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Gender gender, String phoneString, int yearsOfExperience, String department, String specialization) {
        super(firstName, lastName, dateOfBirth, address, email, gender, phoneString);
        this.yearsOfExperience = yearsOfExperience;
        this.department = department;
        this.specialization = specialization;
    }

    @SuppressWarnings("unused")
    public int getTeacherId() {
        return this.getId();
    }

    @SuppressWarnings("unused")
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    @SuppressWarnings("unused")
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @SuppressWarnings("unused")
    public String getDepartment() {
        return department;
    }

    @SuppressWarnings("unused")
    public void setDepartment(String department) {
        this.department = department;
    }

    @SuppressWarnings("unused")
    public String getSpecialization() {
        return specialization;
    }

    @SuppressWarnings("unused")
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                ", yearsOfExperience=" + yearsOfExperience +
                ", department='" + department + '\'' +
                ", specialization='" + specialization + '\'' +
                "} " + super.toString();
    }
}
