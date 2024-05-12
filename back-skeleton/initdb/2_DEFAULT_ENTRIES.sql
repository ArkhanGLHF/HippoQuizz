INSERT INTO users (username,email, password) VALUES ('Mehdiabrk', 'mehdi.aberkane@edu.ece.fr', 'Amdin0001');
INSERT INTO users (username,email, password) VALUES ('Arkahn',  'hipplyte.cacheux@edu.ece.fr', 'Admin0002');
INSERT INTO users (username,email, password) VALUES ('Adrien', 'adrien.mattei@edu.ece.fr', 'Admin0003');
INSERT INTO users (username,email, password) VALUES ('test', 'test@edu.ece.fr', 'test');


INSERT INTO quiz (title, description)
VALUES
    ('Le Règne Animal', 'Ce quiz teste vos connaissances sur les animaux'),
    ('Géographie Mondiale', 'Ce quiz évalue vos connaissances géographiques'),
    ('Faits Historiques', 'Ce quiz porte sur l''histoire mondiale'),
    ('Progrès Technologiques', 'Ce quiz évalue vos connaissances en technologie'),
    ('Santé et Bien-être', 'Ce quiz porte sur la santé et le bien-être');


INSERT INTO questions (quiz_id, question_text,question_answer)
VALUES
    (1, 'L''éléphant est le plus gros animal terrestre.', TRUE),
    (1, 'Le guépard est l''animal le plus rapide au monde.', TRUE),
    (1, 'Le mamba noir est l''animal le plus venimeux.', TRUE),
    (1, 'Les baleines sont des mammifères.', TRUE),
    (1, 'Les araignées ont 8 pattes.', TRUE),
    (1, 'Les poissons respirent par les branchies.', TRUE),
    (1, 'Les lions vivent en groupe appelé "troupeau".', TRUE),
    (1, 'Les serpents sont ovipares.', TRUE),
    (1, 'Les koalas sont des mammifères.', TRUE),
    (1, 'Les papillons ont 6 pattes.', FALSE),
    (2, 'Canberra est la capitale de l''Australie.', TRUE),
    (2, 'Le Pacifique est le plus grand océan du monde.', TRUE),
    (2, 'L''Everest est le plus haut sommet du monde.', TRUE),
    (2, 'La Chine est le pays le plus peuplé du monde.', TRUE),
    (2, 'Le Nil est le plus long fleuve du monde.', TRUE),
    (2, 'L''Antarctique est un continent.', TRUE),
    (2, 'Le Sahara est le plus grand désert du monde.', TRUE),
    (2, 'Le Japon est une île.', TRUE),
    (2, 'La Méditerranée est un océan.', FALSE),
    (2, 'Le Canada est le plus grand pays du monde en superficie.', FALSE),
    (3, 'La Première Guerre mondiale a eu lieu en 1914.', TRUE),
    (3, 'George Washington a été le premier président des États-Unis.', TRUE),
    (3, 'La Révolution française a eu lieu en 1789.', TRUE),
    (3, 'Napoléon Bonaparte a été empereur de France.', TRUE),
    (3, 'La Seconde Guerre mondiale a duré de 1939 à 1945.', TRUE),
    (3, 'Christophe Colomb a découvert l''Amérique en 1492.', TRUE),
    (3, 'La Chute de l''Empire romain d''Occident a eu lieu en 476.', TRUE),
    (3, 'La Guerre de Sécession s''est déroulée aux États-Unis.', TRUE),
    (3, 'La Révolution industrielle a commencé au 18ème siècle.', TRUE),
    (3, 'La Guerre froide a opposé les États-Unis et l''URSS.', TRUE),
    (4, 'L''ordinateur a été inventé dans les années 1970.', FALSE),
    (4, 'Internet a été créé par Tim Berners-Lee.', TRUE),
    (4, 'Le premier smartphone a été lancé par Apple.', TRUE),
    (4, 'Le système d''exploitation Windows a été développé par Microsoft.', TRUE),
    (4, 'Le langage de programmation Python a été créé en 1991.', TRUE),
    (4, 'Le disque dur a remplacé les disquettes.', TRUE),
    (4, 'Le GPS utilise des satellites pour localiser les utilisateurs.', TRUE),
    (4, 'La 5G est une technologie plus rapide que la 4G.', TRUE),
    (4, 'L''intelligence artificielle peut prendre des décisions autonomes.', TRUE),
    (4, 'Les réseaux sociaux ont été inventés dans les années 2000.', TRUE),
    (5, 'Le cœur est un organe vital.', TRUE),
    (5, 'Le paludisme est une maladie causée par un virus.', TRUE),
    (5, 'Le cancer est une maladie non contagieuse.', TRUE),
    (5, 'Le vaccin protège contre les maladies infectieuses.', TRUE),
    (5, 'Le diabète est une maladie chronique.', TRUE),
    (5, 'Le sommeil est important pour la santé.',TRUE),
    (5, 'L''exercice physique n''a pas d''impact sur la santé.', FALSE),
    (5, 'L''hypertension artérielle est un problème cardiaque.', TRUE),
    (5, 'La grippe est causée par une bactérie.', FALSE),
    (5, 'Une alimentation équilibrée est bénéfique pour la santé.', TRUE);


INSERT INTO results (user_id, quiz_id, score, date_completed)
VALUES
    (1, 1, 8, '2024-04-27'),
    (2, 2, 7, '2024-04-26'),
    (3, 3, 9, '2024-04-25'),
    (1, 4, 8, '2024-04-24'),
    (2, 5, 9, '2024-04-23');



INSERT INTO results (user_id, quiz_id, score, date_completed)
VALUES
    (4, 3, 9, '2024-04-25'),
    (4, 4, 8, '2024-04-24'),
    (4, 5, 9, '2024-04-23');
