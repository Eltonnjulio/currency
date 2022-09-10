
CREATE TABLE currencies (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(256) NOT NULL,
    iso_code VARCHAR(6) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL,
    deleted_at TIMESTAMP NULL,

    UNIQUE (name)
);

CREATE TABLE rates (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    base_currency_id BIGINT,
    target_currency_id BIGINT,
    sale FLOAT NOT NULL,
    purchase FLOAT NOT NULL,
    provider_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL,
    deleted_at TIMESTAMP NULL
);

CREATE TABLE rate_history (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    rate_id BIGINT,
    sale FLOAT NOT NULL,
    purchase FLOAT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE rate_providers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(256) NOT NULL,
    email VARCHAR(256) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL,
    deleted_at TIMESTAMP NULL
);

