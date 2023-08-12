create table taskapp.tasks
(
    id     integer      not null
        primary key,
    title  varchar(255) not null,
    status varchar(255) not null
);

INSERT INTO taskapp.tasks (id, title, status)
VALUES (1, '牛乳を買う', 'TODO');
INSERT INTO taskapp.tasks (id, title, status)
VALUES (2, '掃除をする', 'DOING');
