# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table registration (
  id                        serial not null,
  name                      varchar(255),
  city                      varchar(255),
  user1                     varchar(255),
  state                     varchar(255),
  country                   varchar(255),
  password                  varchar(255),
  constraint pk_registration primary key (id))
;




# --- !Downs

drop table if exists registration cascade;

