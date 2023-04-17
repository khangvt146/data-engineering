#!/bin/bash

set -e
export PGPASSWORD=$POSTGRES_PASSWORD
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
CREATE USER $APP_DB_USER WITH PASSWORD '$APP_DB_PASS';
CREATE DATABASE $APP_DB_NAME;
GRANT ALL PRIVILEGES ON DATABASE $APP_DB_NAME TO $APP_DB_USER;
ALTER DATABASE $APP_DB_NAME OWNER TO $APP_DB_USER;
\connect $APP_DB_NAME $APP_DB_USER
BEGIN;
CREATE TABLE IF NOT EXISTS humidity (
    id serial NOT NULL PRIMARY KEY,
    "device_id" varchar(60),
    "received_at" timestamp,
    "value" float8,
    "unit" varchar(32)
);

CREATE TABLE IF NOT EXISTS light (
    id serial NOT NULL PRIMARY KEY,
    "device_id" varchar(60),
    "received_at" timestamp,
    "value" float8,
    "unit" varchar(32)
);

CREATE TABLE IF NOT EXISTS ph (
    id serial NOT NULL PRIMARY KEY,
    "device_id" varchar(60),
    "received_at" timestamp,
    "value" float8,
    "unit" varchar(32)
);

CREATE TABLE IF NOT EXISTS pressure (
    id serial NOT NULL PRIMARY KEY,
    "device_id" varchar(60),
    "received_at" timestamp,
    "value" float8,
    "unit" varchar(32)
);

CREATE TABLE IF NOT EXISTS salinity (
    id serial NOT NULL PRIMARY KEY,
    "device_id" varchar(60),
    "received_at" timestamp,
    "value" float8,
    "unit" varchar(32)
);

CREATE TABLE IF NOT EXISTS temperature (
    id serial NOT NULL PRIMARY KEY,
    "device_id" varchar(60),
    "received_at" timestamp,
    "value" float8,
    "unit" varchar(32)
);

COMMIT;
EOSQL