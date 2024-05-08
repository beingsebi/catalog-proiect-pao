package repositories;

import models.CourseInstance;
import models.Teacher;

import java.util.*;

public class CourseInstanceRepository implements CourseInstanceRepositoryI{
    private final Set<CourseInstance> courseInstances;

    public CourseInstanceRepository() {
        this.courseInstances = new HashSet<>();
    }

    @Override
    public int insertCourseInstance(CourseInstance courseInstance) {
        if (!courseInstances.add(courseInstance)) {
            return -1;
        }
        return courseInstance.getCourseInstanceId();
    }

    @Override
    public CourseInstance getCourseInstanceById(int courseInstanceId) {
        for (CourseInstance courseInstance : courseInstances) {
            if (courseInstance.getCourseInstanceId() == courseInstanceId) {
                return courseInstance;
            }
        }
        return null;
    }

    @Override
    public int removeCourseInstance(CourseInstance courseInstance) {
        if (!courseInstances.remove(courseInstance)) {
            return -1;
        }
        return courseInstance.getCourseInstanceId();
    }

    @Override
    public ArrayList<Teacher> getAllTeachers() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (CourseInstance courseInstance : courseInstances) {
            teachers.addAll(courseInstance.getTeachers());
        }
        return teachers;
    }

    @Override
    public void removeCoursesOfTeacher(Teacher teacher) {
        this.courseInstances.removeIf(courseInstance -> courseInstance.getTeachers().contains(teacher));
    }

    @Override
    public void reset() {
        courseInstances.clear();
    }
}
