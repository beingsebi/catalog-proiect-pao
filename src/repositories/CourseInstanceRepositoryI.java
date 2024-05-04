package repositories;

import models.Classroom;
import models.CourseInstance;

public interface CourseInstanceRepositoryI {
    int insertCourseInstance(CourseInstance courseInstance, Classroom classroom);
    CourseInstance getCourseInstanceById(int courseInstanceId);
    int removeCourseInstance(CourseInstance courseInstance, Classroom classroom);
    int removeCourseInstance(CourseInstance courseInstance);
}
