package models;

import shared.Constants.Days;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

public class CourseInstance {

    private final Integer courseInstanceId;
    private int repoId;
    private Course course;
    private ArrayList<Integer> teachers;
    private LocalTime startTime;
    private Days day;
    private int duration;


    public CourseInstance(int courseInstanceId, int repoId, Course course, Collection<Integer> teachers, LocalTime startTime, Days day, int duration) {
        this.courseInstanceId = courseInstanceId;
        this.repoId = repoId;
        this.course = course;
        this.teachers = new ArrayList<>();
        if (teachers != null) this.teachers.addAll(teachers);
        this.startTime = startTime;
        this.day = day;
        this.duration = duration;
    }

    public CourseInstance(int repoId, Course course, Collection<Integer> teachers, LocalTime startTime, Days day, int duration) {
        this.courseInstanceId = null;
        this.repoId = repoId;
        this.course = course;
        this.teachers = new ArrayList<>();
        if (teachers != null) this.teachers.addAll(teachers);
        this.startTime = startTime;
        this.day = day;
        this.duration = duration;
    }

    public int getRepoId() {
        return repoId;
    }


    @Override
    public String toString() {
        return "CourseInstance{" + "courseInstanceId=" + courseInstanceId + ", course=" + course + ", teachers=" + teachers + ", startTime=" + startTime + ", day=" + day + ", duration=" + duration + '}';
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
    public ArrayList<Integer> getTeachersIds() {
        return teachers;
    }

    @SuppressWarnings("unused")
    public void setTeachers(ArrayList<Integer> teachers) {
        this.teachers.clear();
        this.teachers.addAll(teachers);
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

    public void addTeacher(Integer teacherId) {
        if (teachers.contains(teacherId)) return;
        this.teachers.add(teacherId);
    }
}
