package person;


import java.util.Date;



public class Person {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private String email;
    private String gender;
    private String phoneString;

    public Person(String firstName, String lastName, Date dateOfBirth, String address, String email, String gender, String phoneString) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.phoneString = phoneString;
    }

    public Person(String firstName, String lastName, Date dateOfBirth, String address, String email, String gender){
        this(firstName, lastName, dateOfBirth, address,email,gender, null);
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

    @SuppressWarnings("unused")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @SuppressWarnings("unused")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @SuppressWarnings("unused")
    public void setDateOfBirth(Date dateOfBirth) {
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
    public String getGender() {
        return gender;
    }

    @SuppressWarnings("unused")
    public void setGender(String gender) {
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
}
