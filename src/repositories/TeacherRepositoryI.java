package repositories;

import models.Teacher;

public interface TeacherRepositoryI {
    void insertTeacher(Teacher teacher);

    Teacher getTeacherById(int teacherId);

    void removeTeacher(int teacherId);

    boolean teacherExists(int teacherId);

    void updateTeacher(int teacherId, Teacher teacher);
}
