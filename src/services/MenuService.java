package services;

import models.Catalogue;
import models.Course;
import models.CourseInstance;
import models.Teacher;
import shared.Constants;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {
    private static final ManagerService managerService = ManagerService.getInstance();

    @SuppressWarnings("InfiniteLoopStatement")
    public static void run() {
        while (true) {
            try {
                displayMenu();
            } catch (Exception e) {
                System.out.println("An error occurred");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("0. Exit");
        System.out.println("1. Insert course");
        System.out.println("2. Insert teacher");
        System.out.println("3. Insert catalogue");
        System.out.println("4. Insert course instance");
        System.out.println("5. Insert student");
        System.out.println("6. Remove course");
        System.out.println("7. Remove teacher");
        System.out.println("8. Remove catalogue");
        System.out.println("9. Remove course instance");
        System.out.println("10. Remove student");
        System.out.println("11. Get all courses");
        System.out.println("12. Get all teachers");
        System.out.println("13. Get all catalogues");
        System.out.println("14. Get all course instances");
        System.out.println("15. Get all students");
        System.out.println("16. Get course by id");
        System.out.println("17. Get teacher by id");
        System.out.println("18. Get catalogue by id");
        System.out.println("19. Get course instance by id");
        System.out.println("20. Get student by id");
        System.out.println("21. Update course");
        System.out.println("22. Update teacher");
        System.out.println("23. Update catalogue");
        System.out.println("24. Update course instance");
        System.out.println("25. Update student");

        Scanner scanner = new Scanner(System.in);
        int option;
        try {
            option = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid option");
            return;
        }
        if (option < 0 || option > 25) {
            System.out.println("Invalid option");
            return;
        }
        switch (option) {
            case 0: {
                CSVService.WriteAction("exit");
                System.exit(0);
                break;
            }
            case 1: {
                System.out.println("Enter course name:");
                String courseName = scanner.nextLine();
                System.out.println("Enter course description:");
                String courseDescription = scanner.nextLine();
                managerService.insertCourse(courseName, courseDescription);
                System.out.println("Course added successfully");
                break;
            }
            case 2: {
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
                managerService.insertTeacher(firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearsOfExperience, department, specialization);
                break;
            }
            case 3: {
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
                break;
            }
            case 4: {
                System.out.println("Enter catalogue id:");
                int catalogueId = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter course id:");
                int courseId = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter teacher ids (separated by comma):");
                ArrayList<Integer> teacherIds = new ArrayList<>();
                String[] teacherIdsString = scanner.nextLine().split(",");
                for (String teacherId : teacherIdsString) {
                    teacherIds.add(Integer.parseInt(teacherId));
                }
                System.out.println("Enter start time (example: 12:00):");
                String startTimeString = scanner.nextLine();
                LocalTime startTime = LocalTime.parse(startTimeString);
                System.out.println("Enter day (\"MONDAY\", \"TUESDAY\", \"WEDNESDAY\", \"THURSDAY\", \"FRIDAY\", \"SATURDAY\", \"SUNDAY\"):");
                Constants.Days day = Constants.Days.valueOf(scanner.nextLine());
                System.out.println("Enter duration:");
                int duration = Integer.parseInt(scanner.nextLine());
                managerService.insertCourseInstance(catalogueId, courseId, teacherIds, startTime, day, duration);
                break;
            }
            case 5: {
                System.out.println("Enter catalogue id:");
                int catalogueIdStudent = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter student first name:");
                String firstNameStudent = scanner.nextLine();
                System.out.println("Enter student last name:");
                String lastNameStudent = scanner.nextLine();
                System.out.println("Enter student date of birth (example: 1992-03-20):");
                LocalDate dateOfBirthStudent = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter student address:");
                String addressStudent = scanner.nextLine();
                System.out.println("Enter student email:");
                String emailStudent = scanner.nextLine();
                System.out.println("Enter teacher gender (\"FEMALE\" or \"MALE\"):");
                Constants.Gender gender = Constants.Gender.valueOf(scanner.nextLine());
                System.out.println("Enter student phone number:");
                String phoneStringStudent = scanner.nextLine();
                System.out.println("Enter student year of study:");
                int yearOfStudy = Integer.parseInt(scanner.nextLine());
                managerService.insertStudent(catalogueIdStudent, firstNameStudent, lastNameStudent, dateOfBirthStudent, addressStudent, emailStudent, gender, phoneStringStudent, yearOfStudy);
                break;
            }
            case 6: {
                System.out.println("Enter course id:");
                int courseId = Integer.parseInt(scanner.nextLine());
                managerService.removeCourse(courseId);
                break;
            }
            case 7: {
                System.out.println("Enter teacher id:");
                int teacherId = Integer.parseInt(scanner.nextLine());
                managerService.removeTeacher(teacherId);
                break;
            }
            case 8: {
                System.out.println("Enter catalogue id:");
                int catalogueId = Integer.parseInt(scanner.nextLine());
                managerService.removeCatalogue(catalogueId);
                break;
            }
            case 9: {
                System.out.println("Enter course instance id:");
                int courseInstanceId = Integer.parseInt(scanner.nextLine());
                managerService.removeCourseInstance(courseInstanceId);
                break;
            }
            case 10: {
                System.out.println("Enter student id:");
                int studentId = Integer.parseInt(scanner.nextLine());
                managerService.removeStudent(studentId);
                break;
            }
            case 11: {
                for (Course i : managerService.getAllCourses()){
                    System.out.println(i);
                }
                break;
            }
            case 12: {
                for (Teacher i : managerService.getAllTeachers()){
                    System.out.println(i);
                }
                break;
            }
            case 13: {
                for (Catalogue i : managerService.getAllCatalogues()){
                    System.out.println(i);
                }
                break;
            }
            case 14: {
                for (CourseInstance i : managerService.getAllCourseInstances()){
                    System.out.println(i);
                }
                break;
            }
            case 15: {
                for (models.Student i : managerService.getAllStudents()){
                    System.out.println(i);
                }
                break;
            }
            case 16: {
                System.out.println("Enter course id:");
                int courseId = Integer.parseInt(scanner.nextLine());
                System.out.println(managerService.getCourseById(courseId));
                break;
            }
            case 17: {
                System.out.println("Enter teacher id:");
                int teacherId = Integer.parseInt(scanner.nextLine());
                System.out.println(managerService.getTeacherById(teacherId));
                break;
            }
            case 18: {
                System.out.println("Enter catalogue id:");
                int catalogueId = Integer.parseInt(scanner.nextLine());
                System.out.println(managerService.getCatalogueById(catalogueId));
                break;
            }
            case 19: {
                System.out.println("Enter course instance id:");
                int courseInstanceId = Integer.parseInt(scanner.nextLine());
                System.out.println(managerService.getCourseInstanceById(courseInstanceId));
                break;
            }
            case 20: {
                System.out.println("Enter student id:");
                int studentId = Integer.parseInt(scanner.nextLine());
                System.out.println(managerService.getStudentById(studentId));
                break;
            }
        }
    }
}
