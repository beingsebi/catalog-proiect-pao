package models;

import repositories.CourseInstanceRepository;

import java.util.ArrayList;
import java.util.HashSet;

public class Catalogue {
    private static int nextCatalogueId = 0;

    private final int catalogueId;
    private final CourseInstanceRepository courseInstanceRepository;
    private String catalogueName;
    private String catalogueDescription;
    private int classYear;
    private String classSymbol;
    private Teacher classSupervisor;


    public Catalogue(String catalogueName, String catalogueDescription, int classYear, String classSymbol) {
        this.catalogueId = nextCatalogueId++;
        this.catalogueName = catalogueName;
        this.catalogueDescription = catalogueDescription;

        this.classYear = classYear;
        this.classSymbol = classSymbol;
        this.classSupervisor = null;
        this.courseInstanceRepository = new CourseInstanceRepository();
    }

    public int getCatalogueId() {
        return catalogueId;
    }

    public String getCatalogueName() {
        return catalogueName;
    }

    public void setCatalogueName(String catalogueName) {
        this.catalogueName = catalogueName;
    }

    public String getCatalogueDescription() {
        return catalogueDescription;
    }

    public void setCatalogueDescription(String catalogueDescription) {
        this.catalogueDescription = catalogueDescription;
    }

    public int getClassYear() {
        return classYear;
    }

    public void setClassYear(int classYear) {
        this.classYear = classYear;
    }

    public String getClassSymbol() {
        return classSymbol;
    }

    public void setClassSymbol(String classSymbol) {
        this.classSymbol = classSymbol;
    }

    public Person getClassSupervisor() {
        return classSupervisor;
    }

    public void setClassSupervisor(Teacher classSupervisor) {
        this.classSupervisor = classSupervisor;
    }

    public int insertCourseInstance(CourseInstance courseInstance) {
        return courseInstanceRepository.insertCourseInstance(courseInstance);
    }

    public ArrayList<Integer> getAllTeachers() {
        ArrayList<Integer> aux = courseInstanceRepository.getAllTeachersIds();
        if (classSupervisor != null) {
            aux.add(classSupervisor.getTeacherId());
        }
        HashSet<Integer> curated = new HashSet<>(aux);
        return new ArrayList<>(curated);
    }

    public void removeTeacher(Teacher teacher) {
        courseInstanceRepository.removeCoursesOfTeacher(teacher.getTeacherId());
        if (classSupervisor != null && classSupervisor.equals(teacher)) {
            classSupervisor = null;
        }
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "catalogueId=" + catalogueId +
                ", catalogueName='" + catalogueName + '\'' +
                ", catalogueDescription='" + catalogueDescription + '\'' +
                ", classYear=" + classYear +
                ", classSymbol='" + classSymbol + '\'' +
                ", classSupervisor=" + classSupervisor +
                ", courseInstanceRepository=" + courseInstanceRepository +
                '}';
    }
}
