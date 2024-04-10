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
        System.out.println("Hello, World!");
        Person person = new Person("ana", "pop", LocalDate.now(), "adr", "em", Constants.Gender.MALE, "1234");
        System.out.println(person);


        Teacher teacher = new Teacher("ana", "pop", LocalDate.now(), "adr", "em", Constants.Gender.FEMALE, "1234", 5, "dep", "spec");

        Student student = new Student("ana", "pop", LocalDate.now(), "adr", "em", Constants.Gender.MALE, "1234", 1);
        System.out.println(teacher);
        System.out.println(student);
        // Rest of your code...
        Course course = new Course("Java", "Java course");
        System.out.println(course);
        System.out.println(course.getCourseId());

        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        Classroom classroom = new Classroom(12,"A",students,teacher);
        System.out.println(classroom);
    }
}
