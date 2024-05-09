package repositories;

import models.Student;
import org.postgresql.util.PGobject;
import shared.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentRepository /*implements StudentRepositoryI */{
    private static int nextStudentRepoId = 0;
    private final int studentRepoId;

    //    private final Set<Student> students;
//
    public StudentRepository() {
        this.studentRepoId = nextStudentRepoId++;
    }

//    @Override
    public int insertStudent(Student student) {
        try {
            Connection con = DbUtils.getConnection();

            PGobject studentObject = new PGobject();
            studentObject.setType("student");
            studentObject.setValue(String.format("(%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d)",
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getDateOfBirth(),
                    student.getAddress(),
                    student.getEmail(),
                    student.getGender(),
                    student.getPhoneString(),
                    student.getYearOfStudy()
            ));

            String sql = "UPDATE StudentRepositories SET students = array_append(students, ?) WHERE id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setObject(1, studentObject);
            stmt.setInt(2, this.studentRepoId);

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return student.getId();
    }

//    @Override
//    public Student getStudentById(int studentId) {
//        for (Student student : students) {
//            if (student.getStudentId() == studentId) {
//                return student;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean studentExists(int studentId) {
//        for (Student student : students) {
//            if (student.getStudentId() == studentId) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean studentExists(Student student) {
//        return this.studentExists(student.getStudentId());
//    }
//
//    @Override
//    public int removeStudent(Student student) {
//        if (!students.remove(student)) {
//            return -1;
//        }
//        return student.getStudentId();
//    }
//
//    @Override
//    public String toString() {
//        return "StudentRepository{" +
//                "students=" + students +
//                '}';
//    }
}
