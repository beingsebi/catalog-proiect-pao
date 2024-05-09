package services;

import models.Catalogue;
import models.Course;
import models.Student;
import models.Teacher;
import repositories.CatalogueRepository;
import repositories.CourseRepository;
import repositories.StudentRepository;
import repositories.TeacherRepository;
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
        return studentRepository.insertStudent(new Student(null, firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearOfStudy));
    }
//
//    public Student getStudentById(int studentId) {
//        return studentRepository.getStudentById(studentId);
//    }

    public void insertTeacher(Teacher teacher) {
        teacherRepository.insertTeacher(teacher);
    }

    public void insertTeacher(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, Constants.Gender gender, String phoneString, int yearsOfExperience, String department, String specialization) {
        teacherRepository.insertTeacher(new Teacher(firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearsOfExperience, department, specialization));
    }

    public Teacher getTeacherById(int teacherId) {
        return teacherRepository.getTeacherById(teacherId);
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

    public void insertCourse(Course course) {
        courseRepository.insertCourse(course);
    }

    public void insertCourse(String courseName, String courseDescription) {
        courseRepository.insertCourse(new Course(courseName, courseDescription));
    }

    public Course getCourseById(int courseId) {
        return courseRepository.getCourseById(courseId);
    }

    public void removeCourse(int courseId) {
        courseRepository.removeCourse(courseId);
    }

    public void updateCourse(int courseId, Course course) {
        courseRepository.updateCourse(courseId, course);
    }

    public void updateCourseName(int courseId, String courseName) {
        Course r = courseRepository.getCourseById(courseId);
        r.setCourseName(courseName);
        courseRepository.updateCourse(courseId, r);
    }

    public void updateCourseDescription(int courseId, String courseDescription) {
        Course r = courseRepository.getCourseById(courseId);
        r.setCourseDescription(courseDescription);
        courseRepository.updateCourse(courseId, r);
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

//    public int removeStudent(Student student) {
//        if (studentRepository.removeStudent(student) == -1) {
//            return -1;
//        }
//        return catalogueRepository.removeStudent(student);
//    }

    public boolean teacherIsActive(Teacher teacher) {
        return catalogueRepository.teacherExists(teacher);
    }

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

    public int assignTeacherAsSupervisorToCatalogue(Teacher teacher, int catalogueId) {
        Catalogue catalogue = catalogueRepository.getCatalogueById(catalogueId);
        if (catalogue == null) {
            return -1; // catalogue not found
        }
        catalogue.setClassSupervisor(teacher);
        return teacher.getTeacherId();
    }

    public int assignTeacherAsSupervisorToCatalogue(int teacherId, int catalogueId) {
        Teacher teacher = teacherRepository.getTeacherById(teacherId);
        if (teacher == null) {
            return -2; // teacher not found
        }
        return this.assignTeacherAsSupervisorToCatalogue(teacher, catalogueId);
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

//    public int insertCourseInstance(int catalogueId, Constants.Days day, int courseId, Collection<Teacher> teachers, LocalTime startTime, int duration) {
//        Course course = courseRepository.getCourseById(courseId);
//        if (course == null) {
//            return -1; // course not found
//        }
//        Catalogue catalogue = catalogueRepository.getCatalogueById(catalogueId);
//        if (catalogue == null) {
//            return -2; // catalogue not found
//        }
//        int
//        return catalogue.insertCourseInstance(new CourseInstance(course, teachers, startTime, day, duration));
//    }
//
//    public int insertCourseInstance(Catalogue catalogue, Constants.Days day, Course course, Collection<Teacher> teachers, LocalTime startTime, int duration) {
//        if (!this.catalogueRepository.catalogueExists(catalogue)) {
//            return -2; // catalogue not found
//        }
//        if (!this.courseRepository.courseExists(course)) {
//            return -1; // course not found
//        }
//        return catalogue.insertCourseInstance(new CourseInstance(course, teachers, startTime, day, duration));
//    }
}
