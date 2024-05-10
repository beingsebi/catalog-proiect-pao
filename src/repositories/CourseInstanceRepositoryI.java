package repositories;

import models.CourseInstance;

import java.util.ArrayList;

public interface CourseInstanceRepositoryI {

    int insertCourseInstance(CourseInstance courseInstance);

    static CourseInstance getCourseInstanceById(int courseInstanceId) {
        return null;
    }

    static boolean removeCourseInstance(CourseInstance courseInstance) {
        return false;
    }

    ArrayList<Integer> getAllTeachersIds();

    void removeCourseInstancesOfTeacher(Integer teacherId);

    void reset();

    int getCourseInstanceRepositoryId();
}
