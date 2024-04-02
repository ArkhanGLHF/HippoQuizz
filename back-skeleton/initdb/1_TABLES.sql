create table students
(
    id SERIAL PRIMARY KEY,
    first_name TEXT not null,
    last_name TEXT not null,
    birthdate date null,
    major_id int null,
    image bytea null
);

create table majors
(
    id SERIAL PRIMARY KEY,
    name TEXT not null,
    description TEXT not null
);

create table courses
(
    id SERIAL PRIMARY KEY,
    name TEXT not null,
    hours int not null
);

create table student_course
(
    id SERIAL PRIMARY KEY,
    student_id int not null,
    course_id int not null
);

create table users (
   id SERIAL PRIMARY KEY,
   username TEXT  not null,
   email TEXT not null,
   password TEXT not null
);

create table quiz (
   id SERIAL PRIMARY KEY,
   title TEXT  not null,
   description TEXT not null
);

CREATE TABLE questions (
   id SERIAL PRIMARY KEY,
   quizId int not null,
   questionText TEXT not null,
   questionPicture TEXT not null
);

-- CREATE TABLE quizQuestion (
--    id SERIAL PRIMARY KEY,
--    quizId int not null,
--    questionId int not null
-- );