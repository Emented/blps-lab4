CREATE TABLE IF NOT EXISTS "user"
(
    id         BIGSERIAL PRIMARY KEY,
    email      VARCHAR(64)  NOT NULL UNIQUE,
    username   VARCHAR(64)  NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    birth_date DATE         NOT NULL,
    activity   BIGINT       NOT NULL
);

CREATE TABLE IF NOT EXISTS category
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS community
(
    id                 BIGSERIAL PRIMARY KEY,
    name               VARCHAR(64)        NOT NULL,
    address            VARCHAR(64) UNIQUE NOT NULL,
    language           VARCHAR(2)         NOT NULL,
    description        VARCHAR(255)       NOT NULL,
    is_for_children    BOOLEAN            NOT NULL,
    category_id        BIGINT             NOT NULL REFERENCES category (id),
    user_id            BIGINT             NOT NULL REFERENCES "user" (id),
    is_blocked         BOOLEAN            NOT NULL,
    interest_rate      BIGINT             NOT NULL,
    moderation_result  VARCHAR(64)        NOT NULL,
    moderation_message VARCHAR(255),
    creation_ts        timestamptz          NOT NULL,
    update_ts          timestamptz          NOT NULL
);

CREATE TABLE IF NOT EXISTS role
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS role_user_relation
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    CONSTRAINT fk_role_user_relation_user_id
        FOREIGN KEY (user_id)
            REFERENCES "user" (id),
    CONSTRAINT fk_role_user_relation_role_id
        FOREIGN KEY (role_id)
            REFERENCES role (id),
    UNIQUE (user_id, role_id)
);

CREATE TABLE IF NOT EXISTS community_event
(
    id                 BIGSERIAL PRIMARY KEY,
    community_id       BIGINT NOT NULL,
    name               VARCHAR(64)        NOT NULL,
    address            VARCHAR(64) UNIQUE NOT NULL,
    language           VARCHAR(2)         NOT NULL,
    description        VARCHAR(255)       NOT NULL,
    is_for_children    BOOLEAN            NOT NULL,
    category_id        BIGINT             NOT NULL REFERENCES category (id),
    user_id            BIGINT             NOT NULL REFERENCES "user" (id),
    is_blocked         BOOLEAN            NOT NULL,
    interest_rate      BIGINT             NOT NULL,
    creation_ts        timestamptz        NOT NULL,
    event_type         VARCHAR(64)        NOT NULL,
    is_sent            BOOLEAN            NOT NULL
);
