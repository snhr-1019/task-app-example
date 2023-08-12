create table taskapp.app_user
(
    uuid     varchar(255) not null
        primary key,
    username varchar(32)  not null,
    password varchar(255) null,
    constraint app_user_pk
        unique (uuid)
)
    charset = utf8mb4;

create table taskapp.task
(
    uuid          varchar(255) not null
        primary key,
    app_user_uuid varchar(255) not null,
    code          varchar(255) not null,
    title         varchar(255) not null,
    status        varchar(255) not null
);

create index task_app_user_uuid_fk
    on taskapp.task (app_user_uuid);


INSERT INTO taskapp.task (uuid, app_user_uuid, code, title, status)
VALUES ('9DA58AE2-96C4-44D0-9FC6-FBBB757C0F76', '74B2DDEB-5513-4820-82F5-F40BB41251E2', 'ABC123', '牛乳を買う', 'TASK');
INSERT INTO taskapp.task (uuid, app_user_uuid, code, title, status)
VALUES ('B92C0397-70D4-4F19-A98B-73B14C498EDF', '74B2DDEB-5513-4820-82F5-F40BB41251E2', '789EFG', '掃除をする', 'DOING');
