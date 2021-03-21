CREATE TABLE customer (
    id mediumint(8) unsigned NOT NULL auto_increment,
    name varchar(255) NOT NULL,
    phone_number varchar(255) NOT NULL,
    email varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
  );

  CREATE TABLE ticket (
      id mediumint(8) unsigned NOT NULL auto_increment,
      source varchar(255) NOT NULL,
      destination varchar(255) NOT NULL,
      duration varchar(255) NOT NULL,
      flight_date date NOT NULL,
      place int NOT NULL,
      customer_id mediumint default NULL,
      PRIMARY KEY (id),
      CONSTRAINT customerForeignKey FOREIGN KEY (customer_id) REFERENCES customer(id)
    );