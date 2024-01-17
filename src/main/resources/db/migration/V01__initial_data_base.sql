--Starting of the database, keep the default for new tables.
CREATE TABLE tb_evaluation
(
    id           UUID PRIMARY KEY,
    email        VARCHAR(255) UNIQUE NOT NULL,
    rating       INTEGER,
    observations VARCHAR(255),
    contact_info  VARCHAR(25),
    created_at   TIMESTAMP
);