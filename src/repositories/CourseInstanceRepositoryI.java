package repositories;

import models.CourseInstance;

import java.util.ArrayList;

public interface CourseInstanceRepositoryI {

    int insertCourseInstance(CourseInstance courseInstance);

    CourseInstance getCourseInstanceById(int courseInstanceId);

    boolean removeCourseInstance(CourseInstance courseInstance);

    ArrayList<Integer> getAllTeachersIds();

    void removeCourseInstancesOfTeacher(Integer teacherId);

    void reset();

    int getCourseInstanceRepositoryId();
}
