CREATE SEQUENCE role_seq start with 1 increment by 50;
CREATE SEQUENCE customer_seq start with 1 increment by 50;

CREATE TABLE Role(
    id      INTEGER   PRIMARY KEY,
    name    VARCHAR(50)     NOT NULL
);

CREATE TABLE Customer(
    id          int8   PRIMARY KEY,
    firstname   VARCHAR(50)    NOT NULL,
    lastname    VARCHAR(50)    NOT NULL,
    age         INTEGER     NOT NULL,
    email       VARCHAR(150)    NOT NULL,
    role_id     INTEGER,
    FOREIGN KEY (role_id) REFERENCES Role(id)
);