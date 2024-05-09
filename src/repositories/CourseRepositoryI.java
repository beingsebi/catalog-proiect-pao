package repositories;

import models.Course;

public interface CourseRepositoryI {
    void insertCourse(Course course);

    Course getCourseById(int courseId);

    void removeCourse(int courseId);

    boolean courseExists(int courseId);

    void updateCourse(int courseId, Course course);
}
