DROP DATABASE IF EXISTS currency;
CREATE DATABASE currency;
USE currency;

CREATE TABLE CURRENCY (
    id INT NOT NULL AUTO_INCREMENT,
    abbreviation VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    conversion_rate_to_usd DECIMAL(10, 5) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO CURRENCY (abbreviation, name, conversion_rate_to_usd) VALUES
    ('USD', 'US Dollar', 1.0000),
    ('EUR', 'Euro', 1.1814),
    ('GBP', 'British Pound Sterling', 1.3486),
    ('JPY', 'Japanese Yen', 0.0064),
    ('CHF', 'Swiss Franc', 1.3007),
    ('CAD', 'Canadian Dollar', 0.7329),
    ('AUD', 'Australian Dollar', 0.7116),
    ('RUB', 'Russian Ruble', 0.01294);

DROP USER IF EXISTS 'appuser'@'localhost';

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT ON currency.currency TO 'appuser'@'localhost';