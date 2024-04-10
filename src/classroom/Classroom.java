package classroom;

import person.Person;
import student.Student;

import java.util.Collection;
import java.util.SortedSet;

import java.util.TreeSet;

public class Classroom {
    private static int nextClassroomId = 0;

    private final int classroomId;
    private int year;
    private String symbol;
    private SortedSet<Student> students;

    private Person supervisor;

    public Classroom(int year, String symbol, Collection<Student> students, Person supervisor) {
        this.classroomId = nextClassroomId++;
        this.year = year;
        this.symbol = symbol;
        this.students = new TreeSet<>();
        this.students.addAll(students);
        this.supervisor = supervisor;

    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomId=" + classroomId +
                ", year=" + year +
                ", symbol='" + symbol + '\'' +
                ", students=" + students +
                ", supervisor=" + supervisor +
                '}';
    }

    @SuppressWarnings("unused")
    public int getClassroomId() {
        return classroomId;
    }

    @SuppressWarnings("unused")
    public int getYear() {
        return year;
    }

    @SuppressWarnings("unused")
    public void setYear(int year) {
        this.year = year;
    }

    @SuppressWarnings("unused")
    public String getSymbol() {
        return symbol;
    }

    @SuppressWarnings("unused")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @SuppressWarnings("unused")
    public SortedSet<Student> getStudents() {
        return students;
    }

    @SuppressWarnings("unused")
    public void setStudents(SortedSet<Student> students) {
        this.students = students;
    }

    @SuppressWarnings("unused")
    public Person getSupervisor() {
        return supervisor;
    }

    @SuppressWarnings("unused")
    public void setSupervisor(Person supervisor) {
        this.supervisor = supervisor;
    }

    @SuppressWarnings("unused")
    public void reorderStudents() {
        TreeSet<Student> newStudents = new TreeSet<>();
        newStudents.addAll(students);
        students = newStudents;
    }

    @SuppressWarnings("unused")
    public void addStudent(Student student) {
        students.add(student);
    }

    @SuppressWarnings("unused")
    public void removeStudent(Student student) {
        students.remove(student);
    }

    @SuppressWarnings("unused")
    public void populateClass(Collection<Student> students) {
        this.students.addAll(students);
    }

    @SuppressWarnings("unused")
    public void clearStudents() {
        students.clear();
    }

    @SuppressWarnings("unused")
    public void transferStudents(Classroom classroom) {
        if (this == classroom) {
            return;
        }
        if (this.students == null) {
            this.students = new TreeSet<>();
        }
        students.addAll(classroom.students);
        classroom.students.clear();
    }
}
