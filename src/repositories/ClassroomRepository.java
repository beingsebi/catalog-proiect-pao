package repositories;

import models.Classroom;

import java.util.Set;
import java.util.HashSet;

public class ClassroomRepository implements ClassroomRepositoryI{
    private Set<Classroom> classrooms;

    public ClassroomRepository(Set<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public ClassroomRepository() {
        this.classrooms = new HashSet<>();
    }

    @Override
    public int insertClassroom(Classroom classroom) {
        classrooms.add(classroom);
        return classroom.getClassroomId();
    }

    @Override
    public Classroom getClassroomById(int classroomId) {
        for (Classroom classroom : classrooms) {
            if (classroom.getClassroomId() == classroomId) {
                return classroom;
            }
        }
        return null;
    }

    @Override
    public int removeClassroom(Classroom classroom) {
        boolean ok = classrooms.remove(classroom);
        if (!ok) {
            return -1;
        }
        return classroom.getClassroomId();
    }
}
