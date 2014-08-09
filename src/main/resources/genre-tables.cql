CREATE KEYSPACE genre WITH replication = {
    'class': 'SimpleStrategy', 'replication_factor': 3
    };

USE genre;


CREATE TABLE genres_by_name (
    genre text,
    id UUID,
    PRIMARY KEY(genre)
);


