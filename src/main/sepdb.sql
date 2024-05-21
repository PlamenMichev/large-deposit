



CREATE SCHEMA bank;
SET SCHEMA 'bank';
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    cpr_number VARCHAR(10),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    date_of_birth TIMESTAMP,
    role int,
    address VARCHAR(50),
    city VARCHAR(40),
    postal_code VARCHAR(10),
    phone_number VARCHAR(10),
    email VARCHAR(50),
    password VARCHAR(100),
    is_verified BOOLEAN,
    created_at TIMESTAMP
);

CREATE TABLE accounts(
    number VARCHAR(10),
    registration VARCHAR(4),
    user_id INT ,
    title VARCHAR(20),
    iban VARCHAR(34),
    balance DECIMAL,
    currency VARCHAR(15),
    is_active BOOLEAN,
    deactivation_reason VARCHAR(100),
    created_at TIMESTAMP,
    PRIMARY KEY(number, registration),
    FOREIGN KEY(user_id) REFERENCES users
);

CREATE TABLE credit_accounts(
    number VARCHAR(10),
    registration VARCHAR(4),
    user_id INT,
    title VARCHAR(20),
    iban VARCHAR(34),
    balance DECIMAL,
    currency VARCHAR(15),
    credit_limit DECIMAL,
    is_active BOOLEAN,
    deactivation_reason VARCHAR(100),
    created_at TIMESTAMP,
    PRIMARY KEY(number, registration),
    FOREIGN KEY(number, registration) REFERENCES accounts,
    FOREIGN KEY(user_id) REFERENCES users
);

CREATE TABLE savings_accounts(
    number VARCHAR(10),
    registration VARCHAR(4),
    user_id INT,
    title VARCHAR(20),
    iban VARCHAR(34),
    balance DECIMAL,
    currency VARCHAR(15),
    interest_rate DOUBLE PRECISION,
    interest_payment_period_months INT,
    last_payment_date TIMESTAMP,
    is_active BOOLEAN,
    deactivation_reason VARCHAR(100),
    created_at TIMESTAMP,
    PRIMARY KEY(number, registration),
    FOREIGN KEY(number, registration) REFERENCES accounts,
    FOREIGN KEY(user_id) REFERENCES users
);

CREATE TABLE transactions(
    id SERIAL PRIMARY KEY,
    amount DECIMAL,
    created_at TIMESTAMP,
    created_by INT,
    sending_account_number VARCHAR(14),
    sending_account_registration VARCHAR(14),
    receiving_account_number VARCHAR(14),
    receiving_account_registration VARCHAR(14),
    description varchar(150),
    is_approved BOOLEAN,
    approved_by INT,
    status VARCHAR(15),
    FOREIGN KEY(created_by) REFERENCES users(id),
    FOREIGN KEY(sending_account_number, sending_account_registration)
        REFERENCES accounts(number, registration),
    FOREIGN KEY(receiving_account_number, receiving_account_registration)
        REFERENCES accounts(number, registration),
    FOREIGN KEY(approved_by) REFERENCES users(id)
);


INSERT INTO users VALUES(DEFAULT, '1111111111', 'Adam', 'Smith', '06/02/1989', 0, 'Kamtjatka', 'Horsens', '8700', '3333333333', 'admin@email.com', 'password1', TRUE, '12/10/2000');
INSERT INTO users VALUES(DEFAULT, '2222222222', 'Alexander', 'Johnson', '09/10/1999', 0, 'Slotsgade', 'Horsens', '8700', '3597654871', 'admin22@email.com', 'password90', TRUE, '01/01/2010');
