CREATE SEQUENCE account_seq start with 1 increment by 50;
CREATE SEQUENCE transaction_seq start with 1 increment by 50;

CREATE TABLE Account(
    id      int8   PRIMARY KEY,
    usr_id int8,
    number  INTEGER     NOT NULL,
    balance INTEGER,
    FOREIGN KEY (usr_id) REFERENCES usr(id)
);

CREATE TABLE Transaction(
    id      int8    PRIMARY KEY,
    amount  INTEGER     NOT NULL,
    account_from_id  int8,
    account_to_id  int8,
    FOREIGN KEY (account_from_id) REFERENCES account(id),
    FOREIGN KEY (account_to_id) REFERENCES account(id),
    date    DATE
);