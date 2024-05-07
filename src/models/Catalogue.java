package models;

import repositories.*;

public class Catalogue {
    private static int nextCatalogueId = 0;

    private final int catalogueId;
    private String catalogueName;
    private String catalogueDescription;

    private StudentRepository studentRepository;
    private Classroom classroom;
    private CourseInstanceRepository courseInstanceRepository;

    public Catalogue(String catalogueName, String catalogueDescription) {
        this.catalogueId = nextCatalogueId++;
        this.catalogueName = catalogueName;
        this.catalogueDescription = catalogueDescription;

    }

    public int getCatalogueId() {
        return catalogueId;
    }
}
