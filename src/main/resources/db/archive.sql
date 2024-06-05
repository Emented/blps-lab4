CREATE TABLE IF NOT EXISTS community_archive
(
    id                 BIGSERIAL PRIMARY KEY,
    name               VARCHAR(64)        NOT NULL,
    address            VARCHAR(64) UNIQUE NOT NULL,
    language           VARCHAR(2)         NOT NULL,
    description        VARCHAR(255)       NOT NULL,
    is_for_children    BOOLEAN            NOT NULL,
    category_name      VARCHAR(255)       NOT NULL,
    user_id            BIGINT             NOT NULL,
    is_blocked         BOOLEAN            NOT NULL,
    interest_rate      BIGINT             NOT NULL,
    moderation_result  VARCHAR(64)        NOT NULL,
    moderation_message VARCHAR(255),
    creation_ts        timestamptz        NOT NULL,
    update_ts          timestamptz        NOT NULL,
    archivation_ts     timestamptz        NOT NULL
);