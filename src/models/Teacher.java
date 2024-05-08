package models;

import shared.Constants.Gender;

import java.time.LocalDate;

public class Teacher extends Person {
    private static int nextTeacherId = 0;

    private final int teacherId;
    private int yearsOfExperience = 0;
    private String department = null;
    private String specialization = null;

    @SuppressWarnings("unused")
    public Teacher(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Gender gender, String phoneString) {
        super(firstName, lastName, dateOfBirth, address, email, gender, phoneString);
        this.teacherId = nextTeacherId++;
    }

    @SuppressWarnings("unused")
    public Teacher(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Gender gender, String phoneString, int yearsOfExperience) {
        this(firstName, lastName, dateOfBirth, address, email, gender, phoneString);
        this.yearsOfExperience = yearsOfExperience;
    }

    @SuppressWarnings("unused")
    public Teacher(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Gender gender, String phoneString, int yearsOfExperience, String department) {
        this(firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearsOfExperience);
        this.department = department;
    }

    @SuppressWarnings("unused")
    public Teacher(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Gender gender, String phoneString, int yearsOfExperience, String department, String specialization) {
        this(firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearsOfExperience, department);
        this.specialization = specialization;
    }

    @SuppressWarnings("unused")
    public int getTeacherId() {
        return teacherId;
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
                "teacherId=" + teacherId +
                ", yearsOfExperience=" + yearsOfExperience +
                ", department='" + department + '\'' +
                ", specialization='" + specialization + '\'' +
                "} " + super.toString();
    }
}
