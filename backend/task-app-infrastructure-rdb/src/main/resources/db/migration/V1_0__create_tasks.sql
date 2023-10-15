create table taskapp.tasks
(
    id        int auto_increment
        primary key,
    user_id   int          not null,
    title     varchar(255) not null,
    completed tinyint(1)   not null
);
