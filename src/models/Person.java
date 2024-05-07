package models;

import java.time.LocalDate;

import shared.Constants.Gender;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String email;
    private Gender gender;
    private String phoneString;

    @SuppressWarnings("unused")
    public Person(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Gender gender, String phoneString) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.phoneString = phoneString;
    }


    @SuppressWarnings("unused")
    public String getFirstName() {
        return firstName;
    }

    @SuppressWarnings("unused")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @SuppressWarnings("unused")
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of this Person.
     * If you call this for a student, you might want to call ClassRoom.reorderStudents() after
     * calling this method for all the classrooms in which this person is a student.
     *
     * @param lastName the new last name of this Person
     */
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