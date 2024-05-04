package repositories;

import models.Classroom;
import models.CourseInstance;
import shared.Constants;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class CourseInstanceRepository implements CourseInstanceRepositoryI{
    private Set<CourseInstance> courseInstances;
    private Map<Constants.Days, ArrayList<CourseInstance>> timetable;

    @Override
    public int insertCourseInstance(CourseInstance courseInstance, Classroom classroom) {
        if (courseInstances.add(courseInstance)) {
            return -1;
        }
        timetable.get(classroom.getClassroomId()).add(courseInstance);
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
    public int removeCourseInstance(CourseInstance courseInstance, Classroom classroom) {
        if (!courseInstances.remove(courseInstance)) {
            return -1;
        }
        timetable.get(classroom.getClassroomId()).remove(courseInstance);
        return courseInstance.getCourseInstanceId();
    }

    @Override
    public int removeCourseInstance(CourseInstance courseInstance) {
        if (!courseInstances.remove(courseInstance)) {
            return -1;
        }
        for (ArrayList<CourseInstance> courseInstances : timetable.values()) {
            courseInstances.remove(courseInstance);
        }
        return courseInstance.getCourseInstanceId();
    }
}
