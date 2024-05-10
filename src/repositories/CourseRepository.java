package repositories;

import models.Course;
import services.CSVService;
import shared.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CourseRepository implements CourseRepositoryI {

    @Override
    public int insertCourse(Course course) {
        CSVService.WriteAction("insertCourse");
        try {
            Connection con = DbUtils.getConnection();
            String sql = "INSERT INTO courses (courseName, courseDescription) VALUES (?, ?) RETURNING id";
            assert con != null;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getCourseDescription());
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

    public static Course getCourseById(int courseId) {
        CSVService.WriteAction("getCourseById");
        try {
            Connection con = DbUtils.getConnection();
            String sql = "SELECT * FROM courses WHERE id = ?";
            assert con != null;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            con.close();
            if (rs.next()) {
                int id = rs.getInt("id");
                String courseName = rs.getString("courseName");
                String courseDescription = rs.getString("courseDescription");
                return new Course(courseId, courseName, courseDescription);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeCourse(int courseId) {
        CSVService.WriteAction("removeCourse");
        try {
            Connection con = DbUtils.getConnection();
            String sql = "DELETE FROM courses WHERE id = ?";
            assert con != null;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, courseId);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean courseExists(int courseId) {
        CSVService.WriteAction("courseExists");
        try {
            Connection con = DbUtils.getConnection();
            String sql = "SELECT * FROM courses WHERE id = ?";
            assert con != null;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            con.close();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateCourse(int courseId, Course course) {
        CSVService.WriteAction("updateCourse");
        try {
            Connection con = DbUtils.getConnection();
            String sql = "UPDATE courses SET courseName = ?, courseDescription = ? WHERE id = ?";
            assert con != null;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getCourseDescription());
            stmt.setInt(3, courseId);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Course> getAllCourses() {
        CSVService.WriteAction("getAllCourses");
        ArrayList<Course> courses = new ArrayList<>();
        try {
            Connection con = DbUtils.getConnection();
            String sql = "SELECT * FROM courses";
            assert con != null;
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String courseName = rs.getString("courseName");
                String courseDescription = rs.getString("courseDescription");
                courses.add(new Course(id, courseName, courseDescription));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
}
