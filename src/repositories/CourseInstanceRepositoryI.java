package repositories;

import models.CourseInstance;
import models.Teacher;

import java.util.ArrayList;

public interface CourseInstanceRepositoryI {
    int insertCourseInstance(CourseInstance courseInstance);

    CourseInstance getCourseInstanceById(int courseInstanceId);

    int removeCourseInstance(CourseInstance courseInstance);

    ArrayList<Integer> getAllTeachersIds();

    void removeCoursesOfTeacher(Integer teacherId);

    void reset();
}
