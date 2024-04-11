package course;

import student.Student;
import teacher.Teacher;

import java.time.LocalTime;
import java.util.ArrayList;

public class CourseInstance {
    private static int nextCourseInstanceId = 0;

    private final int courseInstanceId;
    private Course course;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private LocalTime startTime;
    private int duration;

    public CourseInstance(Course course, ArrayList<Teacher> teachers, ArrayList<Student> students, LocalTime startTime, int duration) {
        this.courseInstanceId = nextCourseInstanceId++;
        this.course = course;
        this.teachers = teachers;
        this.students = students;
        this.startTime = startTime;
        this.duration = duration;
    }
    @SuppressWarnings("unused")
    public int getCourseInstanceId() {
        return courseInstanceId;
    }

    @SuppressWarnings("unused")
    public Course getCourse() {
        return course;
    }

    @SuppressWarnings("unused")
    public void setCourse(Course course) {
        this.course = course;
    }

    @SuppressWarnings("unused")
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    @SuppressWarnings("unused")
    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    @SuppressWarnings("unused")
    public ArrayList<Student> getStudents() {
        return students;
    }

    @SuppressWarnings("unused")
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @SuppressWarnings("unused")
    public LocalTime getStartTime() {
        return startTime;
    }

    @SuppressWarnings("unused")
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    @SuppressWarnings("unused")
    public int getDuration() {
        return duration;
    }

    @SuppressWarnings("unused")
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
