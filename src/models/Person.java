package models;

import shared.Constants.Gender;

import java.time.LocalDate;

public class Person {

    private Integer personId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String email;
    private Gender gender;
    private String phoneString;

    public Person(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Gender gender, String phoneString) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.phoneString = phoneString;
    }

    public Person(int personId, String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Gender gender, String phoneString) {
        this(firstName, lastName, dateOfBirth, address, email, gender, phoneString);
        this.personId = personId;
    }

    public Integer getId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @SuppressWarnings("unused")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @SuppressWarnings("unused")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @SuppressWarnings("unused")
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @SuppressWarnings("unused")
    public String getAddress() {
        return address;
    }

    @SuppressWarnings("unused")
    public void setAddress(String address) {
        this.address = address;
    }

    @SuppressWarnings("unused")
    public String getEmail() {
        return email;
    }

    @SuppressWarnings("unused")
    public void setEmail(String email) {
        this.email = email;
    }

    @SuppressWarnings("unused")
    public Gender getGender() {
        return gender;
    }

    @SuppressWarnings("unused")
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @SuppressWarnings("unused")
    public String getPhoneString() {
        return phoneString;
    }

    @SuppressWarnings("unused")
    public void setPhoneString(String phoneString) {
        this.phoneString = phoneString;
    }

    @Override
    public String toString() {
        return "Person{" +
                (personId != null ? "personId=" + personId + ", " : "") +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", phoneString='" + phoneString + '\'' +
                '}';
    }
}
