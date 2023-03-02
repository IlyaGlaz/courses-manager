-- liquibase formatted sql

-- changeset bal:1
INSERT INTO groups (id, course, finish, name, start) VALUES (1, 'Java', '2023-03-13', 'Java group#1', '2023-01-09');
INSERT INTO groups (id, course, finish, name, start) VALUES (2, 'C#', '2023-03-10', 'C# group#1', '2023-01-03');
INSERT INTO groups (id, course, finish, name, start) VALUES (3, 'Java', '2023-03-13', 'Java group#2', '2023-01-09');
INSERT INTO groups (id, course, finish, name, start) VALUES (4, 'Python', '2023-03-22', 'Python group#1', '2023-01-01');

-- changeset bal:2
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (2, '2023-02-18', null, 'city1', 'teach1@mail.ru', 'Teacher1', 'Lastname1', 'teacherpass', 'TEACHER', 1);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (3, '2023-02-18', null, 'city2', 'teach2@mail.ru', 'Teacher2', 'Lastname2', 'teacherpass', 'TEACHER', 2);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (4, '2023-02-18', null, 'city1', 'teach3@mail.ru', 'Teacher3', 'Lastname3', 'teacherpass', 'TEACHER', 3);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (5, '2023-02-18', null, 'city2', 'teach4@mail.ru', 'Teacher4', 'Lastname4', 'teacherpass', 'TEACHER', 4);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (6, '2023-02-18', 2, 'city1', 'stud1@mail.ru', 'Student1', 'Фамилия1', 'studentpass', 'STUDENT', 1);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (7, '2023-02-18', 5, 'city2', 'stud2@mail.ru', 'Student2', 'Фамилия2', 'studentpass', 'STUDENT', 1);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (8, '2023-02-18', 2, 'city3', 'stud3@mail.ru', 'Student3', 'БольшаяФамилия', 'studentpass', 'STUDENT', 1);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (9, '2023-02-18', 14, 'city4', 'stud4@mail.ru', 'Student4', 'Фамил', 'studentpass', 'STUDENT', 1);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (10, '2023-02-18', 9, 'city1', 'stud5@mail.ru', 'Student5', 'Фамилия1', 'studentpass', 'STUDENT', 2);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (11, '2023-02-18', 6, 'city2', 'stud6@mail.ru', 'Student6', 'Фамилия2', 'studentpass', 'STUDENT', 2);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (12, '2023-02-18', 7, 'city3', 'stud7@mail.ru', 'Student7', 'БольшаяФамилия', 'studentpass', 'STUDENT', 2);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (13, '2023-02-18', 8, 'city4', 'stud8@mail.ru', 'Student8', 'Фамил', 'studentpass', 'STUDENT', 2);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (16, '2023-02-18', 0, 'city3', 'stud11@mail.ru', 'Student11', 'БольшаяФамилия', 'studentpass', 'STUDENT', 3);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (14, '2023-02-18', 0, 'city1', 'stud9@mail.ru', 'Student9', 'Фамилия1', 'studentpass', 'STUDENT', 3);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (15, '2023-02-18', 0, 'city2', 'stud10@mail.ru', 'Student10', 'Фамилия2', 'studentpass', 'STUDENT', 3);
INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id) VALUES (17, '2023-02-18', 0, 'city4', 'stud12@mail.ru', 'Student12', 'Фамил', 'studentpass', 'STUDENT', 3);

-- changeset bal:3
INSERT INTO lesson (id, date_time, subject) VALUES (1, '2023-02-01 00:00:00.000000', 'Java Lesson#1');
INSERT INTO lesson (id, date_time, subject) VALUES (2, '2023-02-03 00:00:00.000000', 'Java Lesson#2');
INSERT INTO lesson (id, date_time, subject) VALUES (4, '2023-02-06 00:00:00.000000', 'Java Lesson#3');
INSERT INTO lesson (id, date_time, subject) VALUES (3, '2023-02-05 00:00:00.000000', 'C# Lesson#1');
INSERT INTO lesson (id, date_time, subject) VALUES (5, '2023-02-07 00:00:00.000000', 'C# Lesson#2');

