import models.Course;
import models.Student;
import models.Teacher;
import services.ManagerService;
import shared.Constants;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ManagerService managerService = new ManagerService();
        int it1 = managerService.insertTeacher("John", "Doe", LocalDate.now(), "123 Street","john.doe@example", Constants.Gender.FEMALE,"123",3,"Computer Science","Java");
        Teacher t1 = managerService.getTeacherById(it1);

        int is1 = managerService.insertStudent("Jane", "Doe", LocalDate.now(), "123 Street", "jane.doe@example", Constants.Gender.MALE, "0987654321", 1);
        Student s1 = managerService.getStudentById(is1);

        int ic1 = managerService.insertCourse("Java Programming", "A course about Java programming");
        Course c1 = managerService.getCourseById(ic1);

        int ica1 = managerService.insertCatalogue("My Catalogue", "This is a catalogue for my school",2, "A");



    }
}
