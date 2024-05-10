import models.Teacher;
import services.ManagerService;
import shared.Constants;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        ManagerService managerService = new ManagerService();
        int tch = managerService.insertTeacher("John23", "Doe", LocalDate.now(), "123 Street", "john.doe@example", Constants.Gender.FEMALE, "123", 3, "Computer Science", "Java");
managerService.removeTeacher(12);
//        int crs = managerService.insertCourse("Python Programming", "A course about Python programming");
//        int crsinst = managerService.insertCourseInstance(1, crs, new ArrayList<>(List.of(tch)), LocalTime.now(), Constants.Days.FRIDAY,2);
//        Teacher t=managerService.getTeacherById(tch);
//        System.out.println(t);
//        System.out.println(managerService.teacherIsActive(t));
//        int tch = managerService.insertTeacher("John23", "Doe", LocalDate.now(), "123 Street", "john.doe@example", Constants.Gender.FEMALE, "123", 3, "Computer Science", "Java");
//        int cat = managerService.insertCatalogue("My Catalogue2", "This is a catalogue for my school", 2, "A", tch);
//        int std = managerService.insertStudent(cat, "Jane", "Doe", LocalDate.now(), "123 Street", "jane.doe@example", Constants.Gender.MALE, "0987654321", 1);
//        System.out.println(managerService.getAllStudents());
        //        int cor = managerService.insertCourse("Java Programming", "A course about Java programming");
// int corinst=managerService.insertCourseInstance(1, Constants.Days.FRIDAY, cor, null, null, 2);


        //        int it1 = managerService.insertTeacher("John", "Doe", LocalDate.now(), "123 Street", "john.doe@example", Constants.Gender.FEMALE, "123", 3, "Computer Science", "Java");

//        managerService.updateCourseDescription(3, "A course about Python programming");
//        ArrayList<Teacher> t = managerService.getAllTeachers();
//        System.out.println(x);
//        System.out.println(managerService.getCatalogueById(x));
//        managerService.updateTeacher(2,new Teacher("John9999", "Doe", LocalDate.now(), "123 Street", "john.doe@example", Constants.Gender.FEMALE, "123", 3, "Computer Science", "Java"));
//        managerService.updateTeacherSpecialization(2, "000John9999");
//        managerService.insertCourse("Java Programming", "A course about Java programming");
//        int x = managerService.insertTeacher("John23", "Doe", LocalDate.now(), "123 Street", "john.doe@example", Constants.Gender.FEMALE, "123", 3, "Computer Science", "Java");
//        System.out.println(x);
        //        managerService.removeCoursesOfTeacher(1);
//        int is1 = managerService.insertStudent("Jane", "Doe", LocalDate.now(), "123 Street", "jane.doe@example", Constants.Gender.MALE, "0987654321", 1);
//        Student s1 = managerService.getStudentById(is1);
//
//        managerService.insertStudent(s1);
//        exit(0);
//        int it1 = managerService.insertTeacher("John", "Doe", LocalDate.now(), "123 Street", "john.doe@example", Constants.Gender.FEMALE, "123", 3, "Computer Science", "Java");
//        Teacher t1 = managerService.getTeacherById(it1);
//
//
//
//        int ic1 = managerService.insertCourse("Java Programming", "A course about Java programming");
//        Course c1 = managerService.getCourseById(ic1);
//
//        int ica1 = managerService.insertCatalogue("My Catalogue", "This is a catalogue for my school", 2, "A");
//
//        managerService.assignTeacherAsSupervisorToCatalogue(t1, ica1);
//
//        managerService.assignStudentToCatalogue(s1, ica1);
//
//        managerService.insertCourseInstance(ica1, Constants.Days.FRIDAY, ic1, null, LocalTime.now(), 2);
//
//        Catalogue cc = managerService.getCatalogueById(ica1);
//        int is2 = managerService.insertStudent("Jane", "Doe", LocalDate.now(), "123 Street", "jane.doe@example", Constants.Gender.MALE, "0987654321", 1);
//        managerService.assignStudentToCatalogue(is2, ica1);
//        System.out.println(cc);
    }
}
