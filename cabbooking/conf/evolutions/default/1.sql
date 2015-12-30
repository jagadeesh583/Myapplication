# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table booking (
  id                        serial not null,
  custname                  varchar(255),
  cabtype                   integer,
  custsource                varchar(255),
  custdestination           varchar(255),
  cabnumber                 bigint,
  custmail                  varchar(255),
  drivername                varchar(255),
  driverimage               bytea,
  avialable                 boolean,
  date                      varchar(255),
  constraint pk_booking primary key (id))
;

create table cab (
  id                        serial not null,
  cabnumber                 bigint,
  cabtype                   integer,
  constraint pk_cab primary key (id))
;

create table customer (
  id                        serial not null,
  name                      varchar(255),
  mobile                    bigint,
  email                     varchar(255),
  source                    varchar(255),
  destination               varchar(255),
  password                  varchar(255),
  date                      varchar(255),
  constraint pk_customer primary key (id))
;

create table driver (
  id                        serial not null,
  name                      varchar(255),
  driverimage               bytea,
  avialable                 boolean,
  filename                  varchar(255),
  mobileno                  bigint,
  constraint pk_driver primary key (id))
;




# --- !Downs

drop table if exists booking cascade;

drop table if exists cab cascade;

drop table if exists customer cascade;

drop table if exists driver cascade;

