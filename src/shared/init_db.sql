-- CREATE TYPE Gender AS ENUM ('Male', 'Female');

-- CREATE TYPE Student AS (
--     firstName VARCHAR(255),
--     lastName VARCHAR(255),
--     dateOfBirth DATE,
--     address TEXT,
--     email VARCHAR(255),
--     gender Gender,
--     phoneString VARCHAR(255),
--     yearOfStudy INT
-- );

-- CREATE TABLE StudentRepositories (
--     id SERIAL PRIMARY KEY,
--     students Student[]
-- );

-- -- INSERT INTO StudentRepositories (students) VALUES (
-- --     ARRAY[
-- --         ('John', 'Doe', '2000-01-01', '123 Main St', 'john.doe@example.com', 'Male', '1234567890', 2)::Student,
-- --         ('Jane', 'Doe', '2001-02-02', '456 Elm St', 'jane.doe@example.com', 'Female', '0987654321', 3)::Student
-- --     ]
-- -- );

-- -- UPDATE StudentRepositories
-- -- SET students = array_append(students, ('Alex', 'Smith', '2002-03-03', '789 Pine St', 'alex.smith@example.com', 'Male', '1122334455', 1)::Student)
-- -- WHERE id = 1;

-- CREATE TABLE Teachers (
--     id SERIAL PRIMARY KEY,
--     firstName VARCHAR(255),
--     lastName VARCHAR(255),
--     dateOfBirth DATE,
--     address VARCHAR(255),
--     email VARCHAR(255),
--     gender Gender,
--     phoneString VARCHAR(255),
--     yearsOfExperience INT,
--     department VARCHAR(255),
--     specialization VARCHAR(255)
-- );

-- CREATE TABLE Courses (
--     id SERIAL PRIMARY KEY,
--     courseName VARCHAR(255),
--     courseDescription VARCHAR(255)
-- );

