# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table challenge_question (
  id                        bigint not null,
  value                     varchar(255),
  constraint uq_challenge_question_value unique (value),
  constraint pk_challenge_question primary key (id))
;

create table expense_category (
  id                        bigint not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_expense_category_code unique (code),
  constraint uq_expense_category_name unique (name),
  constraint pk_expense_category primary key (id))
;

create table expense_subcategory (
  id                        bigint not null,
  expense_category_id       bigint,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_expense_subcategory_code unique (code),
  constraint uq_expense_subcategory_name unique (name),
  constraint pk_expense_subcategory primary key (id))
;

create table financial_institution (
  id                        bigint not null,
  intuit_id                 bigint,
  name                      varchar(255),
  url                       varchar(255),
  phone                     varchar(255),
  address1                  varchar(255),
  address2                  varchar(255),
  address3                  varchar(255),
  city                      varchar(255),
  state                     varchar(255),
  postal_code               varchar(255),
  country                   varchar(255),
  currency_code             varchar(255),
  username_key              varchar(255),
  password_key              varchar(255),
  constraint uq_financial_institution_intuit_ unique (intuit_id),
  constraint pk_financial_institution primary key (id))
;

create table financial_institution_login (
  id                        bigint not null,
  user_id                   bigint,
  financial_institution_id  bigint,
  username                  varchar(255),
  password                  varchar(255),
  constraint pk_financial_institution_login primary key (id))
;

create table interest (
  id                        bigint not null,
  name                      varchar(255),
  constraint uq_interest_name unique (name),
  constraint pk_interest primary key (id))
;

create table login_challenge (
  id                        bigint not null,
  financial_institution_login_id bigint,
  challenge_question_id     bigint,
  answer                    varchar(255),
  constraint pk_login_challenge primary key (id))
;

create table occupation (
  id                        bigint not null,
  name                      varchar(255),
  constraint uq_occupation_name unique (name),
  constraint pk_occupation primary key (id))
;

create table payout_formula (
  id                        bigint not null,
  video_id                  bigint,
  condition                 varchar(255),
  result                    varchar(255),
  constraint pk_payout_formula primary key (id))
;

create table user (
  id                        bigint not null,
  watching_video_id         bigint,
  username                  varchar(255),
  password                  varchar(255),
  email                     varchar(255),
  gender                    varchar(255),
  birthyear                 integer,
  balance                   bigint,
  committed_balance         bigint,
  watching_start_time       bigint,
  watching_end_time         bigint,
  watching_payout           bigint,
  constraint uq_user_username unique (username),
  constraint pk_user primary key (id))
;

create table user_variable (
  id                        bigint not null,
  user_id                   bigint,
  code                      varchar(255),
  timepoint                 integer,
  is_debit                  boolean,
  amount                    bigint,
  frequency                 integer,
  constraint pk_user_variable primary key (id))
;

create table video (
  id                        bigint not null,
  user_id                   bigint,
  title                     varchar(255),
  description               varchar(255),
  duration                  integer,
  constraint pk_video primary key (id))
;

create table watched_video (
  id                        bigint not null,
  user_id                   bigint,
  video_id                  bigint,
  start_time                bigint,
  end_time                  bigint,
  payout                    bigint,
  constraint pk_watched_video primary key (id))
;

create table zip (
  id                        bigint not null,
  zip_code                  varchar(255),
  zip_code_type             varchar(255),
  city                      varchar(255),
  state                     varchar(255),
  location_type             varchar(255),
  latitude                  varchar(255),
  longitude                 varchar(255),
  location                  varchar(255),
  decommisioned             varchar(255),
  tax_returns_filed         varchar(255),
  estimated_population      varchar(255),
  total_wages               varchar(255),
  constraint uq_zip_zip_code unique (zip_code),
  constraint pk_zip primary key (id))
;


create table user_occupation (
  user_id                        bigint not null,
  occupation_id                  bigint not null,
  constraint pk_user_occupation primary key (user_id, occupation_id))
;

create table user_interest (
  user_id                        bigint not null,
  interest_id                    bigint not null,
  constraint pk_user_interest primary key (user_id, interest_id))
;

create table user_zip (
  user_id                        bigint not null,
  zip_id                         bigint not null,
  constraint pk_user_zip primary key (user_id, zip_id))
;
create sequence challenge_question_seq;

