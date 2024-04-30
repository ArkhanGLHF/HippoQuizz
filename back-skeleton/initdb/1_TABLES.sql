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
   quiz_id int not null,
   question_text TEXT not null,
   question_picture TEXT not null,
   question_answer boolean not null
);

CREATE TABLE results (
    id INT PRIMARY KEY,
    user_id int not null,
    quiz_id int not null,
    score int not null,
    date_completed date not null
);

DROP TABLE results;
