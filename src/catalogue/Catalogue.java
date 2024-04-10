package catalogue;

import classroom.Classroom;
import person.Person;

import java.util.Collection;
import java.util.Set;

public class Catalogue {
    private static int nextCatalogueId = 0;

    private final int catalogueId;
    private String catalogueName;

    private String catalogueDescription;

    private Set<Classroom> classrooms;

    public Catalogue(String catalogueName, String catalogueDescription, Collection<Classroom> classrooms) {
        this.catalogueId = nextCatalogueId++;
        this.catalogueName = catalogueName;
        this.catalogueDescription = catalogueDescription;
        this.classrooms = Set.copyOf(classrooms);
    }

    @SuppressWarnings("unused")
    public int getCatalogueId() {
        return catalogueId;
    }

    @SuppressWarnings("unused")
    public String getCatalogueName() {
        return catalogueName;
    }

    @SuppressWarnings("unused")
    public void setCatalogueName(String catalogueName) {
        this.catalogueName = catalogueName;
    }

    @SuppressWarnings("unused")
    public String getCatalogueDescription() {
        return catalogueDescription;
    }

    @SuppressWarnings("unused")
    public void setCatalogueDescription(String catalogueDescription) {
        this.catalogueDescription = catalogueDescription;
    }

    @SuppressWarnings("unused")
    public Set<Classroom> getClassrooms() {
        return classrooms;
    }

    @SuppressWarnings("unused")
    public void setClassrooms(Set<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "catalogueId=" + catalogueId +
                ", catalogueName='" + catalogueName + '\'' +
                ", catalogueDescription='" + catalogueDescription + '\'' +
                ", classrooms=" + classrooms +
                '}';
    }
}
