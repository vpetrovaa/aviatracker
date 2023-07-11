--liquibase formatted sql
--changeset vpetrovaa:2

insert into airplanes (id, company, number)
VALUES ('1', 'Boeing', '737'),
       ('2', 'Boeing', '767'),
       ('3', 'Boeing', '787');

INSERT INTO airports (id, name, city, longitude, latitude)
VALUES ('1', 'Minsk National Airport', 'Minsk', 28.0262, 53.8762),
       ('2', 'Kyiv International Airport', 'Kyiv', 30.4510, 50.4010),
       ('3', 'Sheremetyevo', 'Moscow', 37.4125, 55.9736);