package repositories;

import models.Classroom;

public interface ClassroomRepositoryI {
    int insertClassroom(Classroom classroom);
    Classroom getClassroomById(int classroomId);
    int removeClassroom(Classroom classroom);
}
