package teacher;

import person.Person;

import java.time.LocalDate;

import shared.Constants.Gender;

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
}
