-- liquibase formatted sql

-- changeset iglaz:1
CREATE TABLE IF NOT EXISTS users
(
    id         BIGSERIAL PRIMARY KEY,
    birth_date DATE,
    city       VARCHAR(64),
    email      VARCHAR(64),
    firstname  VARCHAR(32),
    lastname   VARCHAR(32),
    password   VARCHAR(255),
    role       VARCHAR(32)
);

-- changeset iglaz:2
CREATE TABLE IF NOT EXISTS teacher
(
    id         BIGSERIAL PRIMARY KEY REFERENCES users (id)
);

-- changeset iglaz:3
CREATE TABLE IF NOT EXISTS groups
(
    id         BIGSERIAL PRIMARY KEY,
    course     VARCHAR(32),
    finish     DATE,
    name       VARCHAR(64),
    start      DATE,
    teacher_id BIGINT REFERENCES teacher (id)
);

-- changeset iglaz:4
CREATE TABLE IF NOT EXISTS student
(
    id        BIGSERIAL PRIMARY KEY REFERENCES users(id),
    groups_id BIGINT REFERENCES groups (id)
);

-- changeset iglaz:5
CREATE TABLE IF NOT EXISTS log
(
    id          BIGSERIAL PRIMARY KEY,
    date_time   TIMESTAMP,
    description VARCHAR(255),
    student_id  BIGINT REFERENCES student (id)
);

-- changeset iglaz:6
CREATE TABLE IF NOT EXISTS lesson
(
    id        BIGSERIAL PRIMARY KEY,
    date_time TIMESTAMP,
    subject   VARCHAR(255)
);

-- changeset iglaz:7
CREATE TABLE IF NOT EXISTS student_lesson
(
    id         BIGSERIAL PRIMARY KEY,
    is_absent  BOOLEAN,
    point      FLOAT4,
    lesson_id  BIGINT REFERENCES lesson (id),
    student_id BIGINT REFERENCES student (id),
    CONSTRAINT "student_lesson_pkey" PRIMARY KEY ("id")
);



