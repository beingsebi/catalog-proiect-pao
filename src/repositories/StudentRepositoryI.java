package repositories;

import models.Student;

public interface StudentRepositoryI {
    int insertStudent(Student student);

    Student getStudentById(int studentId);

    int removeStudent(Student student);

    boolean studentExists(int studentId);

    boolean studentExists(Student student);

}