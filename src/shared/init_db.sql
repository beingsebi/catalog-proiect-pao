DROP TABLE IF EXISTS Students;
DROP TABLE IF EXISTS Catalogues;
DROP TABLE IF EXISTS CourseInstances;
DROP TABLE IF EXISTS CourseInstanceRepositories;
DROP TABLE IF EXISTS Courses;
DROP TABLE IF EXISTS Teachers;
DROP TYPE IF EXISTS Days;
DROP TYPE IF EXISTS Gender;


CREATE TYPE Gender AS ENUM ('MALE', 'FEMALE');
CREATE TYPE Days AS ENUM ('MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY');

CREATE TABLE Teachers
(
    id                SERIAL PRIMARY KEY,
    firstName         VARCHAR(255) NOT NULL,
    lastName          VARCHAR(255) NOT NULL,
    dateOfBirth       DATE         NOT NULL,
    address           VARCHAR(255) NOT NULL,
    email             VARCHAR(255) NOT NULL,
    gender            Gender       NOT NULL,
    phoneString       VARCHAR(255) NOT NULL,
    yearsOfExperience INT          NOT NULL,
    department        VARCHAR(255) NOT NULL,
    specialization    VARCHAR(255) NOT NULL
);

CREATE TABLE Courses
(
    id                SERIAL PRIMARY KEY,
    courseName        VARCHAR(255) NOT NULL,
    courseDescription VARCHAR(255) NOT NULL
);

CREATE TABLE CourseInstanceRepositories
(
    id  SERIAL PRIMARY KEY
);

CREATE TABLE CourseInstances
(
    id         SERIAL PRIMARY KEY,
    repoId 	   INT REFERENCES CourseInstanceRepositories (id),
    courseId   INT REFERENCES Courses (id),
    teacherIds INT[],
    startTime  TIME,
    day 	   Days,
    duration   INT
);

CREATE TABLE Catalogues
(
    id                   SERIAL PRIMARY KEY,
    name                 VARCHAR(255) NOT NULL,
    description          VARCHAR(255),
    class_year           INT,
    class_symbol         VARCHAR(255),
    supervisorId         INT REFERENCES teachers (id),
    courseInstanceRepoId INT REFERENCES CourseInstanceRepositories (id)
);

CREATE TABLE Students
(
    id          INT PRIMARY KEY,
    firstName   VARCHAR(255),
    lastName    VARCHAR(255),
    dateOfBirth DATE,
    address     VARCHAR(255),
    email       VARCHAR(255),
    gender      Gender,
    phoneString VARCHAR(255),
    yearOfStudy INT
);

