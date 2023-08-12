create table taskapp.tasks
(
    id        integer      not null
        primary key,
    title     varchar(255) not null,
    completed boolean      not null
);

INSERT INTO taskapp.tasks (id, title, completed)
VALUES (1, '牛乳を買う', false);
INSERT INTO taskapp.tasks (id, title, completed)
VALUES (2, '掃除をする', false);
INSERT INTO taskapp.tasks (id, title, completed)
VALUES (3, '手紙を書く', true);
