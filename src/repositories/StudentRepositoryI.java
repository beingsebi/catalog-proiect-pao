package repositories;

import models.Student;

public interface StudentRepositoryI {
    int insertStudent(Student student);

    Student getStudentById(int studentId);

    int removeStudent(Student student);

    public boolean studentExists(int studentId);

    public boolean studentExists(Student student);

}