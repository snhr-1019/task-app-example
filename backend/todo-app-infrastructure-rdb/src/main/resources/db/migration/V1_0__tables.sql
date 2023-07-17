create table todoapp.app_user
(
    uuid     varchar(255) not null
        primary key,
    username varchar(32)  not null,
    password varchar(255) null,
    constraint app_user_pk
        unique (uuid)
)
    charset = utf8mb4;

create table todoapp.todo
(
    uuid          varchar(255) not null
        primary key,
    app_user_uuid varchar(255) not null,
    code          varchar(255) not null,
    title         varchar(255) not null,
    status        varchar(255) not null
);

create index todo_app_user_uuid_fk
    on todoapp.todo (app_user_uuid);


INSERT INTO todoapp.todo (uuid, app_user_uuid, code, title, status)
VALUES ('ABCD', '123A', 'ABC123', '牛乳を買う', 'TODO');
INSERT INTO todoapp.todo (uuid, app_user_uuid, code, title, status)
VALUES ('EFGH', '123A', '789EFG', '掃除をする', 'DOING');
