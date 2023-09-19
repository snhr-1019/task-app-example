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