create sequence expense_category_seq;

create sequence expense_subcategory_seq;

create sequence financial_institution_seq;

create sequence financial_institution_login_seq;

create sequence interest_seq;

create sequence login_challenge_seq;

create sequence occupation_seq;

create sequence payout_formula_seq;

create sequence user_seq;

create sequence user_variable_seq;

create sequence video_seq;

create sequence watched_video_seq;

create sequence zip_seq;

alter table expense_subcategory add constraint fk_expense_subcategory_expense_1 foreign key (expense_category_id) references expense_category (id) on delete restrict on update restrict;
create index ix_expense_subcategory_expense_1 on expense_subcategory (expense_category_id);
alter table financial_institution_login add constraint fk_financial_institution_login_2 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_financial_institution_login_2 on financial_institution_login (user_id);
alter table financial_institution_login add constraint fk_financial_institution_login_3 foreign key (financial_institution_id) references financial_institution (id) on delete restrict on update restrict;
create index ix_financial_institution_login_3 on financial_institution_login (financial_institution_id);
alter table login_challenge add constraint fk_login_challenge_financialIn_4 foreign key (financial_institution_login_id) references financial_institution_login (id) on delete restrict on update restrict;
create index ix_login_challenge_financialIn_4 on login_challenge (financial_institution_login_id);
alter table login_challenge add constraint fk_login_challenge_challengeQu_5 foreign key (challenge_question_id) references challenge_question (id) on delete restrict on update restrict;
create index ix_login_challenge_challengeQu_5 on login_challenge (challenge_question_id);
alter table payout_formula add constraint fk_payout_formula_video_6 foreign key (video_id) references video (id) on delete restrict on update restrict;
create index ix_payout_formula_video_6 on payout_formula (video_id);
alter table user add constraint fk_user_watchingVideo_7 foreign key (watching_video_id) references video (id) on delete restrict on update restrict;
create index ix_user_watchingVideo_7 on user (watching_video_id);
alter table user_variable add constraint fk_user_variable_user_8 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_user_variable_user_8 on user_variable (user_id);
alter table video add constraint fk_video_user_9 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_video_user_9 on video (user_id);
alter table watched_video add constraint fk_watched_video_user_10 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_watched_video_user_10 on watched_video (user_id);
alter table watched_video add constraint fk_watched_video_video_11 foreign key (video_id) references video (id) on delete restrict on update restrict;
create index ix_watched_video_video_11 on watched_video (video_id);



alter table user_occupation add constraint fk_user_occupation_user_01 foreign key (user_id) references user (id) on delete restrict on update restrict;

alter table user_occupation add constraint fk_user_occupation_occupation_02 foreign key (occupation_id) references occupation (id) on delete restrict on update restrict;

alter table user_interest add constraint fk_user_interest_user_01 foreign key (user_id) references user (id) on delete restrict on update restrict;

alter table user_interest add constraint fk_user_interest_interest_02 foreign key (interest_id) references interest (id) on delete restrict on update restrict;

alter table user_zip add constraint fk_user_zip_user_01 foreign key (user_id) references user (id) on delete restrict on update restrict;

alter table user_zip add constraint fk_user_zip_zip_02 foreign key (zip_id) references zip (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists challenge_question;

drop table if exists expense_category;

drop table if exists expense_subcategory;

drop table if exists financial_institution;

drop table if exists financial_institution_login;

drop table if exists interest;

drop table if exists user_interest;

drop table if exists login_challenge;

drop table if exists occupation;

drop table if exists user_occupation;

drop table if exists payout_formula;

drop table if exists user;

drop table if exists user_zip;

drop table if exists user_variable;

drop table if exists video;

drop table if exists watched_video;

drop table if exists zip;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists challenge_question_seq;

drop sequence if exists expense_category_seq;

drop sequence if exists expense_subcategory_seq;

drop sequence if exists financial_institution_seq;

drop sequence if exists financial_institution_login_seq;

drop sequence if exists interest_seq;

drop sequence if exists login_challenge_seq;

drop sequence if exists occupation_seq;

drop sequence if exists payout_formula_seq;

drop sequence if exists user_seq;

drop sequence if exists user_variable_seq;

drop sequence if exists video_seq;

drop sequence if exists watched_video_seq;

drop sequence if exists zip_seq;

