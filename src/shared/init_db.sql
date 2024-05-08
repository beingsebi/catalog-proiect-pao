DROP TABLE IF EXISTS Catalogues;
DROP TABLE IF EXISTS CourseInstanceRepositories;
DROP TABLE IF EXISTS StudentRepositories;
DROP TYPE IF EXISTS Student;
DROP TABLE IF EXISTS Teachers;
DROP TYPE IF EXISTS CourseInstance;
DROP TABLE IF EXISTS Courses;
DROP TYPE IF EXISTS Gender;


CREATE TYPE Gender AS ENUM ('Male', 'Female');

CREATE TYPE Student AS (
                           id INT,
                           firstName VARCHAR(255),
                           lastName VARCHAR(255),
                           dateOfBirth DATE,
                           address TEXT,
                           email VARCHAR(255),
                           gender Gender,
                           phoneString VARCHAR(255),
                           yearOfStudy INT
                       );

CREATE TABLE StudentRepositories (
                                     id SERIAL PRIMARY KEY,
                                     students Student[]
);

CREATE TABLE Teachers (
                          id SERIAL PRIMARY KEY,
                          firstName VARCHAR(255) NOT NULL,
                          lastName VARCHAR(255) NOT NULL,
                          dateOfBirth DATE NOT NULL,
                          address VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          gender Gender NOT NULL,
                          phoneString VARCHAR(255) NOT NULL,
                          yearsOfExperience INT NOT NULL,
                          department VARCHAR(255) NOT NULL,
                          specialization VARCHAR(255) NOT NULL
);

CREATE TABLE Courses (
                         id SERIAL PRIMARY KEY,
                         courseName VARCHAR(255) NOT NULL,
                         courseDescription VARCHAR(255) NOT NULL
);

CREATE TYPE CourseInstance AS (
                                  id INT,
                                  courseId INT,
                                  teacherIds INT[],
                                  startTime TIME,
                                  duration INT
                              );

CREATE TABLE CourseInstanceRepositories (
                                            id SERIAL PRIMARY KEY,
                                            courseInstances courseInstance[]
);

CREATE TABLE Catalogues (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            description VARCHAR(255),
                            class_year INT,
                            class_symbol VARCHAR(255),
                            studentRepoId INT REFERENCES studentrepositories(id),
                            supervisorId INT REFERENCES teachers(id),
                            courseInstanceRepoId INT REFERENCES CourseInstanceRepositories(id)
);