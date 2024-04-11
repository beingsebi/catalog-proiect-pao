import catalogue.CatalogueService;
import classroom.Classroom;
import course.Course;
import person.Person;
import shared.Constants;
import student.Student;
import teacher.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {



        Teacher teacher = new Teacher("ana", "pop", LocalDate.now(), "adr", "em", Constants.Gender.FEMALE, "1234", 5, "dep", "spec");

        Student student = new Student("ana", "pop", LocalDate.now(), "adr", "em", Constants.Gender.MALE, "1234", 1);
        Student student2 = new Student("baba", "zz", LocalDate.now(), "adr", "em", Constants.Gender.MALE, "1234", 1);
//        System.out.println(teacher);
//        System.out.println(student);
        // Rest of your code...
        Course course = new Course("Java", "Java course");
//        System.out.println(course);
//        System.out.println(course.getCourseId());

        ArrayList<Student> students = new ArrayList<>();
        students.add(student2);
        students.add(student);

        Classroom classroom = new Classroom(12, "A", students, teacher);
//        System.out.println(classroom);

        student2.setLastName("aaaaaaaa");
//        System.out.println(student);
//        System.out.println(classroom);

        ArrayList<Classroom> classrooms = new ArrayList<>();
        classrooms.add(classroom);

        CatalogueService.createCatalogue("catalogue", "desc");
        CatalogueService.insertTeacher("John", "Doe", LocalDate.now(), "123 Street", "john.doe@example.com", Constants.Gender.MALE, "1234567890", 10, "Computer Science", "Java");

        // Insert a student
        CatalogueService.insertStudent("Jane", "Doe", LocalDate.now(), "123 Street", "jane.doe@example.com", Constants.Gender.FEMALE, "0987654321", 1);

        // Insert a course
        CatalogueService.insertCourse("Java Programming", "A course about Java programming");

        // Create a classroom
        CatalogueService.createClassroom(12, "A", students, teacher);

        System.out.println(CatalogueService.getCatalogue());

    }


}
