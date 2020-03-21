CREATE TABLE pit
(
    id        SERIAL PRIMARY KEY,
    latitude  DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    category  INTEGER          NOT NULL
);

ALTER TABLE pit
    OWNER TO postgres;

