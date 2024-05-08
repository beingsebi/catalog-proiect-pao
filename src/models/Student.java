package models;

import shared.Constants.Gender;

import java.time.LocalDate;

public class Student extends Person implements Comparable<Student> {
    private static int nextStudentId = 0;

    private final int studentId;
    private int yearOfStudy;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Gender gender, String phoneString, int yearOfStudy) {
        super(firstName, lastName, dateOfBirth, address, email, gender, phoneString);
        this.studentId = nextStudentId++;
        this.yearOfStudy = yearOfStudy;
    }

    @Override
    public int compareTo(Student o) {
        int aux = this.getLastName().toLowerCase().compareTo(o.getLastName().toLowerCase());
        if (aux != 0) {
            return aux;
        }
        return this.getFirstName().toLowerCase().compareTo(o.getFirstName().toLowerCase());
    }

    @SuppressWarnings("unused")
    public int getYearOfStudy() {
        return yearOfStudy;
    }

    @SuppressWarnings("unused")
    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    @SuppressWarnings("unused")
    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", yearOfStudy=" + yearOfStudy +
                "} " + super.toString() + "\n";
    }
}
