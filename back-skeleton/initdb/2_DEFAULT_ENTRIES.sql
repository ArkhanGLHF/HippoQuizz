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

INSERT INTO quiz (id, title, description)
VALUES
    (1, 'Le Règne Animal', 'Ce quiz teste vos connaissances sur les animaux'),
    (2, 'Géographie Mondiale', 'Ce quiz évalue vos connaissances géographiques'),
    (3, 'Faits Historiques', 'Ce quiz porte sur l''histoire mondiale'),
    (4, 'Progrès Technologiques', 'Ce quiz évalue vos connaissances en technologie'),
    (5, 'Santé et Bien-être', 'Ce quiz porte sur la santé et le bien-être');


INSERT INTO questions (id, quiz_id, question_text, question_picture, question_answer)
VALUES
    (1, 1, 'L''éléphant est le plus gros animal terrestre.', '', TRUE),
    (2, 1, 'Le guépard est l''animal le plus rapide au monde.', '', TRUE),
    (3, 1, 'Le mamba noir est l''animal le plus venimeux.', '', TRUE),
    (4, 1, 'Les baleines sont des mammifères.', '', TRUE),
    (5, 1, 'Les araignées ont 8 pattes.', '', TRUE),
    (6, 1, 'Les poissons respirent par les branchies.', '', TRUE),
    (7, 1, 'Les lions vivent en groupe appelé "troupeau".', '', TRUE),
    (8, 1, 'Les serpents sont ovipares.', '', TRUE),
    (9, 1, 'Les koalas sont des mammifères.', '', TRUE),
    (10, 1, 'Les papillons ont 6 pattes.', '', FALSE),
    (11, 2, 'Canberra est la capitale de l''Australie.', '', TRUE),
    (12, 2, 'Le Pacifique est le plus grand océan du monde.', '', TRUE),
    (13, 2, 'L''Everest est le plus haut sommet du monde.', '', TRUE),
    (14, 2, 'La Chine est le pays le plus peuplé du monde.', '', TRUE),
    (15, 2, 'Le Nil est le plus long fleuve du monde.', '', TRUE),
    (16, 2, 'L''Antarctique est un continent.', '', TRUE),
    (17, 2, 'Le Sahara est le plus grand désert du monde.', '', TRUE),
    (18, 2, 'Le Japon est une île.', '', TRUE),
    (19, 2, 'La Méditerranée est un océan.', '', FALSE),
    (20, 2, 'Le Canada est le plus grand pays du monde en superficie.', '', FALSE),
    (21, 3, 'La Première Guerre mondiale a eu lieu en 1914.', '', TRUE),
    (22, 3, 'George Washington a été le premier président des États-Unis.', '', TRUE),
    (23, 3, 'La Révolution française a eu lieu en 1789.', '', TRUE),
    (24, 3, 'Napoléon Bonaparte a été empereur de France.', '', TRUE),
    (25, 3, 'La Seconde Guerre mondiale a duré de 1939 à 1945.', '', TRUE),
    (26, 3, 'Christophe Colomb a découvert l''Amérique en 1492.', '', TRUE),
    (27, 3, 'La Chute de l''Empire romain d''Occident a eu lieu en 476.', '', TRUE),
    (28, 3, 'La Guerre de Sécession s''est déroulée aux États-Unis.', '', TRUE),
    (29, 3, 'La Révolution industrielle a commencé au 18ème siècle.', '', TRUE),
    (30, 3, 'La Guerre froide a opposé les États-Unis et l''URSS.', '', TRUE),
    (31, 4, 'L''ordinateur a été inventé dans les années 1970.', '', FALSE),
    (32, 4, 'Internet a été créé par Tim Berners-Lee.', '', TRUE),
    (33, 4, 'Le premier smartphone a été lancé par Apple.', '', TRUE),
    (34, 4, 'Le système d''exploitation Windows a été développé par Microsoft.', '', TRUE),
    (35, 4, 'Le langage de programmation Python a été créé en 1991.', '', TRUE),
    (36, 4, 'Le disque dur a remplacé les disquettes.', '', TRUE),
    (37, 4, 'Le GPS utilise des satellites pour localiser les utilisateurs.', '', TRUE),
    (38, 4, 'La 5G est une technologie plus rapide que la 4G.', '', TRUE),
    (39, 4, 'L''intelligence artificielle peut prendre des décisions autonomes.', '', TRUE),
    (40, 4, 'Les réseaux sociaux ont été inventés dans les années 2000.', '', TRUE),
    (41, 5, 'Le cœur est un organe vital.', '', TRUE),
    (42, 5, 'Le paludisme est une maladie causée par un virus.', '', TRUE),
    (43, 5, 'Le cancer est une maladie non contagieuse.', '', TRUE),
    (44, 5, 'Le vaccin protège contre les maladies infectieuses.', '', TRUE),
    (45, 5, 'Le diabète est une maladie chronique.', '', TRUE),
    (46, 5, 'Le sommeil est important pour la santé.', '', TRUE),
    (47, 5, 'L''exercice physique n''a pas d''impact sur la santé.', '', FALSE),
    (48, 5, 'L''hypertension artérielle est un problème cardiaque.', '', TRUE),
    (49, 5, 'La grippe est causée par une bactérie.', '', FALSE),
    (50, 5, 'Une alimentation équilibrée est bénéfique pour la santé.', '', TRUE);


INSERT INTO results (id, user_id, quiz_id, score, date_completed)
VALUES
    (1, 1, 1, 8, '2024-04-27'),
    (2, 2, 2, 7, '2024-04-26'),
    (3, 3, 3, 9, '2024-04-25'),
    (4, 1, 4, 8, '2024-04-24'),
    (5, 2, 5, 9, '2024-04-23');


