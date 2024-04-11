package catalogue;

import classroom.Classroom;

import course.Course;
import student.Student;
import teacher.Teacher;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Catalogue {
    private static int nextCatalogueId = 0;

    private final int catalogueId;
    private String catalogueName;
    private String catalogueDescription;
    private Set<Teacher> teachers;
    private Set<Student> students;
    private Set<Course> courses;
    private Set<Classroom> classrooms;


    public Catalogue(String catalogueName, String catalogueDescription) {
        this.catalogueId = nextCatalogueId++;
        this.catalogueName = catalogueName;
        this.catalogueDescription = catalogueDescription;
        this.classrooms = new HashSet<>();
        this.students = new HashSet<>();
        this.teachers = new HashSet<>();
        this.courses = new HashSet<>();
    }

    public Catalogue (String catalogueName, String catalogueDescription, Collection<Teacher> teachers) {
        this(catalogueName, catalogueDescription);
        this.teachers.addAll(teachers);
    }

    public Catalogue (String catalogueName, String catalogueDescription, Collection<Teacher> teachers, Collection<Student> students) {
        this(catalogueName, catalogueDescription, teachers);
        this.students.addAll(students);
    }

    public Catalogue (String catalogueName, String catalogueDescription, Collection<Teacher> teachers, Collection<Student> students, Collection<Classroom> classrooms) {
        this(catalogueName, catalogueDescription, teachers, students);
        this.classrooms.addAll(classrooms);
    }

    @SuppressWarnings("unused")
    public Catalogue (String catalogueName, String catalogueDescription, Collection<Teacher> teachers, Collection<Student> students, Collection<Classroom> classrooms, Collection<Course> courses) {
        this(catalogueName, catalogueDescription, teachers, students, classrooms);
        this.courses.addAll(courses);
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
    public void setClassrooms(Collection<Classroom> classrooms) {
        this.classrooms = new HashSet<>();
        this.classrooms.addAll(classrooms);
    }

    @SuppressWarnings("unused")
    public Set<Student> getStudents() {
        return students;
    }

    @SuppressWarnings("unused")
    public void setStudents(Collection<Student> students) {
        this.students = new HashSet<>();
        this.students.addAll(students);
    }

    @SuppressWarnings("unused")
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    @SuppressWarnings("unused")
    public void setTeachers(Collection<Teacher> teachers) {
        this.teachers = new HashSet<>();
        this.teachers.addAll(teachers);
    }

    @SuppressWarnings("unused")
    public Set<Course> getCourses() {
        return courses;
    }

    @SuppressWarnings("unused")
    public void setCourses(Collection<Course> courses) {
        this.courses = new HashSet<>();
        this.courses.addAll(courses);
    }

    @SuppressWarnings("unused")
    public void insertStudent(Student student) {
        students.add(student);
    }

    @SuppressWarnings("unused")
    public void insertTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    @SuppressWarnings("unused")
    public void insertClassroom(Classroom classroom) {
        classrooms.add(classroom);
    }

    @SuppressWarnings("unused")
    public void removeStudent(Student student) {
        students.remove(student);
    }

    @SuppressWarnings("unused")
    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    @SuppressWarnings("unused")
    public void removeClassroom(Classroom classroom) {
        classrooms.remove(classroom);
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "catalogueId=" + catalogueId +
                ", catalogueName='" + catalogueName + '\'' +
                ", catalogueDescription='" + catalogueDescription + '\'' +
                ", classrooms=" + classrooms +
                ", students=" + students +
                ", teachers=" + teachers +
                ", courses=" + courses +
                '}';
    }

    @SuppressWarnings("unused")
    public Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    @SuppressWarnings("unused")
    public Teacher getTeacherById(int teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() == teacherId) {
                return teacher;
            }
        }
        return null;
    }

    @SuppressWarnings("unused")
    public Classroom getClassroomById(int classroomId) {
        for (Classroom classroom : classrooms) {
            if (classroom.getClassroomId() == classroomId) {
                return classroom;
            }
        }
        return null;
    }


}
