package models;

public class Course {

    private Integer courseId;
    private String courseName;
    private String courseDescription;

    public Course(String courseName, String courseDescription) {
        this.courseId = null;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                '}';
    }

    @SuppressWarnings("unused")
    public int getCourseId() {
        return courseId;
    }

    @SuppressWarnings("unused")
    public String getCourseName() {
        return courseName;
    }

    @SuppressWarnings("unused")
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @SuppressWarnings("unused")
    public String getCourseDescription() {
        return courseDescription;
    }

    @SuppressWarnings("unused")
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

}
