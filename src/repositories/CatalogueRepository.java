package repositories;

import models.Catalogue;
import models.Student;
import models.Teacher;

import java.util.Set;
import java.util.HashSet;

public class CatalogueRepository implements CatalogueRepositoryI{
    public Set<Catalogue> catalogues;

    public CatalogueRepository() {
        this.catalogues = new HashSet<>();
    }

    @Override
    public int insertCatalogue(Catalogue catalogue) {
        catalogues.add(catalogue);
        return catalogue.getCatalogueId();
    }

    @Override
    public Catalogue getCatalogueById(int catalogueId) {
        for (Catalogue catalogue : catalogues) {
            if (catalogue.getCatalogueId() == catalogueId) {
                return catalogue;
            }
        }
        return null;
    }

    @Override
    public int removeCatalogue(Catalogue catalogue) {
        boolean ok = catalogues.remove(catalogue);
        if (!ok) {
            return -1;
        }
        return catalogue.getCatalogueId();
    }

    @Override
    public int removeStudent(Student student){
        for (Catalogue catalogue : catalogues) {
            if (catalogue.removeStudent(student) != -1) {
                return student.getStudentId();
            }
        }
        return -1;
    }

    @Override
    public boolean teacherExists(Teacher teacher) {
        for (Catalogue catalogue : catalogues) {
            if (catalogue.getAllTeachers().contains(teacher)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean catalogueExists(Catalogue catalogue) {
        return catalogues.contains(catalogue);
    }

    @Override
    public void removeTeacher(Teacher teacher) {
        for (Catalogue catalogue : catalogues) {
            catalogue.removeTeacher(teacher);
        }
    }
}
