# Catalog scolar - proiect PAO

### Classes

- Models
  - `Catalogue`
  - `Course`
  - `CourseInstance`
  - `Person`
  - `Student` (derivated from `Person`)
  - `Teacher` (derivated from `Person`)
- Repositories
  - `CatalogueRepository`
  - `CourseInstanceRepository`
  - `CourseRepository`
  - `StudentRepository`
  - `TeacherRepository`
- Services
  - `CSVService`
  - `ManagerService`
  - `MenuService`

### Actions:

- Exit
- Insert course
- Insert teacher
- Insert catalogue
- Insert course instance
- Insert student
- Remove course
- Remove teacher
- Remove catalogue
- Remove course instance
- Remove student
- Get all courses
- Get all teachers
- Get all catalogues
- Get all course instances
- Get all students
- Get course by id
- Get teacher by id
- Get catalogue by id
- Get course instance by id
- Get student by id
- Update course
  - Update name
  - Update description
- Update teacher
  - Update first name
  - Update last name
  - Update date of birth
  - Update address
  - Update email
  - Update gender
  - Update phone number
  - Update years of experience
  - Update department
  - Update specialization
- Update catalogue
  - Update name
  - Update description
  - Update class year
  - Update class symbol
  - Update class supervisor
- Update course instance
  - Update course id
  - Update teacher ids
  - Update start time
  - Update day
  - Update duration
- Update student
  - Update first name
  - Update last name
  - Update date of birth
  - Update address
  - Update email
  - Update gender
  - Update phone number
  - Update year of study

## Cerințe

### Etapa 1:

- [x] clase simple cu atribute private / protected și metode de acces
- [x] cel putin 2 colectii diferite (ArrayList, HashMap)
- [x] utilizare moștenire (student, teacher)
- [x] clase serviciu
- [x] clasa main

### Etapa 2:

- [x] baza de date relationala (postgreSQL)
- [x] repository pattern
- [x] servicii care sa foloseasca repository pattern
- [x] serviciu de audit care scrie intr-un fișier de tip CSV
