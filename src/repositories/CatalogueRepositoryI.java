package repositories;

import models.Catalogue;
import models.Student;
import models.Teacher;

public interface CatalogueRepositoryI {
    int insertCatalogue(Catalogue catalogue);
    Catalogue getCatalogueById(int catalogueId);
    int removeCatalogue(Catalogue catalogue);
    int removeStudent(Student student);
    boolean checkIfTeacherExists(Teacher teacher);
    void removeTeacher(Teacher teacher);
}
