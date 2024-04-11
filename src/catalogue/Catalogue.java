package catalogue;

import classroom.Classroom;

import course.Course;
import course.CourseInstance;
import student.Student;
import teacher.Teacher;

import java.util.*;

public class Catalogue {
    private static int nextCatalogueId = 0;

    private final int catalogueId;
    private String catalogueName;
    private String catalogueDescription;
    private Set<Teacher> teachers;
    private Set<Student> students;
    private Set<Course> courses;
    private Set<Classroom> classrooms;
    private Map<Classroom, ArrayList<CourseInstance>> timetable;

    Catalogue(String catalogueName, String catalogueDescription) {
        this.catalogueId = nextCatalogueId++;
        this.catalogueName = catalogueName;
        this.catalogueDescription = catalogueDescription;
        this.classrooms = new HashSet<>();
        this.students = new HashSet<>();
        this.teachers = new HashSet<>();
        this.courses = new HashSet<>();
        this.timetable = new HashMap<>();
    }

    Catalogue (String catalogueName, String catalogueDescription, Collection<Teacher> teachers) {
        this(catalogueName, catalogueDescription);
        this.teachers.addAll(teachers);
    }

    Catalogue (String catalogueName, String catalogueDescription, Collection<Teacher> teachers, Collection<Student> students) {
        this(catalogueName, catalogueDescription, teachers);
        this.students.addAll(students);
    }

    Catalogue (String catalogueName, String catalogueDescription, Collection<Teacher> teachers, Collection<Student> students, Collection<Classroom> classrooms) {
        this(catalogueName, catalogueDescription, teachers, students);
        this.classrooms.addAll(classrooms);
    }

    @SuppressWarnings("unused")
    Catalogue (String catalogueName, String catalogueDescription, Collection<Teacher> teachers, Collection<Student> students, Collection<Classroom> classrooms, Collection<Course> courses) {
        this(catalogueName, catalogueDescription, teachers, students, classrooms);
        this.courses.addAll(courses);
    }

    @SuppressWarnings("unused")
    int getCatalogueId() {
        return catalogueId;
    }

    @SuppressWarnings("unused")
    String getCatalogueName() {
        return catalogueName;
    }

    @SuppressWarnings("unused")
    void setCatalogueName(String catalogueName) {
        this.catalogueName = catalogueName;
    }

    @SuppressWarnings("unused")
    String getCatalogueDescription() {
        return catalogueDescription;
    }

    @SuppressWarnings("unused")
    void setCatalogueDescription(String catalogueDescription) {
        this.catalogueDescription = catalogueDescription;
    }

    @SuppressWarnings("unused")
    Set<Classroom> getClassrooms() {
        return classrooms;
    }

    @SuppressWarnings("unused")
    void setClassrooms(Collection<Classroom> classrooms) {
        this.classrooms = new HashSet<>();
        this.classrooms.addAll(classrooms);
    }

    @SuppressWarnings("unused")
    Set<Student> getStudents() {
        return students;
    }

    @SuppressWarnings("unused")
    void setStudents(Collection<Student> students) {
        this.students = new HashSet<>();
        this.students.addAll(students);
    }

    @SuppressWarnings("unused")
    Set<Teacher> getTeachers() {
        return teachers;
    }

    @SuppressWarnings("unused")
    void setTeachers(Collection<Teacher> teachers) {
        this.teachers = new HashSet<>();
        this.teachers.addAll(teachers);
    }

    @SuppressWarnings("unused")
    Set<Course> getCourses() {
        return courses;
    }

    @SuppressWarnings("unused")
    void setCourses(Collection<Course> courses) {
        this.courses = new HashSet<>();
        this.courses.addAll(courses);
    }

    @SuppressWarnings("unused")
    int insertStudent(Student student) {
        students.add(student);
        return student.getStudentId();
    }

    @SuppressWarnings("unused")
    int insertTeacher(Teacher teacher) {
        teachers.add(teacher);
        return teacher.getTeacherId();
    }

    @SuppressWarnings("unused")
    int insertClassroom(Classroom classroom) {
        students.addAll(classroom.getStudents());
        classrooms.add(classroom);
        return classroom.getClassroomId();
    }

    @SuppressWarnings("unused")
    void removeStudent(Student student) {
        students.remove(student);
        for (Classroom classroom : classrooms) {
            classroom.removeStudent(student);
        }
    }

    @SuppressWarnings("unused")
    void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    @SuppressWarnings("unused")
    void removeClassroom(Classroom classroom) {
        classrooms.remove(classroom);
    }

    @SuppressWarnings("unused")
    int insertCourse(Course course) {
        courses.add(course);
        return course.getCourseId();
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "catalogueId=" + catalogueId +
                ", catalogueName='" + catalogueName + '\'' +
                ", catalogueDescription='" + catalogueDescription + '\'' +
                ", classrooms=" + classrooms +
                ", students=\n" + students +
                ", teachers=\n" + teachers +
                ", courses=\n" + courses +
                '}';
    }

    @SuppressWarnings("unused")
    Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    @SuppressWarnings("unused")
    Teacher getTeacherById(int teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() == teacherId) {
                return teacher;
            }
        }
        return null;
    }

    @SuppressWarnings("unused")
    Classroom getClassroomById(int classroomId) {
        for (Classroom classroom : classrooms) {
            if (classroom.getClassroomId() == classroomId) {
                return classroom;
            }
        }
        return null;
    }

    @SuppressWarnings("unused")
    void resetTimetable() {
        timetable.clear();
    }

    @SuppressWarnings("unused")
    Map<Classroom, ArrayList<CourseInstance>> getTimetable() {
        return timetable;
    }

    @SuppressWarnings("unused")
    void setTimetable(Map<Classroom, ArrayList<CourseInstance>> timetable) {
        this.classrooms.addAll(timetable.keySet());
        for(Classroom classroom : timetable.keySet()) {
            this.students.addAll(classroom.getStudents());
        }
        for(ArrayList<CourseInstance> courseInstances : timetable.values()) {
            for(CourseInstance courseInstance : courseInstances) {
                this.teachers.addAll(courseInstance.getTeachers());
                this.courses.add(courseInstance.getCourse());
            }
        }
        this.timetable = Map.copyOf(timetable);
    }

    @SuppressWarnings("unused")
    void addCourseInstance(Classroom classroom, CourseInstance courseInstance) {
        if (timetable.containsKey(classroom)) {
            timetable.get(classroom).add(courseInstance);
        } else {
            ArrayList<CourseInstance> courseInstances = new ArrayList<>();
            courseInstances.add(courseInstance);
            timetable.put(classroom, courseInstances);
        }
    }

    public Course getCourseById(int courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }
}
