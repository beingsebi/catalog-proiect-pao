package repositories;

import models.Course;
import models.CourseInstance;
import services.CSVService;
import shared.Constants;
import shared.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class CourseInstanceRepository implements CourseInstanceRepositoryI {

    public static int createCourseInstanceRepo() {
        CSVService.WriteAction("createCourseInstanceRepo");
        try {
            Connection con = DbUtils.getConnection();
            String sql = "INSERT INTO courseinstancerepositories DEFAULT VALUES RETURNING id";
            assert con != null;
            PreparedStatement stmt = con.prepareStatement(sql);
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

    public Integer courseInstanceRepositoryId;

    public static ArrayList<CourseInstance> getAllCourseInstances() {
        CSVService.WriteAction("getAllCourseInstances");
        ArrayList<CourseInstance> courseInstances = new ArrayList<>();
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "SELECT * FROM courseInstances";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int courseId = rs.getInt("courseId");
                Course course = CourseRepository.getCourseById(courseId);
                if (course == null) {
                    return null;
                }
                int repoId = rs.getInt("repoId");
                ArrayList<Integer> teacherIds = new ArrayList<>();
                Collections.addAll(teacherIds, (Integer[]) rs.getArray("teacherIds").getArray());
                Constants.Days day = Constants.Days.valueOf(rs.getString("day"));
                courseInstances.add(new CourseInstance(rs.getInt("id"), repoId, course, teacherIds, rs.getTime("startTime").toLocalTime(), day, rs.getInt("duration")));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseInstances;
    }

    @Override
    public int getCourseInstanceRepositoryId() {
        CSVService.WriteAction("getCourseInstanceRepositoryId");
        if (courseInstanceRepositoryId == null) {
            courseInstanceRepositoryId = createCourseInstanceRepo();
        }
        return courseInstanceRepositoryId;
    }

    public static void updateCourseInstance(int courseInstanceId, CourseInstance courseInstance) {
        CSVService.WriteAction("updateCourseInstance");
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "UPDATE courseInstances SET courseId = ?, teacherIds = ?, startTime = ?, day = ?, duration = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, courseInstance.getCourse().getCourseId());
            stmt.setArray(2, con.createArrayOf("integer", courseInstance.getTeachersIds().toArray()));
            stmt.setObject(3, courseInstance.getStartTime());
            stmt.setObject(4, courseInstance.getDay().toString(), java.sql.Types.OTHER);
            stmt.setInt(5, courseInstance.getDuration());
            stmt.setInt(6, courseInstanceId);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CourseInstanceRepository() {
        this.courseInstanceRepositoryId = createCourseInstanceRepo();
    }

    public CourseInstanceRepository(int courseInstanceRepositoryId) {
        this.courseInstanceRepositoryId = courseInstanceRepositoryId;
    }

    @Override
    public int insertCourseInstance(CourseInstance courseInstance) {
        CSVService.WriteAction("insertCourseInstance");
        if (this.courseInstanceRepositoryId == null) {
            return -1;
        }

        try {
            Connection con = DbUtils.getConnection();
            String sql = "INSERT INTO courseInstances (repoId, courseId, teacherIds, startTime, day, duration) VALUES (?, ?, ?, ?, ?, ?) RETURNING id";
            assert con != null;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, this.courseInstanceRepositoryId);
            stmt.setInt(2, courseInstance.getCourse().getCourseId());
            stmt.setArray(3, con.createArrayOf("integer", courseInstance.getTeachersIds().toArray()));
            stmt.setObject(4, courseInstance.getStartTime());
            stmt.setObject(5, courseInstance.getDay().toString(), java.sql.Types.OTHER);
            stmt.setInt(6, courseInstance.getDuration());
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


    public static CourseInstance getCourseInstanceById(int courseInstanceId) {
        CSVService.WriteAction("getCourseInstanceById");
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "SELECT * FROM courseInstances WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, courseInstanceId);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return null;
            }
            int courseId = rs.getInt("courseId");
            Course course = CourseRepository.getCourseById(courseId);
            if (course == null) {
                return null;
            }
            int repoId = rs.getInt("repoId");
            ArrayList<Integer> teacherIds = new ArrayList<>();
            Collections.addAll(teacherIds, (Integer[]) rs.getArray("teacherIds").getArray());
            Constants.Days day = Constants.Days.valueOf(rs.getString("day"));
            return new CourseInstance(courseInstanceId, repoId, course, teacherIds, rs.getTime("startTime").toLocalTime(), day, rs.getInt("duration"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void removeCourseInstance(CourseInstance courseInstance) {
        CSVService.WriteAction("removeCourseInstance");
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "DELETE FROM courseInstances WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, courseInstance.getCourseInstanceId());
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Integer> getAllTeachersIds() {
        CSVService.WriteAction("getAllTeachersIds");
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "SELECT teacherIds FROM courseInstances WHERE repoId = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, this.courseInstanceRepositoryId);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Integer> teachers = new ArrayList<>();
            while (rs.next()) {
                Collections.addAll(teachers, (Integer[]) rs.getArray("teacherIds").getArray());
            }
            con.close();
            return teachers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeCourseInstancesOfTeacher(Integer teacherId) {
        CSVService.WriteAction("removeCourseInstancesOfTeacher");
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "DELETE FROM courseInstances WHERE repoId = ? AND ? = ANY(teacherIds)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, this.courseInstanceRepositoryId);
            stmt.setInt(2, teacherId);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reset() {
        CSVService.WriteAction("resetCourseInstanceRepository");
        if (this.courseInstanceRepositoryId == null) {
            return;
        }
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "DELETE FROM courseInstances WHERE repoId = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, this.courseInstanceRepositoryId);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