-- changeset bal:4
INSERT INTO homework (id, description, file, date, lesson_id) VALUES (1, 'hw text1', 'file1', '2023-02-01', 1);
INSERT INTO homework (id, description, file, date, lesson_id) VALUES (2, 'hw text2', 'file2', '2023-02-03', 2);
INSERT INTO homework (id, description, file, date, lesson_id) VALUES (3, 'hw text3', 'file3', '2023-02-06', 3);
INSERT INTO homework (id, description, file, date, lesson_id) VALUES (4, 'hw text4', 'file4', '2023-02-05', 4);
INSERT INTO homework (id, description, file, date, lesson_id) VALUES (5, 'hw text5', 'file5', '2023-02-07', 5);

-- changeset bal:5
INSERT INTO log (id, date_time, description, users_id, homework_id) VALUES (1, '2023-02-02 12:00:00.000000', 'student log1', 6, 2);
INSERT INTO log (id, date_time, description, users_id, homework_id) VALUES (2, '2023-02-05 10:00:00.000000', 'student log2', 6, 3);
INSERT INTO log (id, date_time, description, users_id, homework_id) VALUES (3, '2023-02-02 12:00:00.000000', 'student log3', 7, 2);
INSERT INTO log (id, date_time, description, users_id, homework_id) VALUES (4, '2023-02-05 10:00:00.000000', 'student log4', 7, 3);
INSERT INTO log (id, date_time, description, users_id, homework_id) VALUES (5, '2023-02-02 12:00:00.000000', 'student log5', 8, 2);
INSERT INTO log (id, date_time, description, users_id, homework_id) VALUES (6, '2023-02-05 10:00:00.000000', 'student log6', 8, 3);
INSERT INTO log (id, date_time, description, users_id, homework_id) VALUES (7, '2023-02-02 12:00:00.000000', 'student log7', 9, 2);
INSERT INTO log (id, date_time, description, users_id, homework_id) VALUES (8, '2023-02-05 10:00:00.000000', 'student log8', 9, 3);
INSERT INTO log (id, date_time, description, users_id, homework_id) VALUES (9, '2023-02-06 12:12:00.000000', 'student log9', 10, 5);
INSERT INTO log (id, date_time, description, users_id, homework_id) VALUES (10, '2023-02-06 12:12:00.000000', 'student log10', 11, 5);
INSERT INTO log (id, date_time, description, users_id, homework_id) VALUES (11, '2023-02-06 12:12:00.000000', 'student log11', 12, 5);
INSERT INTO log (id, date_time, description, users_id, homework_id) VALUES (12, '2023-02-06 12:12:00.000000', 'student log12', 13, 5);

-- changeset bal:6
INSERT INTO grade (id, grade, lesson_id, users_id) VALUES (1, 2, 2, 6);
INSERT INTO grade (id, grade, lesson_id, users_id) VALUES (2, 5, 2, 7);
INSERT INTO grade (id, grade, lesson_id, users_id) VALUES (3, 2, 3, 8);
INSERT INTO grade (id, grade, lesson_id, users_id) VALUES (4, 14, 3, 9);
INSERT INTO grade (id, grade, lesson_id, users_id) VALUES (5, 9, 3, 10);
INSERT INTO grade (id, grade, lesson_id, users_id) VALUES (6, 6, 3, 11);
INSERT INTO grade (id, grade, lesson_id, users_id) VALUES (7, 7, 5, 12);
INSERT INTO grade (id, grade, lesson_id, users_id) VALUES (8, 8, 5, 13);

-- changeset bal:7
INSERT INTO absence (id, is_absent, lesson_id, users_id) VALUES (1, true, 1, 6);
INSERT INTO absence (id, is_absent, lesson_id, users_id) VALUES (2, true, 1, 7);
INSERT INTO absence (id, is_absent, lesson_id, users_id) VALUES (3, true, 3, 12);
INSERT INTO absence (id, is_absent, lesson_id, users_id) VALUES (4, true, 3, 13);
