package catalogue;


import shared.Constants;
import student.Student;
import teacher.Teacher;

import java.time.LocalDate;

public final class CatalogueService {

    private static Catalogue catalogue = null;

    private CatalogueService() {
    }

    @SuppressWarnings("unused")
    public static Catalogue getCatalogue() {
        return catalogue;
    }

    @SuppressWarnings("unused")
    public static void createCatalogue(String catalogueName, String catalogueDescription) {
        catalogue = new Catalogue(catalogueName, catalogueDescription);
    }

    @SuppressWarnings("unused")
    public static void insertTeacher(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Constants.Gender gender, String phoneString, int yearsOfExperience, String department, String specialization) {
        int id = catalogue.insertTeacher(new Teacher(firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearsOfExperience, department, specialization));
        System.out.println("Teacher with id " + id + " inserted.");
    }

    @SuppressWarnings("unused")
    public static void insertStudent(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Constants.Gender gender, String phoneString, int yearOfStudy) {
        int id = catalogue.insertStudent(new Student(firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearOfStudy));
        System.out.println("Student with id " + id + " inserted.");
    }
}
