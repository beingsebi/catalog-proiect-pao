package models;

import repositories.CourseInstanceRepository;

import java.util.ArrayList;
import java.util.HashSet;

public class Catalogue {

    private Integer catalogueId;
    private final CourseInstanceRepository courseInstanceRepository;
    private String catalogueName;
    private String catalogueDescription;
    private int classYear;
    private String classSymbol;
    private int classSupervisorId;


    public Catalogue(String catalogueName, String catalogueDescription, int classYear, String classSymbol, int classSupervisorId) {
        this.catalogueId = null;
        this.catalogueName = catalogueName;
        this.catalogueDescription = catalogueDescription;

        this.classYear = classYear;
        this.classSymbol = classSymbol;
        this.classSupervisorId = classSupervisorId;
        this.courseInstanceRepository = new CourseInstanceRepository();
    }

    public Catalogue(int id, String name, String description, int classYear, String classSymbol, int supervisorId, int courseInstanceRepoId) {
        this.catalogueId = id;
        this.catalogueName = name;
        this.catalogueDescription = description;

        this.classYear = classYear;
        this.classSymbol = classSymbol;
        this.classSupervisorId = supervisorId;
        this.courseInstanceRepository = new CourseInstanceRepository(courseInstanceRepoId);
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

    public int getClassSupervisorId() {
        return classSupervisorId;
    }

    public void setClassSupervisorId(int classSupervisorId) {
        this.classSupervisorId = classSupervisorId;
    }

    public int insertCourseInstance(CourseInstance courseInstance) {
        return courseInstanceRepository.insertCourseInstance(courseInstance);
    }

    public ArrayList<Integer> getAllTeachersIds() {
        ArrayList<Integer> aux = courseInstanceRepository.getAllTeachersIds();
        HashSet<Integer> curated = new HashSet<>(aux);
        return new ArrayList<>(curated);
    }

    public void removeCoursesOfTeacher(Teacher teacher) {
        courseInstanceRepository.removeCourseInstancesOfTeacher(teacher.getTeacherId());
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "catalogueId=" + catalogueId +
                ", catalogueName='" + catalogueName + '\'' +
                ", catalogueDescription='" + catalogueDescription + '\'' +
                ", classYear=" + classYear +
                ", classSymbol='" + classSymbol + '\'' +
                ", classSupervisor=" + classSupervisorId +
                ", courseInstanceRepository=" + courseInstanceRepository +
                '}';
    }

    public CourseInstanceRepository getCourseInstanceRepository() {
        return courseInstanceRepository;
    }
}
