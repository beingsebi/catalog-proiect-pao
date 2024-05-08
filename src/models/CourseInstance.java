package models;

import shared.Constants.Days;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

public class CourseInstance {
    private static int nextCourseInstanceId = 0;

    private final int courseInstanceId;
    private Course course;
    private ArrayList<Teacher> teachers;
    private LocalTime startTime;
    private Days day;
    private int duration;

    public CourseInstance(Course course, Collection<Teacher> teachers, LocalTime startTime, Days day , int duration) {
        this.courseInstanceId = nextCourseInstanceId++;
        this.course = course;
        this.teachers = new ArrayList<>();
        if(teachers != null)
            this.teachers.addAll(teachers);
        this.startTime = startTime;
        this.day = day;
        this.duration = duration;
    }


    @Override
    public String toString() {
        return "CourseInstance{" +
                "courseInstanceId=" + courseInstanceId +
                ", course=" + course +
                ", teachers=" + teachers +
                ", startTime=" + startTime +
                ", day=" + day +
                ", duration=" + duration +
                '}';
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

    public Days getDay() {
        return day;
    }

    public void setDay(Days day) {
        this.day = day;
    }

    public void addTeacher(Teacher teacher) {
        if (teachers.contains(teacher))
            return;
        this.teachers.add(teacher);
    }
}
