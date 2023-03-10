-- liquibase formatted sql

-- changeset bal:9
INSERT INTO users (email, firstname, grades_sum, lastname, password, role) VALUES ('pizzzadog@mail.com', 'Nikolai', null, null, 'password', 'TEACHER_ROLE');
INSERT INTO users (email, firstname, grades_sum, lastname, password, role) VALUES ('sergey@mail.com', 'Sergey', 10, null, 'password', 'STUDENT_ROLE');
INSERT INTO users (email, firstname, grades_sum, lastname, password, role) VALUES ('serega@mail.com', 'Sergey', 10, null, 'password', 'STUDENT_ROLE');
INSERT INTO users (email, firstname, grades_sum, lastname, password, role) VALUES ('ilia@mail.com', 'Ilia', 10, null, 'password', 'STUDENT_ROLE');
INSERT INTO users (email, firstname, grades_sum, lastname, password, role) VALUES ('bal@mail.com', 'Pavel', 10, 'Bal', 'password', 'STUDENT_ROLE');

-- changeset bal:10
INSERT INTO courses (name) VALUES ('Java');

-- changeset bal:11
INSERT INTO groups (begin_date, end_date, name, course_id) VALUES ('2023-01-09', null, 'Java #1', 1);

-- changeset bal:12
INSERT INTO student_logs (editing_time, publishing_time, text, user_id) VALUES (null, '2023-01-04 01:10:29.000000', 'Log1', 2);
INSERT INTO student_logs (editing_time, publishing_time, text, user_id) VALUES (null, '2023-01-04 01:10:29.000000', 'Log2', 2);
INSERT INTO student_logs (editing_time, publishing_time, text, user_id) VALUES (null, '2023-01-04 01:10:29.000000', 'Log3', 3);
INSERT INTO student_logs (editing_time, publishing_time, text, user_id) VALUES (null, '2023-01-04 01:10:29.000000', 'Log4', 3);
INSERT INTO student_logs (editing_time, publishing_time, text, user_id) VALUES (null, '2023-01-04 01:10:29.000000', 'Log5', 4);
INSERT INTO student_logs (editing_time, publishing_time, text, user_id) VALUES (null, '2023-01-04 01:10:29.000000', 'Log6', 4);
INSERT INTO student_logs (editing_time, publishing_time, text, user_id) VALUES (null, '2023-01-04 01:10:29.000000', 'Log7', 5);
INSERT INTO student_logs (editing_time, publishing_time, text, user_id) VALUES (null, '2023-01-04 01:10:29.000000', 'Log8', 5);

-- changeset bal:13
INSERT INTO homeworks (editing_time, publishing_time, text) VALUES (null, '2023-02-12 18:00:00.000000', 'ДЗ 1');
INSERT INTO homeworks (editing_time, publishing_time, text) VALUES (null, '2023-02-16 18:00:00.000000', 'ДЗ 2');

-- changeset bal:14
INSERT INTO lessons (begin_time, description, title, group_id, homework_id) VALUES ('2023-02-09 16:00:00.000000', null, 'Урок 1', 1, null);
INSERT INTO lessons (begin_time, description, title, group_id, homework_id) VALUES ('2023-02-12 16:00:00.000000', null, 'Урок 2', 1, 1);
INSERT INTO lessons (begin_time, description, title, group_id, homework_id) VALUES ('2023-02-16 16:00:00.000000', null, 'Урок 3', 1, 2);

-- changeset bal:15
INSERT INTO homework_reports (editing_time, publishing_time, text, homework_id, user_id) VALUES (null, '2023-02-13 18:00:00.000000', 'Решение ДЗ 1', 1, 2);
INSERT INTO homework_reports (editing_time, publishing_time, text, homework_id, user_id) VALUES (null, '2023-02-13 18:00:00.000000', 'Решение ДЗ 2', 1, 3);
INSERT INTO homework_reports (editing_time, publishing_time, text, homework_id, user_id) VALUES (null, '2023-02-13 18:00:00.000000', 'Решение ДЗ 3', 1, 4);
INSERT INTO homework_reports (editing_time, publishing_time, text, homework_id, user_id) VALUES (null, '2023-02-13 18:00:00.000000', 'Решение ДЗ 4', 1, 5);
INSERT INTO homework_reports (editing_time, publishing_time, text, homework_id, user_id) VALUES (null, '2023-02-17 18:00:00.000000', 'Решение ДЗ 5', 2, 2);
INSERT INTO homework_reports (editing_time, publishing_time, text, homework_id, user_id) VALUES (null, '2023-02-17 18:00:00.000000', 'Решение ДЗ 6', 2, 3);
INSERT INTO homework_reports (editing_time, publishing_time, text, homework_id, user_id) VALUES (null, '2023-02-17 18:00:00.000000', 'Решение ДЗ 7', 2, 4);
INSERT INTO homework_reports (editing_time, publishing_time, text, homework_id, user_id) VALUES (null, '2023-02-17 18:00:00.000000', 'Решение ДЗ 8', 2, 5);

-- changeset bal:16
INSERT INTO grades (grade, lesson_id, user_id) VALUES (10, 2, 2);
INSERT INTO grades (grade, lesson_id, user_id) VALUES (10, 2, 3);
INSERT INTO grades (grade, lesson_id, user_id) VALUES (10, 3, 4);
INSERT INTO grades (grade, lesson_id, user_id) VALUES (10, 3, 5);

-- changeset bal:17
INSERT INTO users_xref_groups (users_id, group_id) VALUES (1, 1);
INSERT INTO users_xref_groups (users_id, group_id) VALUES (2, 1);
INSERT INTO users_xref_groups (users_id, group_id) VALUES (3, 1);
INSERT INTO users_xref_groups (users_id, group_id) VALUES (4, 1);
INSERT INTO users_xref_groups (users_id, group_id) VALUES (5, 1);

-- changeset bal:18
INSERT INTO absence (user_id, missed_lessons_id) VALUES (2, 2);

--changeset bal:19
ALTER TABLE users ALTER COLUMN id TYPE bigint
