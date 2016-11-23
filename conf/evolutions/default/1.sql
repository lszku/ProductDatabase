# product schema

# --- !Ups

CREATE TABLE products (
  ean BIGSERIAL PRIMARY KEY UNIQUE,
  name  TEXT NOT NULL,
  descr TEXT NOT NULL
);

CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY UNIQUE,
  email      TEXT NOT NULL,
  first_name TEXT,
  last_name  TEXT
);

CREATE TABLE addresses (
  id            BIGSERIAL PRIMARY KEY UNIQUE,
  customer_id   BIGINT NOT NULL,
  street        TEXT,
  house_nr      TEXT,
  apartament_nr TEXT,
  zip           TEXT,
  city          TEXT,
  country       TEXT
);

CREATE TABLE customers (
  id           BIGSERIAL PRIMARY KEY UNIQUE,
  first_name   TEXT NOT NULL,
  last_name    TEXT NOT NULL,
  properties1  TEXT,
  properties2  TEXT,
  properties3  TEXT,
  properties4  TEXT,
  properties5  TEXT,
  properties6  TEXT,
  properties7  TEXT,
  properties8  TEXT,
  properties9  TEXT,
  properties10 TEXT,
  properties11 TEXT,
  properties12 TEXT,
  properties13 TEXT,
  properties14 TEXT,
  properties15 TEXT,
  properties16 TEXT,
  properties17 TEXT,
  properties18 TEXT,
  properties19 TEXT
);

# --- !Downs
DROP TABLE products;
DROP TABLE "users";
DROP TABLE "addresses";
DROP TABLE "customers";

/*create table "products" (
    "ean" bigint(20) not null auto_increment,
    "name" varchar(255) not null,
    "descr" varchar(250) not null
);

CREATE TABLE "users" (
  "id" bigint(20) not null auto_increment,
  "email" varchar(255) NOT NULL ,
  "first_name" varchar(255),
  "last_name" varchar(255)
);


CREATE TABLE "addresses" (
  "id" bigint(20) not null auto_increment,
  "customer_id" bigint(20) NOT NULL,
  "street" varchar(255),
  "house_nr" varchar(255),
  "apartament_nr" varchar(255),
  "zip" varchar(255),
  "city" varchar(255),
  "country" varchar(255)
);

CREATE TABLE "customers" (
  "id" bigint(20) not null auto_increment,
  "first_name" varchar(255) NOT NULL,
  "last_name" varchar(255) NOT NULL,
  "properties1" varchar(255),
  "properties2" VARCHAR(255),
  "properties3" VARCHAR(255),
  "properties4" VARCHAR(255),
  "properties5" VARCHAR(255),
  "properties6" VARCHAR(255),
  "properties7" VARCHAR(255),
  "properties8" VARCHAR(255),
  "properties9" VARCHAR(255),
  "properties10" VARCHAR(255),
  "properties11" VARCHAR(255),
  "properties12" VARCHAR(255),
  "properties13" VARCHAR(255),
  "properties14" VARCHAR(255),
  "properties15" VARCHAR(255),
  "properties16" VARCHAR(255),
  "properties17" VARCHAR(255),
  "properties18" VARCHAR(255),
  "properties19" VARCHAR(255)
);*/


