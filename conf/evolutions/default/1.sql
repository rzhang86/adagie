# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table balance (
  username                  varchar(255) not null,
  amount                    bigint,
  constraint pk_balance primary key (username))
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
  ofx_user                  varchar(255),
  ofx_password              varchar(255),
  fi_url                    varchar(255),
  fi_organization_name      varchar(255),
  fi_id                     varchar(255),
  cc_number                 varchar(255),
  constraint pk_credit_card_account primary key (id))
;

create table user (
  username                  varchar(255) not null,
  password                  varchar(255),
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

create sequence balance_seq;

create sequence committed_balance_seq;

create sequence consumer_profile_seq;

create sequence credit_card_account_seq;

create sequence user_seq;

create sequence video_seq;

create sequence watched_video_seq;

alter table credit_card_account add constraint fk_credit_card_account_user_1 foreign key (user_username) references user (username) on delete restrict on update restrict;
create index ix_credit_card_account_user_1 on credit_card_account (user_username);
alter table video add constraint fk_video_user_2 foreign key (user_username) references user (username) on delete restrict on update restrict;
create index ix_video_user_2 on video (user_username);
alter table watched_video add constraint fk_watched_video_user_3 foreign key (user_username) references user (username) on delete restrict on update restrict;
create index ix_watched_video_user_3 on watched_video (user_username);
alter table watched_video add constraint fk_watched_video_video_4 foreign key (video_id) references video (id) on delete restrict on update restrict;
create index ix_watched_video_video_4 on watched_video (video_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists balance;

drop table if exists committed_balance;

drop table if exists consumer_profile;

drop table if exists credit_card_account;

drop table if exists user;

drop table if exists video;

drop table if exists watched_video;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists balance_seq;

drop sequence if exists committed_balance_seq;

drop sequence if exists consumer_profile_seq;

drop sequence if exists credit_card_account_seq;

drop sequence if exists user_seq;

drop sequence if exists video_seq;

drop sequence if exists watched_video_seq;

