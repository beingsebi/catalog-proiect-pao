import catalogue.CatalogueService;
import shared.Constants;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        CatalogueService.createCatalogue("My Catalogue", "This is a catalogue for my school.");

        CatalogueService.insertTeacher("John", "Doe", LocalDate.now(), "123 Street", "john.doe@example.com", Constants.Gender.MALE, "1234567890", 10, "Computer Science", "Java");

        CatalogueService.insertStudent("Jane", "Doe", LocalDate.now(), "123 Street", "jane.doe@example.com", Constants.Gender.FEMALE, "0987654321", 1);

        CatalogueService.insertCourse("Java Programming", "A course about Java programming");

        CatalogueService.createClassroom(2024, "A", Collections.singletonList(0), 0);

        CatalogueService.addStudentToClassroom(0, 0);

        CatalogueService.addCourseInstanceToTimetable(0, 0, Collections.singletonList(1), LocalTime.of(9, 0), 2);

        System.out.println(CatalogueService.getCatalogue());
    }
}
