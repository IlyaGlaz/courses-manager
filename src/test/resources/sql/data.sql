INSERT INTO users (id, birth_date, total_grade, city, email, firstname, lastname, password, role, groups_id)
VALUES (2, '2023-02-18', null, 'city1', 'teach1@mail.ru', 'Teacher1', 'Lastname1', 'teacherpass', 'TEACHER_ROLE', 1),
       (3, '2023-02-18', null, 'city2', 'teach2@mail.ru', 'Teacher2', 'Lastname2', 'teacherpass', 'TEACHER_ROLE', 2),
       (4, '2023-02-18', null, 'city1', 'teach3@mail.ru', 'Teacher3', 'Lastname3', 'teacherpass', 'TEACHER_ROLE', 3),
       (5, '2023-02-18', null, 'city2', 'teach4@mail.ru', 'Teacher4', 'Lastname4', 'teacherpass', 'TEACHER_ROLE', 4),
       (6, '2023-02-18', 2, 'city1', 'stud1@mail.ru', 'Student1', 'Фамилия1', 'studentpass', 'STUDENT_ROLE', 1);
SELECT SETVAL('users_id_seq', (SELECT MAX(id) FROM users));