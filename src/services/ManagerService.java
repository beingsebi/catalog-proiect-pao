package services;

import models.*;
import repositories.*;
import shared.Constants;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

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

    public int insertTeacher(Teacher teacher) {
        return teacherRepository.insertTeacher(teacher);
    }

    public int insertTeacher(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Constants.Gender gender, String phoneString, int yearsOfExperience, String department, String specialization) {
        return teacherRepository.insertTeacher(new Teacher(firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearsOfExperience, department, specialization));
    }

    public Teacher getTeacherById(int teacherId) {
        return teacherRepository.getTeacherById(teacherId);
    }

    public ArrayList<Teacher> getAllTeachers() {
        return teacherRepository.getAllTeachers();
    }

    public boolean teacherExists(int teacherId) {
        return teacherRepository.teacherExists(teacherId);
    }

    public void updateTeacher(int teacherId, Teacher teacher) {
        teacherRepository.updateTeacher(teacherId, teacher);
    }

    public void updateTeacherFirstName(int teacherId, String firstName) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        r.setFirstName(firstName);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherLastName(int teacherId, String lastName) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        r.setLastName(lastName);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherDateOfBirth(int teacherId, LocalDate dateOfBirth) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        r.setDateOfBirth(dateOfBirth);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherAddress(int teacherId, String address) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        r.setAddress(address);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherEmail(int teacherId, String email) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        r.setEmail(email);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherGender(int teacherId, Constants.Gender gender) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        r.setGender(gender);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherPhoneString(int teacherId, String phoneString) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        r.setPhoneString(phoneString);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherYearsOfExperience(int teacherId, int yearsOfExperience) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        r.setYearsOfExperience(yearsOfExperience);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherDepartment(int teacherId, String department) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        r.setDepartment(department);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherSpecialization(int teacherId, String specialization) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        r.setSpecialization(specialization);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public int insertCourse(Course course) {
        return courseRepository.insertCourse(course);
    }

    public int insertCourse(String courseName, String courseDescription) {
        return courseRepository.insertCourse(new Course(courseName, courseDescription));
    }

    public Course getCourseById(int courseId) {
        return CourseRepository.getCourseById(courseId);
    }

    public void removeCourse(int courseId) {
        courseRepository.removeCourse(courseId);
    }

    public void updateCourse(int courseId, Course course) {
        courseRepository.updateCourse(courseId, course);
    }

    public void updateCourseName(int courseId, String courseName) {
        Course r = CourseRepository.getCourseById(courseId);
        r.setCourseName(courseName);
        courseRepository.updateCourse(courseId, r);
    }

    public void updateCourseDescription(int courseId, String courseDescription) {
        Course r = CourseRepository.getCourseById(courseId);
        r.setCourseDescription(courseDescription);
        courseRepository.updateCourse(courseId, r);
    }

    public int createCourseInstanceRepo() {
        return CourseInstanceRepository.createCourseInstanceRepo();
    }

    public int insertCatalogue(Catalogue catalogue) {
        return catalogueRepository.insertCatalogue(catalogue);
    }

    public int insertStudent(Student student) {
        return studentRepository.insertStudent(student);
    }

    public int insertCatalogue(String catalogueName, String catalogueDescription, int classYear, String classSymbol, int classSupervisorId) {
        return catalogueRepository.insertCatalogue(new Catalogue(catalogueName, catalogueDescription, classYear, classSymbol, classSupervisorId));
    }

    public Catalogue getCatalogueById(int catalogueId) {
        return catalogueRepository.getCatalogueById(catalogueId);
    }

    public void removeCatalogue(int catalogueId) {
        catalogueRepository.removeCatalogue(catalogueId);
    }

    public int insertCourseInstance(int catalogueId, int courseId, Collection<Integer> teachersIds, LocalTime startTime, Constants.Days day, int duration) {
        Catalogue catalogue = catalogueRepository.getCatalogueById(catalogueId);
        if (catalogue == null) {
            return -2; // catalogue not found
        }
        Course course = CourseRepository.getCourseById(courseId);
        if (course == null) {
            return -3; // course not found
        }

        return catalogue.getCourseInstanceRepository().insertCourseInstance(new CourseInstance(catalogue.getCourseInstanceRepository().getCourseInstanceRepositoryId(), course, teachersIds, startTime, day, duration));
    }

    public int insertStudent(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Constants.Gender gender, String phoneString, int yearOfStudy) {
        return studentRepository.insertStudent(new Student(null, firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearOfStudy));
    }

    //
//    public Student getStudentById(int studentId) {
//        return studentRepository.getStudentById(studentId);
//    }


//    public int removeStudent(Student student) {
//        if (studentRepository.removeStudent(student) == -1) {
//            return -1;
//        }
//        return catalogueRepository.removeStudent(student);
//    }

//    public boolean teacherIsActive(Teacher teacher) {
//        return catalogueRepository.teacherExists(teacher);
//    }

//    public boolean studentExists(Student student) {
//        return studentRepository.studentExists(student);
//    }

    // TO DO
    public void removeTeacher(int teacherId) {
//        if (this.teacherIsActive(teacher)) {
//            throw new IllegalArgumentException("Teacher is active in a catalogue");
//        }
        teacherRepository.removeTeacher(teacherId);
//        catalogueRepository.removeTeacher(teacher);
    }

    public int assignTeacherAsSupervisorToCatalogue(int teacherId, int catalogueId) {
        Catalogue catalogue = catalogueRepository.getCatalogueById(catalogueId);
        if (catalogue == null) {
            return -1; // catalogue not found
        }
        catalogue.setClassSupervisorId(teacherId);
        return teacherId;
    }

//    public int assignStudentToCatalogue(Student student, int catalogueId) {
//        Catalogue catalogue = catalogueRepository.getCatalogueById(catalogueId);
//        if (catalogue == null) {
//            return -2; // catalogue not found
//        }
//        return catalogue.insertStudent(student); // returns studentId or -1 if student already exists
//    }

//    public int assignStudentToCatalogue(int studentId, int catalogueId) {
//        Student student = studentRepository.getStudentById(studentId);
//        if (student == null) {
//            return -3; // student not found
//        }
//        return this.assignStudentToCatalogue(student, catalogueId);
//    }

}
