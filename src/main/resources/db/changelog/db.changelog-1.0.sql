-- liquibase formatted sql

-- changeset iglaz:1
CREATE TABLE IF NOT EXISTS users
(
    id         BIGSERIAL PRIMARY KEY,
    birth_date DATE         NOT NULL,
    city       VARCHAR(64)  NOT NULL,
    email      VARCHAR(64)  NOT NULL,
    firstname  VARCHAR(32)  NOT NULL,
    lastname   VARCHAR(32)  NOT NULL,
    password   VARCHAR(255) NOT NULL,
    role       VARCHAR(32)  NOT NULL
);

-- changeset iglaz:2
CREATE TABLE IF NOT EXISTS teacher
(
    id BIGSERIAL PRIMARY KEY REFERENCES users (id)
);

-- changeset iglaz:3
CREATE TABLE IF NOT EXISTS groups
(
    id         BIGSERIAL PRIMARY KEY,
    course     VARCHAR(32) NOT NULL,
    finish     DATE,
    name       VARCHAR(64) NOT NULL,
    start      DATE,
    teacher_id BIGINT REFERENCES teacher (id)
);

-- changeset iglaz:4
CREATE TABLE IF NOT EXISTS student
(
    id          BIGSERIAL PRIMARY KEY REFERENCES users (id),
    groups_id   BIGINT REFERENCES groups (id),
    total_grade REAL
);

-- changeset iglaz:5
CREATE TABLE IF NOT EXISTS lesson
(
    id        BIGSERIAL PRIMARY KEY,
    date_time TIMESTAMP,
    subject   VARCHAR(255) NOT NULL
);

-- changeset iglaz:6
CREATE TABLE IF NOT EXISTS homework
(
    id          BIGSERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    file        VARCHAR(255),
    date        DATE,
    lesson_id   BIGINT REFERENCES lesson (id)
);

-- changeset iglaz:7
CREATE TABLE IF NOT EXISTS log
(
    id          BIGSERIAL PRIMARY KEY,
    date_time   TIMESTAMP,
    description VARCHAR(255) NOT NULL,
    student_id  BIGINT REFERENCES student (id),
    homework_id BIGINT REFERENCES homework (id)
);

-- changeset iglaz:8
CREATE TABLE IF NOT EXISTS grade
(
    id         BIGSERIAL PRIMARY KEY,
    grade      REAL,
    lesson_id  BIGINT REFERENCES lesson (id),
    student_id BIGINT REFERENCES student (id)
);

-- changeset iglaz:9
CREATE TABLE IF NOT EXISTS absence
(
    id         BIGSERIAL PRIMARY KEY,
    is_absent  BOOLEAN,
    lesson_id  BIGINT REFERENCES lesson (id),
    student_id BIGINT REFERENCES student (id)
);


