package repositories;

import models.Student;
import shared.Constants;
import shared.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentRepository implements StudentRepositoryI {

    @Override
    public int insertStudent(Student student) {
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "INSERT INTO students (catalogueId, firstName, lastName, dateOfBirth, address," +
                    "email, gender, phoneString, yearOfStudy) VALUES (?,?,?,?,?,?,?,?,?) RETURNING id";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, student.getCatalogueId());
            stmt.setString(2, student.getFirstName());
            stmt.setString(3, student.getLastName());
            stmt.setDate(4, java.sql.Date.valueOf(student.getDateOfBirth()));
            stmt.setString(5, student.getAddress());
            stmt.setString(6, student.getEmail());
            stmt.setObject(7, student.getGender().toString(), java.sql.Types.OTHER);
            stmt.setString(8, student.getPhoneString());
            stmt.setInt(9, student.getYearOfStudy());
            var rs = stmt.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            con.close();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Student getStudentById(int studentId) {
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return null;
            }
            Student student = new Student(rs.getInt("id"), rs.getInt("catalogueId"), rs.getString("firstName"), rs.getString("lastName"),
                    rs.getDate("dateOfBirth").toLocalDate(), rs.getString("address"), rs.getString("email"), Constants.Gender.valueOf(rs.getString("gender")),
                    rs.getString("phoneString"), rs.getInt("yearOfStudy"));
            con.close();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean studentExists(int studentId) {
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            boolean exists = rs.next();
            con.close();
            return exists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean studentExists(Student student) {
        return this.studentExists(student.getStudentId());
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "SELECT * FROM students";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student(rs.getInt("id"), rs.getInt("catalogueId"), rs.getString("firstName"), rs.getString("lastName"),
                        rs.getDate("dateOfBirth").toLocalDate(), rs.getString("address"), rs.getString("email"), Constants.Gender.valueOf(rs.getString("gender")),
                        rs.getString("phoneString"), rs.getInt("yearOfStudy"));
                students.add(student);
            }
            con.close();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateStudent(int studentId, Student student) {
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "UPDATE students SET catalogueId = ?, firstName = ?, lastName = ?, dateOfBirth = ?, address = ?, email = ?, gender = ?, phoneString = ?, yearOfStudy = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, student.getCatalogueId());
            stmt.setString(2, student.getFirstName());
            stmt.setString(3, student.getLastName());
            stmt.setDate(4, java.sql.Date.valueOf(student.getDateOfBirth()));
            stmt.setString(5, student.getAddress());
            stmt.setString(6, student.getEmail());
            stmt.setObject(7, student.getGender().toString(), java.sql.Types.OTHER);
            stmt.setString(8, student.getPhoneString());
            stmt.setInt(9, student.getYearOfStudy());
            stmt.setInt(10, studentId);
            stmt.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean removeStudent(Student student) {
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, student.getStudentId());
            int rows = stmt.executeUpdate();
            con.close();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
