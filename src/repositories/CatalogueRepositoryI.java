package repositories;

import models.Catalogue;
import models.Student;
import models.Teacher;

public interface CatalogueRepositoryI {
    int insertCatalogue(Catalogue catalogue);

    Catalogue getCatalogueById(int catalogueId);

    void removeCatalogue(int catalogueId);

    boolean catalogueExists(Catalogue catalogue);

    void removeTeacher(Teacher teacher);
}
