package repositories;

import models.CourseInstance;
import models.Teacher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CourseInstanceRepository implements CourseInstanceRepositoryI {
    private static int nextCourseInstanceId = 0;

    private final int repoId;

    private final Set<CourseInstance> courseInstances;

    public CourseInstanceRepository() {
        this.repoId = nextCourseInstanceId++;
        this.courseInstances = new HashSet<>();
    }

    public int getCourseInstanceId() {
        return repoId;
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
    public ArrayList<Integer> getAllTeachersIds() {
        ArrayList<Integer> teachers = new ArrayList<>();
        for (CourseInstance courseInstance : courseInstances) {
            teachers.addAll(courseInstance.getTeachersIds());
        }
        return teachers;
    }

    @Override
    public void removeCoursesOfTeacher(Integer teacherId) {
        this.courseInstances.removeIf(courseInstance -> courseInstance.getTeachersIds().contains(teacherId));
    }

    @Override
    public void reset() {
        courseInstances.clear();
    }
}
