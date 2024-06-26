package repositories;

import models.Teacher;
import services.CSVService;
import shared.Constants;
import shared.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class TeacherRepository implements TeacherRepositoryI {

    @Override
    public int insertTeacher(Teacher teacher) {
        CSVService.WriteAction("insertTeacher");
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;

            String sql = "INSERT INTO Teachers (firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearsOfExperience, department, specialization) VALUES (?, ?, ?, ?, ?, ?::gender, ?, ?, ?, ?) RETURNING id";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, teacher.getFirstName());
            stmt.setString(2, teacher.getLastName());
            stmt.setDate(3, java.sql.Date.valueOf(teacher.getDateOfBirth()));
            stmt.setString(4, teacher.getAddress());
            stmt.setString(5, teacher.getEmail());
            stmt.setObject(6, teacher.getGender().toString(), java.sql.Types.OTHER);
            stmt.setString(7, teacher.getPhoneString());
            stmt.setInt(8, teacher.getYearsOfExperience());
            stmt.setString(9, teacher.getDepartment());
            stmt.setString(10, teacher.getSpecialization());
            ResultSet rs = stmt.executeQuery();
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
    public Teacher getTeacherById(int teacherId) {
        CSVService.WriteAction("getTeacherById");
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "SELECT * FROM Teachers WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, teacherId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();
                String address = rs.getString("address");
                String email = rs.getString("email");
                Constants.Gender gender = Constants.Gender.valueOf(rs.getString("gender"));
                String phoneString = rs.getString("phoneString");
                int yearsOfExperience = rs.getInt("yearsOfExperience");
                String department = rs.getString("department");
                String specialization = rs.getString("specialization");
                con.close();
                return new Teacher(id, firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearsOfExperience, department, specialization);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Teacher> getAllTeachers() {
        CSVService.WriteAction("getAllTeachers");
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "SELECT * FROM Teachers";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Teacher> teachers = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();
                String address = rs.getString("address");
                String email = rs.getString("email");
                Constants.Gender gender = Constants.Gender.valueOf(rs.getString("gender"));
                String phoneString = rs.getString("phoneString");
                int yearsOfExperience = rs.getInt("yearsOfExperience");
                String department = rs.getString("department");
                String specialization = rs.getString("specialization");
                teachers.add(new Teacher(id, firstName, lastName, dateOfBirth, address, email, gender, phoneString, yearsOfExperience, department, specialization));
            }
            con.close();
            return teachers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void removeTeacher(int teacherId) {
        CSVService.WriteAction("removeTeacher");
        try {
            Connection conn = DbUtils.getConnection();
            assert conn != null;
            String sql = "DELETE FROM Teachers WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, teacherId);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean teacherExists(int teacherId) {
        CSVService.WriteAction("teacherExists");
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "SELECT * FROM Teachers WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, teacherId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                con.close();
                return true;
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateTeacher(int teacherId, Teacher teacher) {
        CSVService.WriteAction("updateTeacher");
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "UPDATE teachers SET firstname=?, lastname=?, dateofbirth=?, address=?, email=?, gender=?, phonestring=?, yearsofexperience=?, department=?, specialization=? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, teacher.getFirstName());
            stmt.setString(2, teacher.getLastName());
            stmt.setDate(3, java.sql.Date.valueOf(teacher.getDateOfBirth()));
            stmt.setString(4, teacher.getAddress());
            stmt.setString(5, teacher.getEmail());
            stmt.setObject(6, teacher.getGender().toString(), java.sql.Types.OTHER);
            stmt.setString(7, teacher.getPhoneString());
            stmt.setInt(8, teacher.getYearsOfExperience());
            stmt.setString(9, teacher.getDepartment());
            stmt.setString(10, teacher.getSpecialization());
            stmt.setInt(11, teacherId);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean teacherIsActive(Teacher teacher) {
        CSVService.WriteAction("teacherIsActive");
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "SELECT * FROM catalogues WHERE supervisorId = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, teacher.getTeacherId());
            var rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }

            sql = "SELECT * FROM courseInstances WHERE ? = ANY(teacherIds)";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, teacher.getTeacherId());
            rs = stmt.executeQuery();
            con.close();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
