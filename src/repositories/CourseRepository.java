package repositories;

import models.Course;

import java.util.Set;
import java.util.HashSet;

public class CourseRepository implements CourseRepositoryI{
    private Set<Course> courses;

    public CourseRepository(Set<Course> courses) {
        this.courses = courses;
    }

    public CourseRepository() {
        this.courses = new HashSet<>();
    }

    @Override
    public int insertCourse(Course course) {
        courses.add(course);
        return course.getCourseId();
    }

    @Override
    public Course getCourseById(int courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    @Override
    public int removeCourse(Course course) {
        boolean ok = courses.remove(course);
        if (!ok) {
            return -1;
        }
        return course.getCourseId();
    }

    @Override
    public boolean courseExists(Course course) {
        return courses.contains(course);
    }

    @Override
    public String toString() {
        return "CourseRepository{" +
                "courses=" + courses +
                '}';
    }
}
