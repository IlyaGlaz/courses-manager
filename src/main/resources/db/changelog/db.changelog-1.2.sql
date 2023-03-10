-- liquibase formatted sql

-- changeset bal:8
CREATE TABLE courses
(
    id   integer      NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    name varchar(255) NOT NULL,
    CONSTRAINT courses_pkey PRIMARY KEY (id)
);

CREATE TABLE groups
(
    id         integer      NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    begin_date date,
    end_date   date,
    name       varchar(255) NOT NULL,
    course_id  integer      NOT NULL,
    CONSTRAINT groups_pkey PRIMARY KEY (id),
    CONSTRAINT fk_groups_courses FOREIGN KEY (course_id) REFERENCES courses (id)
);

CREATE TABLE homeworks
(
    id              integer                             NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    editing_time    timestamp,
    publishing_time timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    text            varchar(255)                        NOT NULL,
    CONSTRAINT homeworks_pkey PRIMARY KEY (id)
);

CREATE TABLE lessons
(
    id          integer   NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    begin_time  timestamp NOT NULL,
    description varchar(255),
    title       varchar(255),
    group_id    integer   NOT NULL,
    homework_id integer,
    CONSTRAINT lessons_pkey PRIMARY KEY (id),
    CONSTRAINT fk_lessons_homeworks FOREIGN KEY (homework_id) REFERENCES homeworks (id),
    CONSTRAINT fk_lessons_groups FOREIGN KEY (group_id) REFERENCES groups (id)
);

CREATE TABLE users
(
    id         integer      NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    email      varchar(255) NOT NULL,
    firstname  varchar(255),
    grades_sum real,
    lastname   varchar(255),
    "password" varchar(255) NOT NULL,
    "role"     varchar(255) NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT unq_users UNIQUE (email)
);

CREATE TABLE users_xref_groups
(
    users_id integer NOT NULL,
    group_id integer NOT NULL,
    CONSTRAINT pk_users_xref_groups PRIMARY KEY (users_id, group_id),
    CONSTRAINT fk_users_xref_groups_users FOREIGN KEY (users_id) REFERENCES users (id),
    CONSTRAINT fk_users_xref_groups_groups FOREIGN KEY (group_id) REFERENCES groups (id)
);

CREATE TABLE absence
(
    user_id           integer NOT NULL,
    missed_lessons_id integer NOT NULL,
    CONSTRAINT pk_absence PRIMARY KEY (user_id, missed_lessons_id),
    CONSTRAINT fk_absence_users FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_absence_lessons FOREIGN KEY (missed_lessons_id) REFERENCES lessons (id)
);

CREATE TABLE grades
(
    id        integer NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    grade     real    NOT NULL,
    lesson_id integer NOT NULL,
    user_id   integer NOT NULL,
    CONSTRAINT grades_pkey PRIMARY KEY (id),
    CONSTRAINT fk_grades_users FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_grades_lessons FOREIGN KEY (lesson_id) REFERENCES lessons (id)
);

CREATE TABLE homework_reports
(
    id              integer                             NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    editing_time    timestamp,
    publishing_time timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    text            varchar(255)                        NOT NULL,
    homework_id     integer                             NOT NULL,
    user_id         integer                             NOT NULL,
    CONSTRAINT homework_reports_pkey PRIMARY KEY (id),
    CONSTRAINT fk_homework_reports_users FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_homework_reports_homeworks FOREIGN KEY (homework_id) REFERENCES homeworks (id)
);

CREATE TABLE student_logs
(
    id              bigint                              NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    editing_time    timestamp,
    publishing_time timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    text            varchar(255)                        NOT NULL,
    user_id         integer                             NOT NULL,
    CONSTRAINT student_logs_pkey PRIMARY KEY (id),
    CONSTRAINT fk_student_logs_users FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE tokens
(
    id         integer NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    expired    boolean NOT NULL,
    revoked    boolean NOT NULL,
    token      varchar(255),
    token_type varchar(255),
    user_id    integer,
    CONSTRAINT tokens_pkey PRIMARY KEY (id),
    CONSTRAINT unq_tokens UNIQUE (token),
    CONSTRAINT fk_tokens_users FOREIGN KEY (user_id) REFERENCES users (id)
);
