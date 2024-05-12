DROP TABLE IF EXISTS users;

create table users
(
    id SERIAL PRIMARY KEY,
    username TEXT  not null,
    email TEXT not null,
    password TEXT not null
);

DROP TABLE IF EXISTS quiz;

create table quiz
(
    id SERIAL PRIMARY KEY,
    title TEXT  not null,
    description TEXT not null
);

DROP TABLE questions;

CREATE TABLE questions (
   id SERIAL PRIMARY KEY,
   quiz_id int not null,
   question_text TEXT not null,
   question_answer boolean not null
);

DROP TABLE results;

CREATE TABLE results (
    id SERIAL PRIMARY KEY,
    user_id int not null,
    quiz_id int not null,
    score int not null,
    date_completed date not null
);
