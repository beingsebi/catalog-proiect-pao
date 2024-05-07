package services;

import models.Catalogue;
import models.Course;
import models.Student;
import models.Teacher;
import repositories.*;
import shared.Constants;

import java.time.LocalDate;

public class ManagerService {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final CatalogueRepository catalogueRepository;

    public ManagerService() {
        this.studentRepository = new StudentRepository();
        this.teacherRepository = new TeacherRepository();
        this.courseRepository = new CourseRepository();
        this.catalogueRepository = new CatalogueRepository();
    }

    public int insertStudent(Student student) {
        return studentRepository.insertStudent(student);
    }

    public int insertStudent(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Constants.Gender gender, String phoneString, int yearOfStudy) {
        return studentRepository.insertStudent(new Student(firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearOfStudy) );
    }

    public Student getStudentById(int studentId) {
        return studentRepository.getStudentById(studentId);
    }

    public int insertTeacher(Teacher teacher) {
        return teacherRepository.insertTeacher(teacher);
    }

    public int insertTeacher(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Constants.Gender gender, String phoneString, int yearsOfExperience, String department, String specialization) {
        return teacherRepository.insertTeacher(new Teacher(firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearsOfExperience, department, specialization));
    }

    public Teacher getTeacherById(int teacherId) {
        return teacherRepository.getTeacherById(teacherId);
    }

    public int insertCourse(Course course) {
        return courseRepository.insertCourse(course);
    }

    public int insertCourse(String courseName, String courseDescription) {
        return courseRepository.insertCourse(new Course(courseName, courseDescription));
    }

    public Course getCourseById(int courseId) {
        return courseRepository.getCourseById(courseId);
    }

    public int insertCatalogue(Catalogue catalogue) {
        return catalogueRepository.insertCatalogue(catalogue);
    }

    public int insertCatalogue(String catalogueName, String catalogueDescription, int classYear, String classSymbol) {
        return catalogueRepository.insertCatalogue(new Catalogue(catalogueName, catalogueDescription, classYear, classSymbol));
    }

    public Catalogue getCatalogueById(int catalogueId) {
        return catalogueRepository.getCatalogueById(catalogueId);
    }

    public int removeCatalogue(Catalogue catalogue) {
        return catalogueRepository.removeCatalogue(catalogue);
    }

    public int removeStudent(Student student) {
        if (studentRepository.removeStudent(student) == -1) {
            return -1;
        }
        return catalogueRepository.removeStudent(student);
    }

    public boolean teacherIsActive(Teacher teacher) {
        return catalogueRepository.checkIfTeacherExists(teacher);
    }

    public boolean studentExists(Student student) {
        return studentRepository.studentExists(student);
    }

    public void removeTeacher(Teacher teacher) {
        if (this.teacherIsActive(teacher)) {
            throw new IllegalArgumentException("Teacher is active in a catalogue");
        }
        teacherRepository.removeTeacher(teacher);
        catalogueRepository.removeTeacher(teacher);
    }

    public void assignTeacherAsSupervisorToCatalogue(Teacher teacher, int catalogueId) {
        Catalogue catalogue = catalogueRepository.getCatalogueById(catalogueId);
        catalogue.setClassSupervisor(teacher);
    }

    public int assignStudentToCatalogue(Student student, int catalogueId) {
        Catalogue catalogue = catalogueRepository.getCatalogueById(catalogueId);
        if (catalogue == null) {
            return -2; // catalogue not found
        }
        return catalogue.insertStudent(student); // returns studentId or -1 if student already exists
    }

    public int assignStudentToCatalogue(int studentId, int catalogueId) {
        Student student = studentRepository.getStudentById(studentId);
        if (student == null) {
            return -3; // student not found
        }
        return this.assignStudentToCatalogue(student, catalogueId);
    }
}
