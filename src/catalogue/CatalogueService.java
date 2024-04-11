package catalogue;


import classroom.Classroom;
import course.Course;
import course.CourseInstance;
import person.Person;
import shared.Constants;
import student.Student;
import teacher.Teacher;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public final class CatalogueService {

    private static Catalogue catalogue = null;

    private CatalogueService() {
    }

    @SuppressWarnings("unused")
    public static Catalogue getCatalogue() {
        return catalogue;
    }

    @SuppressWarnings("unused")
    public static void createCatalogue(String catalogueName, String catalogueDescription) {
        catalogue = new Catalogue(catalogueName, catalogueDescription);
    }

    @SuppressWarnings("unused")
    public static void insertTeacher(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Constants.Gender gender, String phoneString, int yearsOfExperience, String department, String specialization) {
        int id = catalogue.insertTeacher(new Teacher(firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearsOfExperience, department, specialization));
        System.out.println("Teacher with id " + id + " inserted.");
    }

    @SuppressWarnings("unused")
    public static void insertStudent(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Constants.Gender gender, String phoneString, int yearOfStudy) {
        int id = catalogue.insertStudent(new Student(firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearOfStudy));
        System.out.println("Student with id " + id + " inserted.");
    }

    @SuppressWarnings("unused")
    public static void insertCourse(String courseName, String courseDescription) {
        int id = catalogue.insertCourse(new Course(courseName, courseDescription));
        System.out.println("Course with id " + id + " inserted.");
    }

    @SuppressWarnings("unused")
    public static void createClassroom(int year, String symbol, Collection<Student> students, Person supervisor) {
        int id = catalogue.insertClassroom(new Classroom(year, symbol, students, supervisor));
        System.out.println("Classroom with id " + id + " inserted.");
    }

    @SuppressWarnings("unused")
    public static void createClassroom(int year, String symbol, Collection<Integer>studentIds, Integer supervisorId) {
        int id = catalogue.insertClassroom(new Classroom(year, symbol, studentIds.stream()
                .map(catalogue::getStudentById)
                .collect(Collectors.toList()), catalogue.getTeacherById(supervisorId)));
        System.out.println("Classroom with id " + id + " inserted.");
    }

    @SuppressWarnings("unused")
    public static void addStudentToClassroom(int classroomId, int studentId) {
        catalogue.getClassroomById(classroomId).addStudent(catalogue.getStudentById(studentId));
    }

    @SuppressWarnings("unused")
    public static void removeStudentFromClassroom(int classroomId, int studentId) {
        catalogue.getClassroomById(classroomId).removeStudent(catalogue.getStudentById(studentId));
    }

    @SuppressWarnings("unused")
    public static void addCourseInstanceToTimetable(Classroom classroom, Course course, Collection<Teacher> teachers, LocalTime startTime, int duration) {
        CourseInstance courseInstance = new CourseInstance(course, teachers, classroom, startTime, duration);
        catalogue.getTimetable().computeIfAbsent(classroom, k -> new ArrayList<>()).add(courseInstance);
    }

    @SuppressWarnings("unused")
    public static void addCourseInstanceToTimetable(int classroomId, int courseId, Collection<Integer> teacherIds, LocalTime startTime, int duration) {
        Classroom classroom = catalogue.getClassroomById(classroomId);
        Course course = catalogue.getCourseById(courseId);
        Collection<Teacher> teachers = teacherIds.stream()
                .map(catalogue::getTeacherById)
                .toList();
        addCourseInstanceToTimetable(classroom, course, teachers, startTime, duration);
    }
}
