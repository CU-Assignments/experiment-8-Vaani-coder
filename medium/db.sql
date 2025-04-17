CREATE DATABASE company_db;

USE company_db;

CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100)
);

INSERT INTO employees VALUES 
(1, 'John Doe', 'HR'), 
(2, 'Jane Smith', 'IT');
