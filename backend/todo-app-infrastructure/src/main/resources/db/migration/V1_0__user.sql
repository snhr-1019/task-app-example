CREATE TABLE user
(
    id        bigint              NOT NULL,
    email     varchar(256) UNIQUE NOT NULL,
    password  varchar(128)        NOT NULL,
    name      varchar(32)         NOT NULL,
    role_type enum ('ADMIN', 'USER'),
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
