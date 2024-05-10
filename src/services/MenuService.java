package services;

import shared.Constants;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuService {
    private static final ManagerService managerService = ManagerService.getInstance();
    public static void run() {
        while (true) {
            displayMenu();
        }
    }

    private static void displayMenu() {
        System.out.println("0. Exit");
        System.out.println("1. Insert course");
        System.out.println("2. Insert teacher");
        System.out.println("3. Insert catalogue");

        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(scanner.nextLine());
        if(option < 0 || option > 9) {
            System.out.println("Invalid option");
            return;
        }
        switch (option) {
            case 0:
                CSVService.WriteAction("exit");
                System.exit(0);
                break;
            case 1:
                System.out.println("Enter course name:");
                String courseName = scanner.nextLine();
                System.out.println("Enter course description:");
                String courseDescription = scanner.nextLine();
                managerService.insertCourse(courseName, courseDescription);
                System.out.println("Course added successfully");
            case 2:
                System.out.println("Enter teacher first name:");
                String firstName = scanner.nextLine();
                System.out.println("Enter teacher last name:");
                String lastName = scanner.nextLine();
                System.out.println("Enter teacher date of birth (example: 1992-03-20):");
                LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter teacher address:");
                String address = scanner.nextLine();
                System.out.println("Enter teacher email:");
                String email = scanner.nextLine();
                System.out.println("Enter teacher gender (\"FEMALE\" or \"MALE\"):");
                Constants.Gender gender = Constants.Gender.valueOf(scanner.nextLine());
                System.out.println("Enter teacher phone number:");
                String phoneString = scanner.nextLine();
                System.out.println("Enter teacher years of experience:");
                int yearsOfExperience = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter teacher department:");
                String department = scanner.nextLine();
                System.out.println("Enter teacher specialization:");
                String specialization = scanner.nextLine();
                managerService.insertTeacher(firstName, lastName, dateOfBirth, address,email,gender,phoneString,yearsOfExperience,department,specialization);
            case 3:
                System.out.println("Enter catalogue name:");
                String catalogueName = scanner.nextLine();
                System.out.println("Enter catalogue description:");
                String catalogueDescription = scanner.nextLine();
                System.out.println("Enter class year:");
                int classYear = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter class symbol:");
                String classSymbol = scanner.nextLine();
                System.out.println("Enter class supervisor id:");
                int classSupervisorId = Integer.parseInt(scanner.nextLine());
                managerService.insertCatalogue(catalogueName, catalogueDescription, classYear, classSymbol, classSupervisorId);
        }
    }
}
