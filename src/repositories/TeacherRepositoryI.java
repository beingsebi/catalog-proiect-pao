package repositories;

import models.Teacher;

public interface TeacherRepositoryI {
    int insertTeacher(Teacher teacher);

    Teacher getTeacherById(int teacherId);

    int removeTeacher(Teacher teacher);

    boolean teacherExists(int teacherId);

    boolean teacherExists(Teacher teacher);
}
