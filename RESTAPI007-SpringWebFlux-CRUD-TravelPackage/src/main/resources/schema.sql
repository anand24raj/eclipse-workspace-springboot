CREATE TABLE IF NOT EXISTS travel_package (
    package_id INT AUTO_INCREMENT PRIMARY KEY,
    package_name VARCHAR(255) NOT NULL,
    destination VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    duration INT NOT NULL
);