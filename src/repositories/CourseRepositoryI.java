package repositories;

import models.Course;

public interface CourseRepositoryI {
    int insertCourse(Course course);
    Course getCourseById(int courseId);
    int removeCourse(Course course);
}
