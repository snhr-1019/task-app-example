create table tasks
(
    id        integer      not null
        primary key,
    title     varchar(255) not null,
    completed boolean      not null
);

INSERT INTO tasks (id, title, completed)
VALUES (1, '牛乳を買う', false);
INSERT INTO tasks (id, title, completed)
VALUES (2, '掃除をする', true);

create table users
(
    id       integer      not null
        primary key,
    username varchar(255) not null,
    roles    varchar(255) not null,
    password varchar(255) not null
);

INSERT INTO users (id, username, roles, password)
VALUES (1, 'tanaka', 'ROLE_USER', '$2a$10$27Kls5TCTZUttJHzlmuUqecS0Ab7jRFp2vmBMqKk3HeW3p3ebFx4m');
INSERT INTO users (id, username, roles, password)
VALUES (2, 'yamada', 'ROLE_ADMIN', '$2a$10$27Kls5TCTZUttJHzlmuUqecS0Ab7jRFp2vmBMqKk3HeW3p3ebFx4m');
