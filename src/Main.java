import services.ManagerService;
import shared.Constants;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ManagerService managerService = new ManagerService();
        int tch = managerService.insertTeacher("John23", "Doe", LocalDate.now(), "123 Street", "john.doe@example", Constants.Gender.FEMALE, "123", 3, "Computer Science", "Java");

        int cor = managerService.insertCourse("Java Programming", "A course about Java programming");
        int cat = managerService.insertCatalogue("My Catalogue2", "This is a catalogue for my school", 2, "A", 1);
        System.out.println(tch);
        System.out.println(cor);
        System.out.println(cat);
        var teachersIds = new ArrayList<Integer>();
        teachersIds.add(tch);
        managerService.insertCourseInstance(cat, cor,teachersIds , LocalTime.now(), Constants.Days.FRIDAY, 2);
        //        int cor = managerService.insertCourse("Java Programming", "A course about Java programming");
// int corinst=managerService.insertCourseInstance(1, Constants.Days.FRIDAY, cor, null, null, 2);


        //        int it1 = managerService.insertTeacher("John", "Doe", LocalDate.now(), "123 Street", "john.doe@example", Constants.Gender.FEMALE, "123", 3, "Computer Science", "Java");

//        managerService.updateCourseDescription(3, "A course about Python programming");
//        ArrayList<Teacher> t = managerService.getAllTeachers();
//        int x=managerService.insertCourse("Python Programming", "A course about Python programming");
//        System.out.println(x);
//        System.out.println(managerService.getCatalogueById(x));
//        managerService.updateTeacher(2,new Teacher("John9999", "Doe", LocalDate.now(), "123 Street", "john.doe@example", Constants.Gender.FEMALE, "123", 3, "Computer Science", "Java"));
//        managerService.updateTeacherSpecialization(2, "000John9999");
//        managerService.insertCourse("Java Programming", "A course about Java programming");
//        int x = managerService.insertTeacher("John23", "Doe", LocalDate.now(), "123 Street", "john.doe@example", Constants.Gender.FEMALE, "123", 3, "Computer Science", "Java");
//        System.out.println(x);
        //        managerService.removeTeacher(1);
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
