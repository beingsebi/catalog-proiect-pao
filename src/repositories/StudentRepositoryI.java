package repositories;

import models.Student;

import java.util.ArrayList;

public interface StudentRepositoryI {
    int insertStudent(Student student);

    Student getStudentById(int studentId);

    boolean removeStudent(Student student);

    boolean studentExists(int studentId);

    boolean studentExists(Student student);

    ArrayList<Student> getAllStudents();

}