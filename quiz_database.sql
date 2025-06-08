-- quiz-application/quiz_database.sql
-- Create the database by open this .sql file in MySQL Workbench and execute it
-- or you can run this manually in your MySQL client:
--     ``` SOURCE /path/to/quiz-application/quiz_database.sql; ```

-- 1) Database Creation
CREATE DATABASE IF NOT EXISTS quiz_application;
USE quiz_application;

-- 2) User Table
CREATE TABLE IF NOT EXISTS User (
    user_id    INT PRIMARY KEY AUTO_INCREMENT,
    email      VARCHAR(255) UNIQUE NOT NULL,
    password   VARCHAR(255) NOT NULL,
    firstname  VARCHAR(100) NOT NULL,
    lastname   VARCHAR(100) NOT NULL,
    is_active  BOOLEAN DEFAULT TRUE,
    is_admin   BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- 3) Category Table
CREATE TABLE IF NOT EXISTS Category (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL UNIQUE,
    description TEXT,
    is_active   BOOLEAN DEFAULT TRUE
    );

-- 4) Question Table
CREATE TABLE IF NOT EXISTS Question (
    question_id INT PRIMARY KEY AUTO_INCREMENT,
    category_id INT NOT NULL,
    description TEXT NOT NULL,
    is_active   BOOLEAN DEFAULT TRUE,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id)
        REFERENCES Category(category_id)
    );

-- 5) Choice Table
CREATE TABLE IF NOT EXISTS Choice (
    choice_id   INT PRIMARY KEY AUTO_INCREMENT,
    question_id INT NOT NULL,
    description TEXT NOT NULL,
    is_correct  BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (question_id)
        REFERENCES Question(question_id)
        ON DELETE CASCADE
    );

-- 6) Quiz Table
CREATE TABLE IF NOT EXISTS Quiz (
    quiz_id       INT PRIMARY KEY AUTO_INCREMENT,
    user_id       INT NOT NULL,
    category_id   INT NOT NULL,
    name          VARCHAR(255) NOT NULL,
    time_start    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    time_end      TIMESTAMP NULL,
    status        ENUM('IN_PROGRESS','COMPLETED') DEFAULT 'IN_PROGRESS',
    score         INT DEFAULT 0,
    total_questions INT DEFAULT 0,
    FOREIGN KEY (user_id)
        REFERENCES User(user_id),
    FOREIGN KEY (category_id)
        REFERENCES Category(category_id)
    );

-- 7) QuizQuestion Table (junction)
CREATE TABLE IF NOT EXISTS QuizQuestion (
    qq_id          INT PRIMARY KEY AUTO_INCREMENT,
    quiz_id        INT NOT NULL,
    question_id    INT NOT NULL,
    user_choice_id INT NULL,
    is_correct     BOOLEAN NULL,
    FOREIGN KEY (quiz_id)
        REFERENCES Quiz(quiz_id)
        ON DELETE CASCADE,
    FOREIGN KEY (question_id)
        REFERENCES Question(question_id),
    FOREIGN KEY (user_choice_id)
        REFERENCES Choice(choice_id)
    );

-- 8) Contact Table
CREATE TABLE IF NOT EXISTS Contact (
    contact_id INT PRIMARY KEY AUTO_INCREMENT,
    subject    VARCHAR(255) NOT NULL,
    message    TEXT NOT NULL,
    email      VARCHAR(255) NOT NULL,
    time       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_read    BOOLEAN DEFAULT FALSE
    );
