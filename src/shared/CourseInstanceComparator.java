package shared;

import models.CourseInstance;

import java.util.Comparator;

public class CourseInstanceComparator implements Comparator<CourseInstance> {
    @Override public int compare(CourseInstance e1, CourseInstance e2) {
        return (e1.getStartTime()).compareTo(e2.getStartTime());
    }
}
