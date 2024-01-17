CREATE TABLE Customer(
    id          SERIAL   PRIMARY KEY,
    firstName   VARCHAR(50)    NOT NULL,
    lastName    VARCHAR(50)    NOT NULL,
    age         INTEGER     NOT NULL,
    role_id     INTEGER,
    FOREIGN KEY (role_id) REFERENCES Role(id)
);

CREATE TABLE Role(
    id      SERIAL   PRIMARY KEY,
    name    VARCHAR(50)     NOT NULL
);

CREATE TABLE Account(
    id      SERIAL   PRIMARY KEY,
    customer_id INTEGER,
    number  INTEGER     NOT NULL,
    balance INTEGER,
    FOREIGN KEY (customer_id) REFERENCES Customer(id)
);