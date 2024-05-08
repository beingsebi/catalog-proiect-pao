package models;

import repositories.*;
import shared.Constants;

import java.util.ArrayList;
import java.util.HashSet;

public class Catalogue {
    private static int nextCatalogueId = 0;

    private final int catalogueId;
    private String catalogueName;
    private String catalogueDescription;

    private int classYear;
    private String classSymbol;

    private final StudentRepository studentRepository;
    private Teacher classSupervisor;
    private final CourseInstanceRepository courseInstanceRepository;


    public Catalogue(String catalogueName, String catalogueDescription, int classYear, String classSymbol) {
        this.catalogueId = nextCatalogueId++;
        this.catalogueName = catalogueName;
        this.catalogueDescription = catalogueDescription;

        this.classYear = classYear;
        this.classSymbol = classSymbol;
        this.studentRepository = new StudentRepository();
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

    public int insertStudent(Student student) {
        return studentRepository.insertStudent(student);
    }

    public Student getStudentById(int studentId) {
        return studentRepository.getStudentById(studentId);
    }

    public int removeStudent(Student student) {
        return studentRepository.removeStudent(student);
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

    public ArrayList<Teacher> getAllTeachers() {
        ArrayList<Teacher> aux = courseInstanceRepository.getAllTeachers();
        if (classSupervisor != null && classSupervisor instanceof Teacher) {
            aux.add((Teacher) classSupervisor);
        }
        HashSet<Teacher> curated = new HashSet<>(aux);
        return new ArrayList<>(curated);
    }

    public void removeTeacher(Teacher teacher) {
        courseInstanceRepository.removeCoursesOfTeacher(teacher);
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
                ", studentRepository=" + studentRepository +
                ", classSupervisor=" + classSupervisor +
                ", courseInstanceRepository=" + courseInstanceRepository +
                '}';
    }
}
