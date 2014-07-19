CREATE KEYSPACE test WITH replication = {
    'class': 'SimpleStrategy', 'replication_factor': 1
    };

USE test;


CREATE TABLE genres_by_name (
    genre text,
    id UUID,
    PRIMARY KEY(name)
);


