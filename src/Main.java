import person.Person;
import student.Student;
import teacher.Teacher;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Person person = new Person("ana", "pop", LocalDate.now(), "adr", "em", "fem");
        System.out.println(person);
        

        Teacher teacher = new Teacher("ana", "pop", LocalDate.now(), "adr", "em", "fem", "1234", 5, "dep", "spec");


        System.out.println(teacher);
        // Rest of your code...
    }
}
