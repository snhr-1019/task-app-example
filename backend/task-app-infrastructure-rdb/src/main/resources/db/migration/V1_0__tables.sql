create table taskapp.tasks
(
    id        int auto_increment
        primary key,
    user_id   int          not null,
    title     varchar(255) not null,
    completed tinyint(1)   not null
);

INSERT INTO taskapp.tasks (id, user_id, title, completed) VALUES (1, 1, '牛乳を買う', 0);
INSERT INTO taskapp.tasks (id, user_id, title, completed) VALUES (2, 1, '掃除をする', 1);
INSERT INTO taskapp.tasks (id, user_id, title, completed) VALUES (3, 2, '山田のタスク', 0);

create table taskapp.users
(
    id       int auto_increment
        primary key,
    username varchar(255) not null,
    roles    varchar(255) not null,
    password varchar(255) not null
);

INSERT INTO taskapp.users (id, username, roles, password) VALUES (1, 'tanaka', 'ROLE_USER', '$2a$10$27Kls5TCTZUttJHzlmuUqecS0Ab7jRFp2vmBMqKk3HeW3p3ebFx4m');
INSERT INTO taskapp.users (id, username, roles, password) VALUES (2, 'yamada', 'ROLE_ADMIN', '$2a$10$27Kls5TCTZUttJHzlmuUqecS0Ab7jRFp2vmBMqKk3HeW3p3ebFx4m');
