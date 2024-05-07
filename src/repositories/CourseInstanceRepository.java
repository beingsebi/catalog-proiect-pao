package repositories;

import models.CourseInstance;
import models.Teacher;
import shared.Constants;
import shared.CourseInstanceComparator;
import java.util.*;

public class CourseInstanceRepository implements CourseInstanceRepositoryI{
    private final Set<CourseInstance> courseInstances;
    private final Map<Constants.Days, TreeSet<CourseInstance>> timetable;

    public CourseInstanceRepository() {
        this.courseInstances = new HashSet<>();
        this.timetable = new HashMap<>();
        for (Constants.Days day : Constants.Days.values()) {
            timetable.put(day, new TreeSet<>(new CourseInstanceComparator()));
        }
    }

    @Override
    public int insertCourseInstance(CourseInstance courseInstance, Constants.Days day) {
        if (courseInstances.add(courseInstance)) {
            return -1;
        }
        timetable.get(day).add(courseInstance);
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
    public int removeCourseInstance(CourseInstance courseInstance, Constants.Days day) {
        if (!courseInstances.remove(courseInstance)) {
            return -1;
        }
        timetable.get(day).remove(courseInstance);
        return courseInstance.getCourseInstanceId();
    }

    @Override
    public int removeCourseInstance(CourseInstance courseInstance) {
        if (!courseInstances.remove(courseInstance)) {
            return -1;
        }
        for (TreeSet<CourseInstance> courseInstances : timetable.values()) {
            courseInstances.remove(courseInstance);
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
        for (TreeSet<CourseInstance> courseInstances : timetable.values()) {
            courseInstances.removeIf(courseInstance -> courseInstance.getTeachers().contains(teacher));
        }
    }

    @Override
    public void reset() {
        courseInstances.clear();
        for (TreeSet<CourseInstance> courseInstances : timetable.values()) {
            courseInstances.clear();
        }
    }
}
