CREATE SEQUENCE account_seq start with 1 increment by 50;
CREATE TABLE Account(
    id      int8   PRIMARY KEY,
    customer_id int8,
    number  INTEGER     NOT NULL,
    balance INTEGER,
    FOREIGN KEY (customer_id) REFERENCES Customer(id)
);