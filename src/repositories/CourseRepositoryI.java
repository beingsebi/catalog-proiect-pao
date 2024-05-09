package repositories;

import models.Course;

public interface CourseRepositoryI {
    int insertCourse(Course course);

    static Course getCourseById(int courseId) {
        return null;
    }

    void removeCourse(int courseId);

    boolean courseExists(int courseId);

    void updateCourse(int courseId, Course course);
}
