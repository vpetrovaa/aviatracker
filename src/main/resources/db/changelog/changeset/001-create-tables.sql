--liquibase formatted sql
--changeset vpetrovaa:1

create table airplanes
(
    id varchar(45),
	company varchar(45) not null,
	number varchar(45) not null,
	primary key (id)
);

create table airports
(
    id varchar(45),
	name varchar(45) not null,
	city varchar(45) not null,
	longitude decimal(9,6) not null,
    latitude decimal(8,6) not null,
	primary key (id)
);