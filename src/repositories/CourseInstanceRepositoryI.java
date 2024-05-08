package repositories;

import models.CourseInstance;
import models.Teacher;
import shared.Constants;

import java.util.ArrayList;

public interface CourseInstanceRepositoryI {
    int insertCourseInstance(CourseInstance courseInstance);

    CourseInstance getCourseInstanceById(int courseInstanceId);
    int removeCourseInstance(CourseInstance courseInstance);
    ArrayList<Teacher> getAllTeachers();
    void removeCoursesOfTeacher(Teacher teacher);
    void reset();
}
