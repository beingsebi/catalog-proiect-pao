package repositories;

import models.Course;
import models.CourseInstance;
import shared.Constants;
import shared.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class CourseInstanceRepository implements CourseInstanceRepositoryI {

    public static int createCourseInstanceRepo() {
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

    public int getCourseInstanceRepositoryId() {
        if (courseInstanceRepositoryId == null) {
            courseInstanceRepositoryId = createCourseInstanceRepo();
        }
        return courseInstanceRepositoryId;
    }

    public CourseInstanceRepository() {
        this.courseInstanceRepositoryId = createCourseInstanceRepo();
    }

    public CourseInstanceRepository(int courseInstanceRepositoryId) {
        this.courseInstanceRepositoryId = courseInstanceRepositoryId;
    }

    @Override
    public int insertCourseInstance(CourseInstance courseInstance) {
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

    @Override
    public CourseInstance getCourseInstanceById(int courseInstanceId) {
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

    @Override
    public int removeCourseInstance(CourseInstance courseInstance) {
//        if (!courseInstances.remove(courseInstance)) {
//            return -1;
//        }
//        return courseInstance.getCourseInstanceId();
        return -1;
    }

    @Override
    public ArrayList<Integer> getAllTeachersIds() {
//        ArrayList<Integer> teachers = new ArrayList<>();
//        for (CourseInstance courseInstance : courseInstances) {
//            teachers.addAll(courseInstance.getTeachersIds());
//        }
//        return teachers;
        return null;
    }

    @Override
    public void removeCoursesOfTeacher(Integer teacherId) {
//        this.courseInstances.removeIf(courseInstance -> courseInstance.getTeachersIds().contains(teacherId));
    }

    @Override
    public void reset() {
//        courseInstances.clear();
    }
}
