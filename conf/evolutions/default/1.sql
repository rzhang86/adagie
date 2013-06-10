# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table balance (
  user_username             varchar(255) not null,
  amount                    bigint,
  constraint pk_balance primary key (user_username))
;

create table committed_balance (
  user_username             varchar(255) not null,
  amount                    bigint,
  constraint pk_committed_balance primary key (user_username))
;

create table consumer_profile (
  user_username             varchar(255) not null,
  a7                        bigint,
  a30                       bigint,
  a365                      bigint,
  f7                        integer,
  f30                       integer,
  f365                      integer,
  constraint pk_consumer_profile primary key (user_username))
;

create table credit_card_account (
  id                        bigint not null,
  user_username             varchar(255),
  financial_institution_id  integer,
  ofx_user                  varchar(255),
  ofx_password              varchar(255),
  cc_number                 varchar(255),
  constraint pk_credit_card_account primary key (id))
;

create table financial_institution (
  id                        integer not null,
  name                      varchar(255),
  url                       varchar(255),
  org                       varchar(255),
  fid                       varchar(255),
  constraint pk_financial_institution primary key (id))
;

create table interest (
  id                        integer not null,
  name                      varchar(255),
  constraint pk_interest primary key (id))
;

create table occupation (
  id                        integer not null,
  name                      varchar(255),
  constraint pk_occupation primary key (id))
;

create table user (
  username                  varchar(255) not null,
  password                  varchar(255),
  first_name                varchar(255),
  middle_name               varchar(255),
  last_name                 varchar(255),
  birthday                  timestamp,
  gender                    varchar(255),
  address1street1           varchar(255),
  address1street2           varchar(255),
  address1city              varchar(255),
  address1state             varchar(255),
  address1zip               varchar(255),
  address1latitude          double,
  address1longitude         double,
  address2street1           varchar(255),
  address2street2           varchar(255),
  address2city              varchar(255),
  address2state             varchar(255),
  address2zip               varchar(255),
  address2latitude          double,
  address2longitude         double,
  email1                    varchar(255),
  email2                    varchar(255),
  phone1                    varchar(255),
  phone2                    varchar(255),
  occupation1               integer,
  occupation2               integer,
  interest1                 integer,
  interest2                 integer,
  interest3                 integer,
  interest4                 integer,
  interest5                 integer,
  constraint pk_user primary key (username))
;

create table video (
  id                        bigint not null,
  user_username             varchar(255) not null,
  title                     varchar(255),
  description               varchar(255),
  duration                  integer,
  pay_formula               varchar(255))
;

create table watched_video (
  id                        bigint not null,
  user_username             varchar(255) not null,
  video_id                  bigint,
  start_time                timestamp,
  end_time                  timestamp,
  payout                    bigint)
;

create table watching_video (
  user_username             varchar(255) not null,
  video_id                  bigint,
  start_time                timestamp,
  payout                    bigint,
  constraint pk_watching_video primary key (user_username))
;

create sequence balance_seq;

create sequence committed_balance_seq;

create sequence consumer_profile_seq;

create sequence credit_card_account_seq;

create sequence financial_institution_seq;

create sequence interest_seq;

create sequence occupation_seq;

create sequence user_seq;

create sequence video_seq;

create sequence watched_video_seq;

create sequence watching_video_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists balance;

drop table if exists committed_balance;

drop table if exists consumer_profile;

drop table if exists credit_card_account;

drop table if exists financial_institution;

drop table if exists interest;

drop table if exists occupation;

drop table if exists user;

drop table if exists video;

drop table if exists watched_video;

drop table if exists watching_video;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists balance_seq;

drop sequence if exists committed_balance_seq;

drop sequence if exists consumer_profile_seq;

drop sequence if exists credit_card_account_seq;

drop sequence if exists financial_institution_seq;

drop sequence if exists interest_seq;

drop sequence if exists occupation_seq;

drop sequence if exists user_seq;

drop sequence if exists video_seq;

drop sequence if exists watched_video_seq;

drop sequence if exists watching_video_seq;

