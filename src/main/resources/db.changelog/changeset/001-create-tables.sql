--liquibase formatted sql

--changeset vpetrovaa:create_users_tables

create schema if not exists cinema_schema;
set schema 'cinema_schema';

create table if not exists users
(
    id bigserial,
	email varchar(45) not null unique,
	password varchar(200) not null,
	name varchar(45) not null,
	surname varchar(45) not null,
	phone varchar(12) not null,
	birthday date not null,
	primary key (id)
);