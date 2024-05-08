package repositories;

import models.Catalogue;
import models.Student;
import models.Teacher;

public interface CatalogueRepositoryI {
    int insertCatalogue(Catalogue catalogue);

    Catalogue getCatalogueById(int catalogueId);

    int removeCatalogue(Catalogue catalogue);

    int removeStudent(Student student);

    boolean teacherExists(Teacher teacher);

    boolean catalogueExists(Catalogue catalogue);

    void removeTeacher(Teacher teacher);
}
