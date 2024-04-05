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


INSERT INTO questions (id, quiz_id, question_text, question_picture)
VALUES
    (1, 1, 'What is the largest land animal?', 'https://example.com/african-elephant.jpg'),
    (2, 1, 'Which animal is known as the "king of the jungle"?', 'https://example.com/lion.jpg'),
    (3, 1, 'What is the fastest land animal?', 'https://example.com/cheetah.jpg'),
    (4, 1, 'Which animal is known for its distinctive black and white stripes?', 'https://example.com/zebra.jpg'),
    (5, 1, 'What is the national animal of Australia?', 'https://example.com/kangaroo.jpg');

INSERT INTO questions (id, quiz_id, question_text, question_picture)
VALUES
    (6, 2, 'Identify this famous landmark located in Paris, France.', 'https://example.com/eiffel-tower.jpg'),
    (7, 2, 'Which landmark is this, located in Agra, India?', 'https://example.com/taj-mahal.jpg'),
    (8, 2, 'Recognize this iconic landmark in New York City, USA.', 'https://example.com/statue-of-liberty.jpg'),
    (9, 2, 'What is the name of this ancient wonder located in Giza, Egypt?', 'https://example.com/great-pyramid.jpg'),
    (10, 2, 'Identify this famous bridge located in San Francisco, USA.', 'https://example.com/golden-gate-bridge.jpg');

-- Insert data into the answers table for the Animal Quiz
INSERT INTO answers (id, question_id, answer_text, is_correct, answer_picture)
VALUES
    (1, 1, 'African Elephant', true, 'https://example.com/african-elephant-answer.jpg'),
    (2, 1, 'Giraffe', false, 'https://example.com/giraffe.jpg'),
    (3, 1, 'Hippopotamus', false, 'https://example.com/hippo.jpg'),
    (4, 1, 'Rhinoceros', false, 'https://example.com/rhino.jpg'),
    (5, 2, 'Lion', true, 'https://example.com/lion-answer.jpg'),
    (6, 2, 'Tiger', false, 'https://example.com/tiger.jpg'),
    (7, 2, 'Leopard', false, 'https://example.com/leopard.jpg'),
    (8, 2, 'Cheetah', false, 'https://example.com/cheetah.jpg'),
    (9, 3, 'Cheetah', true, 'https://example.com/cheetah-answer.jpg'),
    (10, 3, 'Gazelle', false, 'https://example.com/gazelle.jpg'),
    (11, 3, 'Wildebeest', false, 'https://example.com/wildebeest.jpg'),
    (12, 3, 'Ostrich', false, 'https://example.com/ostrich.jpg'),
    (13, 4, 'Zebra', true, 'https://example.com/zebra-answer.jpg'),
    (14, 4, 'Giraffe', false, 'https://example.com/giraffe.jpg'),
    (15, 4, 'Okapi', false, 'https://example.com/okapi.jpg'),
    (16, 4, 'Antelope', false, 'https://example.com/antelope.jpg'),
    (17, 5, 'Kangaroo', true, 'https://example.com/kangaroo-answer.jpg'),
    (18, 5, 'Koala', false, 'https://example.com/koala.jpg'),
    (19, 5, 'Emu', false, 'https://example.com/emu.jpg'),
    (20, 5, 'Platypus', false, 'https://example.com/platypus.jpg');

-- Insert data into the answers table for the Famous Landmarks Quiz
INSERT INTO answers (id, question_id, answer_text, is_correct, answer_picture)
VALUES
    (21, 6, 'Eiffel Tower', true, 'https://example.com/eiffel-tower-answer.jpg'),
    (22, 6, 'Arc de Triomphe', false, 'https://example.com/arc-de-triomphe.jpg'),
    (23, 6, 'Notre-Dame Cathedral', false, 'https://example.com/notre-dame.jpg'),
    (24, 6, 'Louvre Museum', false, 'https://example.com/louvre.jpg'),
    (25, 7, 'Taj Mahal', true, 'https://example.com/taj-mahal-answer.jpg'),
    (26, 7, 'Red Fort', false, 'https://example.com/red-fort.jpg'),
    (27, 7, 'Qutub Minar', false, 'https://example.com/qutub-minar.jpg'),
    (28, 7, 'Hawa Mahal', false, 'https://example.com/hawa-mahal.jpg'),
    (29, 8, 'Statue of Liberty', true, 'https://example.com/statue-of-liberty-answer.jpg'),
    (30, 8, 'Empire State Building', false, 'https://example.com/empire-state-building.jpg'),
    (31, 8, 'Central Park', false, 'https://example.com/central-park.jpg'),
    (32, 8, 'Brooklyn Bridge', false, 'https://example.com/brooklyn-bridge.jpg'),
    (33, 9, 'Great Pyramid of Giza', true, 'https://example.com/great-pyramid-answer.jpg'),
    (34, 9, 'Sphinx', false, 'https://example.com/sphinx.jpg'),
    (35, 9, 'Valley of the Kings', false, 'https://example.com/valley-of-the-kings.jpg'),
    (36, 9, 'Abu Simbel Temples', false, 'https://example.com/abu-simbel.jpg'),
    (37, 10, 'Golden Gate Bridge', true, 'https://example.com/golden-gate-bridge-answer.jpg'),
    (38, 10, 'Bay Bridge', false, 'https://example.com/bay-bridge.jpg'),
    (39, 10, 'Alcatraz Island', false, 'https://example.com/alcatraz.jpg'),
    (40, 10, 'Lombard Street', false, 'https://example.com/lombard-street.jpg');