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
                for (Course i : managerService.getAllCourses()) {
                    System.out.println(i);
                }
                break;
            }
            case 12: {
                for (Teacher i : managerService.getAllTeachers()) {
                    System.out.println(i);
                }
                break;
            }
            case 13: {
                for (Catalogue i : managerService.getAllCatalogues()) {
                    System.out.println(i);
                }
                break;
            }
            case 14: {
                for (CourseInstance i : managerService.getAllCourseInstances()) {
                    System.out.println(i);
                }
                break;
            }
            case 15: {
                for (models.Student i : managerService.getAllStudents()) {
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
            case 21: {
                System.out.println("Enter course id:");
                int courseId = Integer.parseInt(scanner.nextLine());
                Course course = managerService.getCourseById(courseId);
                if (course == null) {
                    System.out.println("Course not found");
                    break;
                }
                System.out.println("1. Update name");
                System.out.println("2. Update description");
                int updateOption = Integer.parseInt(scanner.nextLine());
                if (updateOption == 1) {
                    System.out.println("Enter new name:");
                    String newName = scanner.nextLine();
                    course.setCourseName(newName);
                } else if (updateOption == 2) {
                    System.out.println("Enter new description:");
                    String newDescription = scanner.nextLine();
                    course.setCourseDescription(newDescription);
                } else {
                    System.out.println("Invalid option");
                    break;
                }
                managerService.updateCourse(courseId, course);
                break;
            }
            case 22: {
                System.out.println("Enter teacher id:");
                int teacherId = Integer.parseInt(scanner.nextLine());
                Teacher teacher = managerService.getTeacherById(teacherId);
                if (teacher == null) {
                    System.out.println("Teacher not found");
                    break;
                }
                System.out.println("1. Update first name");
                System.out.println("2. Update last name");
                System.out.println("3. Update date of birth (example: 1992-03-20)");
                System.out.println("4. Update address");
                System.out.println("5. Update email");
                System.out.println("6. Update gender \"FEMALE\" or \"MALE\")");
                System.out.println("7. Update phone number");
                System.out.println("8. Update years of experience");
                System.out.println("9. Update department");
                System.out.println("10. Update specialization");
                int updateOption = Integer.parseInt(scanner.nextLine());
                switch (updateOption) {
                    case 1: {
                        System.out.println("Enter new first name:");
                        String newFirstName = scanner.nextLine();
                        teacher.setFirstName(newFirstName);
                        break;
                    }
                    case 2: {
                        System.out.println("Enter new last name:");
                        String newLastName = scanner.nextLine();
                        teacher.setLastName(newLastName);
                        break;
                    }
                    case 3: {
                        System.out.println("Enter new date of birth (example: 1992-03-20):");
                        LocalDate newDateOfBirth = LocalDate.parse(scanner.nextLine());
                        teacher.setDateOfBirth(newDateOfBirth);
                        break;
                    }
                    case 4: {
                        System.out.println("Enter new address:");
                        String newAddress = scanner.nextLine();
                        teacher.setAddress(newAddress);
                        break;
                    }
                    case 5: {
                        System.out.println("Enter new email:");
                        String newEmail = scanner.nextLine();
                        teacher.setEmail(newEmail);
                        break;
                    }
                    case 6: {
                        System.out.println("Enter new gender:");
                        Constants.Gender gender = Constants.Gender.valueOf(scanner.nextLine());
                        teacher.setGender(gender);
                        break;
                    }
                    case 7: {
                        System.out.println("Enter new phone number:");
                        String newPhone = scanner.nextLine();
                        teacher.setPhoneString(newPhone);
                        break;
                    }
                    case 8: {
                        System.out.println("Enter new years of experience:");
                        int newYearsOfExperience = Integer.parseInt(scanner.nextLine());
                        teacher.setYearsOfExperience(newYearsOfExperience);
                        break;
                    }
                    case 9: {
                        System.out.println("Enter new department:");
                        String newDepartment = scanner.nextLine();
                        teacher.setDepartment(newDepartment);
                        break;
                    }
                    case 10: {
                        System.out.println("Enter new specialization:");
                        String newSpecialization = scanner.nextLine();
                        teacher.setSpecialization(newSpecialization);
                        break;
                    }
                    default: {
                        System.out.println("Invalid option");
                        return;
                    }
                }
                managerService.updateTeacher(teacherId, teacher);
                break;
            }
            case 23: {
                System.out.println("Enter catalogue id:");
                int catalogueId = Integer.parseInt(scanner.nextLine());
                Catalogue catalogue = managerService.getCatalogueById(catalogueId);
                if (catalogue == null) {
                    System.out.println("Catalogue not found");
                    break;
                }
                System.out.println("1. Update name");
                System.out.println("2. Update description");
                System.out.println("3. Update class year");
                System.out.println("4. Update class symbol");
                System.out.println("5. Update class supervisor id");
                int updateOption = Integer.parseInt(scanner.nextLine());
                switch (updateOption) {
                    case 1: {
                        System.out.println("Enter new name:");
                        String newName = scanner.nextLine();
                        catalogue.setCatalogueName(newName);
                        break;
                    }
                    case 2: {
                        System.out.println("Enter new description:");
                        String newDescription = scanner.nextLine();
                        catalogue.setCatalogueDescription(newDescription);
                        break;
                    }
                    case 3: {
                        System.out.println("Enter new class year:");
                        int newClassYear = Integer.parseInt(scanner.nextLine());
                        catalogue.setClassYear(newClassYear);
                        break;
                    }
                    case 4: {
                        System.out.println("Enter new class symbol:");
                        String newClassSymbol = scanner.nextLine();
                        catalogue.setClassSymbol(newClassSymbol);
                        break;
                    }
                    case 5: {
                        System.out.println("Enter new class supervisor id:");
                        int newClassSupervisorId = Integer.parseInt(scanner.nextLine());
                        catalogue.setClassSupervisorId(newClassSupervisorId);
                        break;
                    }
                    default: {
                        System.out.println("Invalid option");
                        return;
                    }
                }
                managerService.updateCatalogue(catalogueId, catalogue);
                break;
            }
            case 24: {
                System.out.println("Enter course instance id:");
                int courseInstanceId = Integer.parseInt(scanner.nextLine());
                CourseInstance courseInstance = managerService.getCourseInstanceById(courseInstanceId);
                if (courseInstance == null) {
                    System.out.println("Course instance not found");
                    break;
                }
                System.out.println("1. Update course id");
                System.out.println("2. Update teacher ids");
                System.out.println("3. Update start time");
                System.out.println("4. Update day");
                System.out.println("5. Update duration");
                int updateOption = Integer.parseInt(scanner.nextLine());
                switch (updateOption) {
                    case 1: {
                        System.out.println("Enter new course id:");
                        int newCourseId = Integer.parseInt(scanner.nextLine());
                        Course c = managerService.getCourseById(newCourseId);
                        if (c == null) {
                            System.out.println("Course not found");
                            break;
                        }
                        courseInstance.setCourse(c);
                        break;
                    }
                    case 2: {
                        System.out.println("Enter new teacher ids (separated by comma):");
                        ArrayList<Integer> newTeacherIds = new ArrayList<>();
                        String[] teacherIdsString = scanner.nextLine().split(",");
                        for (String teacherId : teacherIdsString) {
                            newTeacherIds.add(Integer.parseInt(teacherId));
                        }
                        courseInstance.setTeachers(newTeacherIds);
                        break;
                    }
                    case 3: {
                        System.out.println("Enter new start time (example: 12:00):");
                        String newStartTimeString = scanner.nextLine();
                        LocalTime newStartTime = LocalTime.parse(newStartTimeString);
                        courseInstance.setStartTime(newStartTime);
                        break;
                    }
                    case 4: {
                        System.out.println("Enter new day:");
                        Constants.Days newDay = Constants.Days.valueOf(scanner.nextLine());
                        courseInstance.setDay(newDay);
                        break;
                    }
                    case 5: {
                        System.out.println("Enter new duration:");
                        int newDuration = Integer.parseInt(scanner.nextLine());
                        courseInstance.setDuration(newDuration);
                        break;
                    }
                    default: {
                        System.out.println("Invalid option");
                        return;
                    }
                }
                managerService.updateCourseInstance(courseInstanceId, courseInstance);
                break;
            }
            case 25: {
                System.out.println("Enter student id:");
                int studentId = Integer.parseInt(scanner.nextLine());
                models.Student student = managerService.getStudentById(studentId);
                if (student == null) {
                    System.out.println("Student not found");
                    break;
                }
                System.out.println("1. Update first name");
                System.out.println("2. Update last name");
                System.out.println("3. Update date of birth (example: 1992-03-20)");
                System.out.println("4. Update address");
                System.out.println("5. Update email");
                System.out.println("6. Update gender (\"FEMALE\" or \"MALE\")");
                System.out.println("7. Update phone number");
                System.out.println("8. Update year of study");
                int updateOption = Integer.parseInt(scanner.nextLine());
                switch (updateOption) {
                    case 1: {
                        System.out.println("Enter new first name:");
                        String newFirstName = scanner.nextLine();
                        student.setFirstName(newFirstName);
                        break;
                    }
                    case 2: {
                        System.out.println("Enter new last name:");
                        String newLastName = scanner.nextLine();
                        student.setLastName(newLastName);
                        break;
                    }
                    case 3: {
                        System.out.println("Enter new date of birth (example: 1992-03-20):");
                        LocalDate newDateOfBirth = LocalDate.parse(scanner.nextLine());
                        student.setDateOfBirth(newDateOfBirth);
                        break;
                    }
                    case 4: {
                        System.out.println("Enter new address:");
                        String newAddress = scanner.nextLine();
                        student.setAddress(newAddress);
                        break;
                    }
                    case 5: {
                        System.out.println("Enter new email:");
                        String newEmail = scanner.nextLine();
                        student.setEmail(newEmail);
                        break;
                    }
                    case 6: {
                        System.out.println("Enter new gender:");
                        Constants.Gender gender = Constants.Gender.valueOf(scanner.nextLine());
                        student.setGender(gender);
                        break;
                    }
                    case 7: {
                        System.out.println("Enter new phone number:");
                        String newPhone = scanner.nextLine();
                        student.setPhoneString(newPhone);
                        break;
                    }
                    case 8: {
                        System.out.println("Enter new year of study:");
                        int newYearOfStudy = Integer.parseInt(scanner.nextLine());
                        student.setYearOfStudy(newYearOfStudy);
                        break;
                    }
                    default: {
                        System.out.println("Invalid option");
                        return;
                    }
                }
                managerService.updateStudent(studentId, student);
                break;
            }
            default: {
                System.out.println("Invalid option");
                break;
            }
        }
    }
}

