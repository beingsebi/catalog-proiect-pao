package student;

import person.Person;
import shared.Constants.Gender;

import java.time.LocalDate;

public class Student extends Person {
    private static int nextStudentId = 0;

    private final int studentId;
    private int yearOfStudy ;
    private Person supervisor;


    public Student(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Gender gender, String phoneString, int yearOfStudy, Person supervisor) {
        super(firstName, lastName, dateOfBirth, address, email, gender, phoneString);
        this.studentId = nextStudentId++;
        this.yearOfStudy = yearOfStudy;
        this.supervisor = supervisor;
    }
    
    @SuppressWarnings("unused")
    public Student(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Gender gender, String phoneString, int yearOfStudy) {
        this(firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearOfStudy, null);
    }


    @SuppressWarnings("unused")
    public Person getSupervisor() {
        return supervisor;
    }

    @SuppressWarnings("unused")
    public void setSupervisor(Person supervisor) {
        this.supervisor = supervisor;
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
                ", supervisor=" + supervisor +
                "} " + super.toString();
    }
}
