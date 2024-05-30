CREATE SCHEMA bank;
SET SCHEMA 'bank';
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    cpr_number VARCHAR(10) UNIQUE NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    date_of_birth TIMESTAMP NOT NULL,
    role VARCHAR(40) CHECK (role IN ('Admin', 'User')),
    address VARCHAR(50) NOT NULL,
    city VARCHAR(40) NOT NULL,
    postal_code VARCHAR(10) NOT NULL,
    phone_number VARCHAR(10) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    is_verified BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE accounts(
    number VARCHAR(10),
    registration VARCHAR(4),
    user_id INT NOT NULL ,
    title VARCHAR(20) NOT NULL,
    iban VARCHAR(34) UNIQUE NOT NULL,
    balance DECIMAL CHECK (balance >= 0),
    currency VARCHAR(15) NOT NULL,
    is_active BOOLEAN NOT NULL,
    deactivation_reason VARCHAR(100),
    created_at TIMESTAMP NOT NULL,
PRIMARY KEY(number, registration),
FOREIGN KEY(user_id) REFERENCES users
);

CREATE TABLE credit_accounts(
     number VARCHAR(10),
    registration VARCHAR(4),
    user_id INT NOT NULL,
    title VARCHAR(20) NOT NULL,
    iban VARCHAR(34) UNIQUE NOT NULL,
    balance DECIMAL CHECK (balance >=0 ),
    currency VARCHAR(15) NOT NULL,
    credit_limit DECIMAL CHECK (credit_limit >= 0),
    is_active BOOLEAN NOT NULL,
    deactivation_reason VARCHAR(100),
    created_at TIMESTAMP NOT NULL,
PRIMARY KEY(number, registration),
FOREIGN KEY(number, registration) REFERENCES accounts,
FOREIGN KEY(user_id) REFERENCES users
);

CREATE TABLE savings_accounts(
    number VARCHAR(10),
    registration VARCHAR(4),
    user_id INT NOT NULL,
    title VARCHAR(20) NOT NULL,
    iban VARCHAR(34) UNIQUE NOT NULL,
    balance DECIMAL CHECK (BALANCE >= 0),
    currency VARCHAR(15) NOT NULL,
   interest_rate DOUBLE PRECISION CHECK (interest_rate BETWEEN 0.03 and 0.1),
    interest_payment_period_months INT CHECK (interest_payment_period_months BETWEEN 3 AND 72),
    last_payment_date TIMESTAMP,
    is_active BOOLEAN NOT NULL,
    deactivation_reason VARCHAR(100),
    created_at TIMESTAMP NOT NULL,
PRIMARY KEY(number, registration),
FOREIGN KEY(number, registration) REFERENCES accounts,
FOREIGN KEY(user_id) REFERENCES users
);

CREATE TABLE transactions(
    id SERIAL PRIMARY KEY,
    amount DECIMAL CHECK (amount >= 10),
    created_at TIMESTAMP NOT NULL,
    created_by INT NOT NULL,
    sending_account_number VARCHAR(14) NOT NULL,
    sending_account_registration VARCHAR(14) NOT NULL,
    receiving_account_number VARCHAR(14) NOT NULL,
    receiving_account_registration VARCHAR(14) NOT NULL,
    description varchar(150),
    is_approved BOOLEAN NOT NULL,
    approved_by INT,
    status VARCHAR(15) NOT NULL,
    FOREIGN KEY(created_by) REFERENCES users(id),
    FOREIGN KEY(sending_account_number, sending_account_registration)
        REFERENCES accounts(number, registration),
    FOREIGN KEY(receiving_account_number, receiving_account_registration)
        REFERENCES accounts(number, registration),
    FOREIGN KEY(approved_by) REFERENCES users(id)
);

INSERT INTO users VALUES(DEFAULT, '1111111111', 'Adam', 'Smith', '06/02/1989', 'Admin', 'Kamtjatka', 'Horsens', '8700', '3333333333', 'admin@email.com', 'password1', TRUE, '12/10/2000');
INSERT INTO users VALUES(DEFAULT, '2222222222', 'Alexander', 'Johnson', '09/10/1999', 'Admin', 'Slotsgade', 'Horsens', '8700', '3597654871', 'admin22@email.com', 'password90', TRUE, '01/01/2010');