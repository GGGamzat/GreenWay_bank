CREATE SEQUENCE article_seq start with 1 increment by 50;
CREATE TABLE Article(
    id      int8  PRIMARY KEY,
    title   VARCHAR(150)    NOT NULL,
    text    TEXT
)