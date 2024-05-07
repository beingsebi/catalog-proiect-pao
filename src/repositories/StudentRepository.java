package repositories;

import models.Student;

import java.util.HashSet;
import java.util.Set;

public class StudentRepository implements StudentRepositoryI{
    private Set<Student> students;

    public StudentRepository(Set<Student> students) {
        this.students = students;
    }

    public StudentRepository() {
        this.students = new HashSet<>();
    }

    @Override
    public int insertStudent(Student student) {
        students.add(student);
        return student.getStudentId();
    }

    @Override
    public Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean studentExists(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return true;
            }
        }
        return false;
    }

    public boolean studentExists(Student student) {
        return this.studentExists(student.getStudentId());
    }

    @Override
    public int removeStudent(Student student) {
        boolean ok = students.remove(student);
        if (!ok) {
            return -1;
        }
        return student.getStudentId();
    }
}
