CREATE TABLE IF NOT EXISTS comment
(
    id           BIGSERIAL PRIMARY KEY,
    text_value   TEXT        NOT NULL,
    created_at   timestamptz NOT NULL,
    updated_at   timestamptz NOT NULL,
    community_id BIGINT      NOT NULL,
    user_id      BIGINT      NOT NULL
);