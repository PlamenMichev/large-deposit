create schema bank;
set schema 'bank';
create table users (
    id serial primary key,
    cpr_number varchar(10),
    first_name varchar(100),
    last_name varchar(100),
    date_of_birth timestamp,
    role varchar(40),
    address varchar(50),
    city varchar(40),
    postal_code varchar(10),
    phone_number varchar(10),
    email varchar(50),
    password varchar(100),
    is_verified boolean,
    created_at timestamp,
);

create table accounts(
    number varchar(10),
    registration varchar(4),
    user_id int ,
    title varchar(20),
    iban varchar(34),
    balance decimal,
    currency varchar(15),
    is_active boolean,
    deactivation_reason varchar(100),
    created_at timestamp,
    primary key(number, registration),
    foreign key(user_id) references users,
);

create table credit_accounts(
    number varchar(10),
    registration varchar(4),
    user_id int,
    title varchar(20),
    iban varchar(34),
    balance decimal,
    currency varchar(15),
    credit_limit decimal,
    is_active boolean,
    deactivation_reason varchar(100),
    created_at timestamp,
    primary key(number, registration),
    foreign key(number, registration) references accounts,
    foreign key(user_id) references users,
);

create table savings_accounts(
    number varchar(10),
    registration varchar(4),
    user_id int,
    title varchar(20),
    iban varchar(34),
    balance decimal,
    currency varchar(15),
    interest_rate double precision,
    interest_payment_period_months int,
    last_payment_date timestamp,
    is_active boolean,
    deactivation_reason varchar(100),
    created_at timestamp,
    primary key(number, registration),
    foreign key(number, registration) references accounts,
    foreign key(user_id) references users,
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
    FOREIGN KEY(approved_by) REFERENCES users(id),
);
