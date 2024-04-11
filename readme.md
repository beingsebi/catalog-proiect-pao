# Catalog scolar - proiect PAO

### Objects

- `CatalogueService`: Singleton service class for managing a catalogue.
- `Catalogue`: Represents a catalogue with classrooms, students, courses, teachers.
- `Classroom`: Represents a class of students.
- `Course`: Represents a course.
- `CourseInstance`: Represents an instance of a course held by a teacher at a given day and hour every week.
- `Person`: Represents a person.
- `Student`: Represents a student, subclass of `Person`.
- `Teacher`: Represents a teacher, subclass of `Person`.
- `Constants`: Contains constant values used across the application.

### Actions:

1. Create the catalogue: `CatalogueService.createCatalogue()`
2. Add a teacher: `CatalogueService.insertTeacher()`
3. Add a student: `CatalogueService.insertStudent()`
4. Add a course: `CatalogueService.insertCourse()`
5. Add a classroom: `CatalogueService.createClassroom()`
6. Add a student to a classroom: `CatalogueService.addStudentToClassroom()`
7. Remove a student from a classroom: `CatalogueService.removeStudentFromClassroom()`
8. Add a course instance to the timetable: `CatalogueService.addCourseInstanceToTimetable()`
9. Change catalogue name: `CatalogueService.setCatalogueName()`
10. Change catalogue description: `CatalogueService.setCatalogueDescription()`
11. Get a student by ID: `CatalogueService.getStudentById()`
12. Get a teacher by ID: `CatalogueService.getTeacherById()`
13. Get a course by ID: `CatalogueService.getCourseById()`
14. Get a classroom by ID: `CatalogueService.getClassroomById()`
15. Remove all entries from the timetable: `CatalogueService.resetTimetable()`