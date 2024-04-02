INSERT INTO majors (id, name, description) VALUES (1, 'Ingéniérie du Numérique', 'Ouaiiis du code partout');
INSERT INTO majors (id, name, description) VALUES (2, 'Structure & Matériaux', 'Beaucoup de béton et des poutres (snif elle a été renomée)');
INSERT INTO majors (id, name, description) VALUES (3, 'Aéronautique & Espace', 'Vive le vent');
INSERT INTO majors (id, name, description) VALUES (4, 'Data Engineering', 'Trop cool plein de données à ordonner');
INSERT INTO majors (id, name, description) VALUES (5, 'Energie & Environnement', 'On est full green');
INSERT INTO majors (id, name, description) VALUES (6, 'Engineering Management', 'Des managers de qualité');
INSERT INTO majors (id, name, description) VALUES (7, 'Ingénierie & Santé', 'On connait tous les os et tous les muscles du corps humain');
INSERT INTO majors (id, name, description) VALUES (8, 'Ingénierie & Architecture durable', 'Objectif 0 carbon');
INSERT INTO majors (id, name, description) VALUES (9, 'Design Industriel Durable', 'Ca existait pas pour la P2022 ça');

INSERT INTO students (id, first_name, last_name, birthdate, major_id) VALUES (1, 'Paul', 'Harrohide', '2002-06-15', 1);
INSERT INTO students (id, first_name, last_name, birthdate, major_id) VALUES (2, 'Jean', 'Bonbeur', '2001-08-21', 1);
INSERT INTO students (id, first_name, last_name, birthdate, major_id) VALUES (3, 'Alain', 'Térieur', '2000-01-11', 1);

INSERT INTO courses (id, name, hours) VALUES (1, 'Spanish', 30);
INSERT INTO courses (id, name, hours) VALUES (2, 'German', 30);
INSERT INTO courses (id, name, hours) VALUES (3, 'Internet of Things', 30);
INSERT INTO courses (id, name, hours) VALUES (4, 'Thermodynamic', 30);
INSERT INTO courses (id, name, hours) VALUES (5, 'Anatomy', 30);
INSERT INTO courses (id, name, hours) VALUES (6, 'Maths', 30);
INSERT INTO courses (id, name, hours) VALUES (7, 'Java', 30);
INSERT INTO courses (id, name, hours) VALUES (8, 'Lean Management', 30);
INSERT INTO student_course (id, student_id, course_id) VALUES (1, 1, 7);

INSERT INTO users (id, username,email, password) VALUES ( 1, 'Mehdiabrk', 'mehdi.aberkane@edu.ece.fr', 'Amdin0001');
INSERT INTO users (id, username,email, password) VALUES ( 2, 'Arkahn',  'hipplyte.cacheux@edu.ece.fr', 'Admin0002');
INSERT INTO users (id, username,email, password) VALUES (  3, 'Adrien', 'adrien.mattei@edu.ece.fr', 'Admin0003');

INSERT INTO quiz (id, title, description) VALUES (1, 'Animal Quiz', 'Test your knowledge of different animals');
INSERT INTO quiz (id, title, description) VALUES (2, 'Famous Landmarks Quiz', 'Identify these famous landmarks from around the world');


INSERT INTO questions (id, quizId, questionText, questionPicture)
VALUES
    (1, 1, 'What is the largest land animal?', 'https://example.com/african-elephant.jpg'),
    (2, 1, 'Which animal is known as the "king of the jungle"?', 'https://example.com/lion.jpg'),
    (3, 1, 'What is the fastest land animal?', 'https://example.com/cheetah.jpg'),
    (4, 1, 'Which animal is known for its distinctive black and white stripes?', 'https://example.com/zebra.jpg'),
    (5, 1, 'What is the national animal of Australia?', 'https://example.com/kangaroo.jpg');

INSERT INTO questions (id, quizId, questionText, questionPicture)
VALUES
    (6, 2, 'Identify this famous landmark located in Paris, France.', 'https://example.com/eiffel-tower.jpg'),
    (7, 2, 'Which landmark is this, located in Agra, India?', 'https://example.com/taj-mahal.jpg'),
    (8, 2, 'Recognize this iconic landmark in New York City, USA.', 'https://example.com/statue-of-liberty.jpg'),
    (9, 2, 'What is the name of this ancient wonder located in Giza, Egypt?', 'https://example.com/great-pyramid.jpg'),
    (10, 2, 'Identify this famous bridge located in San Francisco, USA.', 'https://example.com/golden-gate-bridge.jpg');
