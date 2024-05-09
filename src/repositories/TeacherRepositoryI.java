package repositories;

import models.Teacher;

import java.util.ArrayList;

public interface TeacherRepositoryI {
    int insertTeacher(Teacher teacher);

    Teacher getTeacherById(int teacherId);

    ArrayList<Teacher> getAllTeachers();

    void removeTeacher(int teacherId);

    boolean teacherExists(int teacherId);

    void updateTeacher(int teacherId, Teacher teacher);
}
