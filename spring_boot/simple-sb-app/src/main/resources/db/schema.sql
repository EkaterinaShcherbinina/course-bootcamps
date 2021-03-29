    DROP TABLE IF EXISTS customer CASCADE;
    DROP TABLE IF EXISTS ticket CASCADE;
    DROP TABLE IF EXISTS bank CASCADE;
    DROP TABLE IF EXISTS account CASCADE;

    CREATE TABLE IF NOT EXISTS customer (
      id SERIAL PRIMARY KEY,
      name CHARACTER VARYING(255) NOT NULL,
      phone_number CHARACTER VARYING(255) NOT NULL,
      email CHARACTER VARYING(255) UNIQUE NOT NULL
    );

    CREATE TABLE IF NOT EXISTS ticket (
      id SERIAL PRIMARY KEY,
      source CHARACTER VARYING(255) NOT NULL,
      destination CHARACTER VARYING(255) NOT NULL,
      duration CHARACTER VARYING(255) NOT NULL,
      flight_date date NOT NULL,
      place int NOT NULL,
      customer_id bigint default NULL,
      FOREIGN KEY (customer_id) REFERENCES customer(id)
    );

    CREATE TABLE IF NOT EXISTS bank (
      id BIGSERIAL PRIMARY KEY,
      name CHARACTER VARYING(255) NOT NULL,
      code bigint NOT NULL,
      city_name CHARACTER VARYING(255) NOT NULL
    );

    CREATE TABLE IF NOT EXISTS account (
      id BIGSERIAL PRIMARY KEY,
      balance numeric(10,2),
      customer_id bigint NOT NULL,
      bank_id bigint NOT NULL,
      FOREIGN KEY (customer_id) REFERENCES customer(id),
      FOREIGN KEY (bank_id) REFERENCES bank(id)
    );