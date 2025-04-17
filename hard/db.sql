CREATE DATABASE school_db;

USE school_db;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    date DATE,
    status ENUM('Present', 'Absent')
);
