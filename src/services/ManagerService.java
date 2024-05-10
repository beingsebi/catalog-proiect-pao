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
    static private ManagerService ms;

    private ManagerService() {
        this.studentRepository = new StudentRepository();
        this.teacherRepository = new TeacherRepository();
        this.courseRepository = new CourseRepository();
        this.catalogueRepository = new CatalogueRepository();
    }

    public static ManagerService getInstance() {
        if (ms == null) {
            ms = new ManagerService();
        }
        return ms;
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
        if (r == null) {
            return;
        }
        r.setFirstName(firstName);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherLastName(int teacherId, String lastName) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        if (r == null) {
            return;
        }
        r.setLastName(lastName);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherDateOfBirth(int teacherId, LocalDate dateOfBirth) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        if (r == null) {
            return;
        }
        r.setDateOfBirth(dateOfBirth);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherAddress(int teacherId, String address) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        if (r == null) {
            return;
        }
        r.setAddress(address);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherEmail(int teacherId, String email) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        if (r == null) {
            return;
        }
        r.setEmail(email);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherGender(int teacherId, Constants.Gender gender) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        if (r == null) {
            return;
        }
        r.setGender(gender);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherPhoneString(int teacherId, String phoneString) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        if (r == null) {
            return;
        }
        r.setPhoneString(phoneString);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherYearsOfExperience(int teacherId, int yearsOfExperience) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        if (r == null) {
            return;
        }
        r.setYearsOfExperience(yearsOfExperience);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherDepartment(int teacherId, String department) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        if (r == null) {
            return;
        }
        r.setDepartment(department);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public void updateTeacherSpecialization(int teacherId, String specialization) {
        Teacher r = teacherRepository.getTeacherById(teacherId);
        if (r == null) {
            return;
        }
        r.setSpecialization(specialization);
        teacherRepository.updateTeacher(teacherId, r);
    }

    public boolean teacherIsActive(int teacherId) {
        Teacher teacher = teacherRepository.getTeacherById(teacherId);
        if (teacher == null) {
            return false;
        }
        return teacherRepository.teacherIsActive(teacher);
    }

    public int removeTeacher(int teacherId) {
        if (this.teacherIsActive(teacherId)) {
            return -1; // teacher is active, cannot be removed
        }
        teacherRepository.removeTeacher(teacherId);
        return teacherId;
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
        if (r == null) {
            return;
        }
        r.setCourseName(courseName);
        courseRepository.updateCourse(courseId, r);
    }

    public void updateCourseDescription(int courseId, String courseDescription) {
        Course r = CourseRepository.getCourseById(courseId);
        if (r == null) {
            return;
        }
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

    public void updateCatalogue(int catalogueId, Catalogue catalogue) {
        catalogueRepository.updateCatalogue(catalogueId, catalogue);
    }

    public void updateCatalogueName(int catalogueId, String catalogueName) {
        Catalogue r = catalogueRepository.getCatalogueById(catalogueId);
        if (r == null) {
            return;
        }
        r.setCatalogueName(catalogueName);
        catalogueRepository.updateCatalogue(catalogueId, r);
    }

    public void updateCatalogueDescription(int catalogueId, String catalogueDescription) {
        Catalogue r = catalogueRepository.getCatalogueById(catalogueId);
        if (r == null) {
            return;
        }
        r.setCatalogueDescription(catalogueDescription);
        catalogueRepository.updateCatalogue(catalogueId, r);
    }

    public void updateClassYear(int catalogueId, int classYear) {
        Catalogue r = catalogueRepository.getCatalogueById(catalogueId);
        if (r == null) {
            return;
        }
        r.setClassYear(classYear);
        catalogueRepository.updateCatalogue(catalogueId, r);
    }

    public void updateClassSymbol(int catalogueId, String classSymbol) {
        Catalogue r = catalogueRepository.getCatalogueById(catalogueId);
        if (r == null) {
            return;
        }
        r.setClassSymbol(classSymbol);
        catalogueRepository.updateCatalogue(catalogueId, r);
    }

    public void updateClassSupervisorId(int catalogueId, int classSupervisorId) {
        if (!teacherRepository.teacherExists(classSupervisorId)) {
            return;
        }
        Catalogue r = catalogueRepository.getCatalogueById(catalogueId);
        if (r == null) {
            return;
        }
        r.setClassSupervisorId(classSupervisorId);
        catalogueRepository.updateCatalogue(catalogueId, r);
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

    public int insertStudent(int catalogueId, String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Constants.Gender gender, String phoneString, int yearOfStudy) {
        return studentRepository.insertStudent(new Student(catalogueId, firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearOfStudy));
    }

    public Student getStudentById(int studentId) {
        return studentRepository.getStudentById(studentId);
    }

    public boolean removeStudent(int studentId) {
        Student student = studentRepository.getStudentById(studentId);
        if (student == null) {
            return false;
        }
        return studentRepository.removeStudent(student);
    }

    public boolean removeStudent(Student student) {
        return studentRepository.removeStudent(student);
    }

    public boolean studentExists(Student student) {
        return studentRepository.studentExists(student);
    }

    public boolean studentExists(int studentId) {
        return studentRepository.studentExists(studentId);
    }

    public ArrayList<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void updateStudent(int studentId, Student student) {
        studentRepository.updateStudent(studentId, student);
    }

    public void updateStudentCatalogueId(int studentId, int catalogueId) {
        Student r = studentRepository.getStudentById(studentId);
        if (r == null) {
            return;
        }
        r.setCatalogueId(catalogueId);
        studentRepository.updateStudent(studentId, r);
    }

    public void updateStudentFirstName(int studentId, String firstName) {
        Student r = studentRepository.getStudentById(studentId);
        if (r == null) {
            return;
        }
        r.setFirstName(firstName);
        studentRepository.updateStudent(studentId, r);
    }

    public void updateStudentLastName(int studentId, String lastName) {
        Student r = studentRepository.getStudentById(studentId);
        if (r == null) {
            return;
        }
        r.setLastName(lastName);
        studentRepository.updateStudent(studentId, r);
    }

    public void updateStudentDateOfBirth(int studentId, LocalDate dateOfBirth) {
        Student r = studentRepository.getStudentById(studentId);
        if (r == null) {
            return;
        }
        r.setDateOfBirth(dateOfBirth);
        studentRepository.updateStudent(studentId, r);
    }

    public void updateStudentAddress(int studentId, String address) {
        Student r = studentRepository.getStudentById(studentId);
        if (r == null) {
            return;
        }
        r.setAddress(address);
        studentRepository.updateStudent(studentId, r);
    }

    public void updateStudentEmail(int studentId, String email) {
        Student r = studentRepository.getStudentById(studentId);
        if (r == null) {
            return;
        }
        r.setEmail(email);
        studentRepository.updateStudent(studentId, r);
    }

    public void updateStudentGender(int studentId, Constants.Gender g) {
        Student r = studentRepository.getStudentById(studentId);
        if (r == null) {
            return;
        }
        r.setGender(g);
        studentRepository.updateStudent(studentId, r);
    }

    public void updateStudentPhoneString(int studentId, String phoneString) {
        Student r = studentRepository.getStudentById(studentId);
        if (r == null) {
            return;
        }
        r.setPhoneString(phoneString);
        studentRepository.updateStudent(studentId, r);
    }

    public void updateStudentYearOfStudy(int studentId, int yearOfStudy) {
        Student r = studentRepository.getStudentById(studentId);
        if (r == null) {
            return;
        }
        r.setYearOfStudy(yearOfStudy);
        studentRepository.updateStudent(studentId, r);
    }


}
