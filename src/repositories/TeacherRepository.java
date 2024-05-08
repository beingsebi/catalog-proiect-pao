package repositories;

import models.Teacher;

import java.util.HashSet;
import java.util.Set;

public class TeacherRepository implements TeacherRepositoryI {
    private final Set<Teacher> teachers;

    public TeacherRepository(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public TeacherRepository() {
        this.teachers = new HashSet<>();
    }

    @Override
    public int insertTeacher(Teacher teacher) {
        teachers.add(teacher);
        return teacher.getTeacherId();
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() == teacherId) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public int removeTeacher(Teacher teacher) {
        boolean ok = teachers.remove(teacher);
        if (!ok) {
            return -1;
        }
        return teacher.getTeacherId();
    }

    @Override
    public boolean teacherExists(int teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() == teacherId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean teacherExists(Teacher teacher) {
        return this.teacherExists(teacher.getTeacherId());
    }
}
