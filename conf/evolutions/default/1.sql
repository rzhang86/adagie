# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table balance (
  username                  varchar(255) not null,
  amount                    bigint,
  constraint pk_balance primary key (username))
;

create table balance2 (
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
  email1                    varchar(255),
  phone1                    varchar(255),
  address2street1           varchar(255),
  address2street2           varchar(255),
  address2city              varchar(255),
  address2state             varchar(255),
  address2zip               varchar(255),
  address2latitude          double,
  address2longitude         double,
  email2                    varchar(255),
  phone2                    varchar(255),
  profession1               integer,
  profession2               integer,
  interest1                 integer,
  interest2                 integer,
  interest3                 integer,
  interest4                 integer,
  interest5                 integer,
  amount                    bigint,
  constraint pk_balance2 primary key (password, first_name, middle_name, last_name, birthday, gender, address1street1, address1street2, address1city, address1state, address1zip, address1latitude, address1longitude, email1, phone1, address2street1, address2street2, address2city, address2state, address2zip, address2latitude, address2longitude, email2, phone2, profession1, profession2, interest1, interest2, interest3, interest4, interest5))
;

create table committed_balance (
  username                  varchar(255) not null,
  amount                    bigint,
  constraint pk_committed_balance primary key (username))
;

create table consumer_profile (
  username                  varchar(255) not null,
  a7                        bigint,
  a30                       bigint,
  a365                      bigint,
  f7                        integer,
  f30                       integer,
  f365                      integer,
  constraint pk_consumer_profile primary key (username))
;

create table credit_card_account (
  id                        bigint not null,
  user_username             varchar(255),
  financial_institution_id  bigint,
  ofx_user                  varchar(255),
  ofx_password              varchar(255),
  cc_number                 varchar(255),
  constraint pk_credit_card_account primary key (id))
;

create table financial_institution (
  id                        bigint not null,
  name                      varchar(255),
  url                       varchar(255),
  org                       varchar(255),
  fid                       varchar(255),
  constraint pk_financial_institution primary key (id))
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
  email1                    varchar(255),
  phone1                    varchar(255),
  address2street1           varchar(255),
  address2street2           varchar(255),
  address2city              varchar(255),
  address2state             varchar(255),
  address2zip               varchar(255),
  address2latitude          double,
  address2longitude         double,
  email2                    varchar(255),
  phone2                    varchar(255),
  profession1               integer,
  profession2               integer,
  interest1                 integer,
  interest2                 integer,
  interest3                 integer,
  interest4                 integer,
  interest5                 integer,
  constraint pk_user primary key (username))
;

create table video (
  id                        bigint not null,
  user_username             varchar(255),
  title                     varchar(255),
  description               varchar(255),
  duration                  integer,
  pay_formula               varchar(255),
  constraint pk_video primary key (id))
;

create table watched_video (
  id                        bigint not null,
  user_username             varchar(255),
  video_id                  bigint,
  start_time                timestamp,
  end_time                  timestamp,
  payout                    bigint,
  constraint pk_watched_video primary key (id))
;

create table watching_video (
  username                  varchar(255) not null,
  video_id                  bigint,
  start_time                timestamp,
  payout                    bigint,
  constraint pk_watching_video primary key (username))
;

create sequence balance_seq;

create sequence balance2_seq;

create sequence committed_balance_seq;

create sequence consumer_profile_seq;

create sequence credit_card_account_seq;

create sequence financial_institution_seq;

create sequence user_seq;

create sequence video_seq;

create sequence watched_video_seq;

create sequence watching_video_seq;

alter table credit_card_account add constraint fk_credit_card_account_user_1 foreign key (user_username) references user (username) on delete restrict on update restrict;
create index ix_credit_card_account_user_1 on credit_card_account (user_username);
alter table credit_card_account add constraint fk_credit_card_account_financi_2 foreign key (financial_institution_id) references financial_institution (id) on delete restrict on update restrict;
create index ix_credit_card_account_financi_2 on credit_card_account (financial_institution_id);
alter table video add constraint fk_video_user_3 foreign key (user_username) references user (username) on delete restrict on update restrict;
create index ix_video_user_3 on video (user_username);
alter table watched_video add constraint fk_watched_video_user_4 foreign key (user_username) references user (username) on delete restrict on update restrict;
create index ix_watched_video_user_4 on watched_video (user_username);
alter table watched_video add constraint fk_watched_video_video_5 foreign key (video_id) references video (id) on delete restrict on update restrict;
create index ix_watched_video_video_5 on watched_video (video_id);
alter table watching_video add constraint fk_watching_video_video_6 foreign key (video_id) references video (id) on delete restrict on update restrict;
create index ix_watching_video_video_6 on watching_video (video_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists balance;

drop table if exists balance2;

drop table if exists committed_balance;

drop table if exists consumer_profile;

drop table if exists credit_card_account;

drop table if exists financial_institution;

drop table if exists user;

drop table if exists video;

drop table if exists watched_video;

drop table if exists watching_video;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists balance_seq;

drop sequence if exists balance2_seq;

drop sequence if exists committed_balance_seq;

drop sequence if exists consumer_profile_seq;

drop sequence if exists credit_card_account_seq;

drop sequence if exists financial_institution_seq;

drop sequence if exists user_seq;

drop sequence if exists video_seq;

drop sequence if exists watched_video_seq;

drop sequence if exists watching_video_seq;

