create TABLE people (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    family_name VARCHAR(50) NOT NULL,
    birth_year INT,
    birth_month INT,
    birth_day INT
);