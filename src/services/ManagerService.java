package services;

import models.Student;
import models.Teacher;
import repositories.*;

public class ManagerService {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private CourseRepository courseRepository;
    private CatalogueRepository catalogueRepository;

    public ManagerService() {
        this.studentRepository = new StudentRepository();
        this.teacherRepository = new TeacherRepository();
        this.courseRepository = new CourseRepository();
        this.catalogueRepository = new CatalogueRepository();
    }

    public int insertStudent(Student student) {
        return studentRepository.insertStudent(student);
    }

    public Student getStudentById(int studentId) {
        return studentRepository.getStudentById(studentId);
    }

//    public int removeStudent(Student student) {
//        return studentRepository.removeStudent(student);
//    }

    public int insertTeacher(Teacher teacher) {
        return teacherRepository.insertTeacher(teacher);
    }

    public Teacher getTeacherById(int teacherId) {
        return teacherRepository.getTeacherById(teacherId);
    }


}
