CREATE DATABASE IF NOT EXISTS currency;
CREATE USER IF NOT EXISTS 'appuser'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE ON currency.* TO 'appuser'@'localhost';
GRANT CREATE, DROP, ALTER ON currency.* TO 'appuser'@'localhost';
