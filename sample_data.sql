USE quiz_application;

-- -------------------------------------------------------------------
-- 1) Insert Users
-- -------------------------------------------------------------------
INSERT INTO User (email, password, firstname, lastname, is_active, is_admin)
VALUES
    ('admin@example.com', 'adminpass', 'Admin', 'User', TRUE, TRUE),
    ('AAA@example.com', 'passwordAAA', 'AAA', 'Test', TRUE, FALSE),
    ('BBB@example.com', 'passwordBBB', 'BBB', 'Test', TRUE, FALSE),
    ('suspended.user@example.com', 'password', 'Suspended', 'User', FALSE, FALSE);

-- -------------------------------------------------------------------
-- 2) Insert Categories
-- -------------------------------------------------------------------
INSERT INTO Category (name, description, is_active)
VALUES
    ('Science', 'Questions about science concepts', TRUE),
    ('Music', 'Questions about music concepts', TRUE),
    ('Math',    'Questions about mathematics', TRUE);

-- -------------------------------------------------------------------
-- 3) Insert Questions & Choices for Each Category
-- -------------------------------------------------------------------

-- 3.1) SCIENCE QUESTIONS
-- Q1
INSERT INTO Question (category_id, description, is_active)
VALUES (1, 'What is the chemical symbol for water?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), 'H2O', TRUE),
    (LAST_INSERT_ID(), 'CO2', FALSE),
    (LAST_INSERT_ID(), 'O2',  FALSE),
    (LAST_INSERT_ID(), 'NaCl',FALSE);

-- Q2
INSERT INTO Question (category_id, description, is_active)
VALUES (1, 'What planet is known as the Red Planet?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), 'Mars', TRUE),
    (LAST_INSERT_ID(), 'Jupiter', FALSE),
    (LAST_INSERT_ID(), 'Venus', FALSE),
    (LAST_INSERT_ID(), 'Saturn', FALSE);

-- Q3
INSERT INTO Question (category_id, description, is_active)
VALUES (1, 'Which gas do plants absorb from the atmosphere?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), 'Carbon Dioxide', TRUE),
    (LAST_INSERT_ID(), 'Oxygen',          FALSE),
    (LAST_INSERT_ID(), 'Nitrogen',        FALSE),
    (LAST_INSERT_ID(), 'Hydrogen',        FALSE);

-- Q4
INSERT INTO Question (category_id, description, is_active)
VALUES (1, 'What is the center of an atom called?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), 'Nucleus', TRUE),
    (LAST_INSERT_ID(), 'Electron',FALSE),
    (LAST_INSERT_ID(), 'Neutron', FALSE),
    (LAST_INSERT_ID(), 'Proton',  FALSE);

-- Q5
INSERT INTO Question (category_id, description, is_active)
VALUES (1, 'What force keeps us on the ground?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), 'Gravity', TRUE),
    (LAST_INSERT_ID(), 'Magnetism', FALSE),
    (LAST_INSERT_ID(), 'Friction',  FALSE),
    (LAST_INSERT_ID(), 'Electricity',FALSE);

-- 3.2) MUSIC QUESTIONS
-- Q1
INSERT INTO Question (category_id, description, is_active)
VALUES (2, 'Which artist is known as the "King of Pop"?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), 'Michael Jackson',   TRUE),
    (LAST_INSERT_ID(), 'Elvis Presley', FALSE),
    (LAST_INSERT_ID(), 'Justin Timberlake',  FALSE),
    (LAST_INSERT_ID(), 'Bruno Mars',        FALSE);

-- Q2
INSERT INTO Question (category_id, description, is_active)
VALUES (2, 'Which band released the hit song “Bohemian Rhapsody”?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), 'Queen', TRUE),
    (LAST_INSERT_ID(), 'The Beatles', FALSE),
    (LAST_INSERT_ID(), 'Nirvana', FALSE),
    (LAST_INSERT_ID(), 'U2', FALSE);

-- Q3
INSERT INTO Question (category_id, description, is_active)
VALUES (2, 'Who is the lead singer of the band Coldplay?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), 'Chris Martin',  TRUE),
    (LAST_INSERT_ID(), 'Adam Levine',     FALSE),
    (LAST_INSERT_ID(), 'Ed Sheeran',     FALSE),
    (LAST_INSERT_ID(), 'Harry Styles',     FALSE);

-- Q4
INSERT INTO Question (category_id, description, is_active)
VALUES (2, 'What musical instrument has 88 keys?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), 'Piano', TRUE),
    (LAST_INSERT_ID(), 'Guitar',FALSE),
    (LAST_INSERT_ID(), 'Violin',     FALSE),
    (LAST_INSERT_ID(), 'Flute',    FALSE);

-- Q5
INSERT INTO Question (category_id, description, is_active)
VALUES (2, 'Which female artist released the album “1989”?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), 'Taylor Swift',   TRUE),
    (LAST_INSERT_ID(), 'Ariana Grande', FALSE),
    (LAST_INSERT_ID(), 'Beyoncé', FALSE),
    (LAST_INSERT_ID(), 'Adele',   FALSE);

-- 3.3) MATH QUESTIONS
-- Q1
INSERT INTO Question (category_id, description, is_active)
VALUES (3, 'What is 7 + 8?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), '15', TRUE),
    (LAST_INSERT_ID(), '14', FALSE),
    (LAST_INSERT_ID(), '13', FALSE),
    (LAST_INSERT_ID(), '16', FALSE);

-- Q2
INSERT INTO Question (category_id, description, is_active)
VALUES (3, 'What is the value of π (pi) rounded to two decimal places?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), '3.14', TRUE),
    (LAST_INSERT_ID(), '3.15', FALSE),
    (LAST_INSERT_ID(), '3.13', FALSE),
    (LAST_INSERT_ID(), '3.16', FALSE);

-- Q3
INSERT INTO Question (category_id, description, is_active)
VALUES (3, 'What is the square root of 144?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), '12', TRUE),
    (LAST_INSERT_ID(), '11', FALSE),
    (LAST_INSERT_ID(), '14', FALSE),
    (LAST_INSERT_ID(), '10', FALSE);

-- Q4
INSERT INTO Question (category_id, description, is_active)
VALUES (3, 'What is 9 × 9?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), '81', TRUE),
    (LAST_INSERT_ID(), '79', FALSE),
    (LAST_INSERT_ID(), '72', FALSE),
    (LAST_INSERT_ID(), '90', FALSE);

-- Q5
INSERT INTO Question (category_id, description, is_active)
VALUES (3, 'What is the derivative of x^2?', TRUE);
INSERT INTO Choice (question_id, description, is_correct)
VALUES
    (LAST_INSERT_ID(), '2x', TRUE),
    (LAST_INSERT_ID(), 'x',  FALSE),
    (LAST_INSERT_ID(), 'x^2',FALSE),
    (LAST_INSERT_ID(), '2',  FALSE);

-- -------------------------------------------------------------------
-- 4) Insert One Sample Quiz and Its QuizQuestion Rows
-- -------------------------------------------------------------------
-- Create a quiz for AAA Test (user_id = 2) in Science (category_id = 1)
INSERT INTO Quiz (user_id, category_id, name, status, score, total_questions)
VALUES (2, 1, 'AAA''s Science Quiz', 'COMPLETED', 4, 5);

-- Assume the generated quiz_id is 1 (adjust if necessary)
-- Link five questions to this quiz with user choices and correctness
INSERT INTO QuizQuestion (quiz_id, question_id, user_choice_id, is_correct)
VALUES
    (1,  1,  1, TRUE),   -- Q1, choice_id = 1 (H2O), correct
    (1,  2,  5, TRUE),   -- Q2, choice_id = 6 (Mars), correct
    (1,  3,  9, TRUE),  -- Q3, choice_id = 10 (Carbon Dioxide), correct
    (1,  4,  14, FALSE), -- Q4, choice_id = 14 (Electron), wrong
    (1,  5,  17, TRUE);  -- Q5, choice_id = 17 (Gravity), correct

-- (Note: choice_id numbers correspond to order of LAST_INSERT_ID calls above:
--   Q1→ choice_id1..4, Q2→ 5..8, Q3→ 9..12, Q4→ 13..16, Q5→ 17..20)

-- -------------------------------------------------------------------
-- 5) Insert Sample Contact Messages
-- -------------------------------------------------------------------
INSERT INTO Contact (subject, message, email)
VALUES
    ('Site Feedback', 'Great quiz game lolol!', 'feedback@example.com'),
    ('Bug Report',     'I encountered an error on the Music quiz question.', 'bugreport@example.com');