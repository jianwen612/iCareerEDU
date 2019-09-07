/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/3/16 18:10:06                           */
/*==============================================================*/


drop table if exists ad_check;

drop table if exists administrator;

drop table if exists advertisment;

drop table if exists apply;

drop table if exists company;

drop table if exists company_check;

drop table if exists consist;

drop table if exists course;

drop table if exists employ_question;

drop table if exists interview;

drop table if exists participate;

drop table if exists receive;

drop table if exists subject;

drop table if exists take;

drop table if exists teacher;

drop table if exists teacher_check;

drop table if exists test;

drop table if exists test_question;

drop table if exists user;

drop table if exists video;

/*==============================================================*/
/* Table: ad_check                                              */
/*==============================================================*/
create table ad_check
(
   ad_check_ad_id       varchar(32) not null,
   ad_check_admin_id    varchar(32) not null,
   ispassed             bool,
   priority             int,
   primary key (ad_check_ad_id, ad_check_admin_id)
);

/*==============================================================*/
/* Table: administrator                                         */
/*==============================================================*/
create table administrator
(
   admin_id             varchar(32) not null,
   admin_pswd           varchar(32) not null,
   admin_email          varchar(64) not null,
   primary key (admin_id)
);

/*==============================================================*/
/* Table: advertisment                                          */
/*==============================================================*/
create table advertisment
(
   ad_id                varchar(32) not null,
   ad_company_id        varchar(32) not null,
   ad_title             varchar(64) not null,
   ad_content           text not null,
   ad_status            bool not null,
   primary key (ad_id)
);

/*==============================================================*/
/* Table: apply                                                 */
/*==============================================================*/
create table apply
(
   apply_user_id        varchar(32) not null,
   apply_ad_id          varchar(32) not null,
   statement            text,
   apply_date           time,
   ispassed             bool,
   primary key (apply_user_id, apply_ad_id)
);

/*==============================================================*/
/* Table: company                                               */
/*==============================================================*/
create table company
(
   company_id           varchar(32) not null,
   company_name         varchar(16) not null,
   company_email        varchar(64) not null,
   company_pswd         varchar(32) not null,
   company_licence      longblob not null,
   company_introduction text not null,
   company_licence_no   varchar(32) not null,
   company_status       bool not null,
   company_phone_no     varchar(32) not null,
   primary key (company_id)
);

/*==============================================================*/
/* Table: company_check                                         */
/*==============================================================*/
create table company_check
(
   company_check_company_id varchar(32) not null,
   company_check_admin_id varchar(32) not null,
   ispassed             bool,
   primary key (company_check_company_id, company_check_admin_id)
);

/*==============================================================*/
/* Table: consist                                               */
/*==============================================================*/
create table consist
(
   consist_question_id  varchar(32) not null,
   consist_test_id      varchar(32) not null,
   primary key (consist_question_id, consist_test_id)
);

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course
(
   course_id            varchar(32) not null,
   course_teacher_id    varchar(32) not null,
   course_subject_id    varchar(32) not null,
   course_name          varchar(64) not null,
   course_introduction  text not null,
   course_reg_date      date not null,
   course_start_date    date not null,
   course_end_date      date not null,
   course_times         int not null,
   primary key (course_id)
);

/*==============================================================*/
/* Table: employ_question                                       */
/*==============================================================*/
create table employ_question
(
   employ_question_id   varchar(32) not null,
   employ_company_id    varchar(32) not null,
   employ_question_name varchar(1024) not null,
   employ_question_answer varchar(2048) not null,
   primary key (employ_question_id)
);

/*==============================================================*/
/* Table: interview                                             */
/*==============================================================*/
create table interview
(
   interview_id         varchar(32) not null,
   interview_company_id varchar(32) not null,
   interview_name       varchar(256) not null,
   interview_position   varchar(64) not null,
   interview_company    varchar(16) not null,
   interview_content    varchar(1024) not null,
   interview_time       datetime not null,
   primary key (interview_id)
);

/*==============================================================*/
/* Table: participate                                           */
/*==============================================================*/
create table participate
(
   participate_test_id  varchar(32) not null,
   participate_user_id  varchar(32) not null,
   participate_time     datetime,
   grade                int,
   primary key (participate_test_id, participate_user_id)
);

/*==============================================================*/
/* Table: receive                                               */
/*==============================================================*/
create table receive
(
   receive_user_id      varchar(32) not null,
   receive_interview_id varchar(32) not null,
   istaken              bool,
   primary key (receive_user_id, receive_interview_id)
);

/*==============================================================*/
/* Table: subject                                               */
/*==============================================================*/
create table subject
(
   subject_id           varchar(32) not null,
   subject_name         varchar(256) not null,
   primary key (subject_id)
);

/*==============================================================*/
/* Table: take                                                  */
/*==============================================================*/
create table take
(
   take_course_id       varchar(32) not null,
   take_user_id         varchar(32) not null,
   primary key (take_course_id, take_user_id)
);

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher
(
   teacher_id           varchar(32) not null,
   teacher_name         varchar(16) not null,
   teacher_email        varchar(64) not null,
   teacher_pswd         varchar(32) not null,
   teacher_sex          bool not null,
   teacher_certificate  longblob not null,
   teacher_introduction text,
   teacher_university   varchar(24),
   teacher_uni_empno    char(32),
   teacher_status       bool not null,
   primary key (teacher_id)
);

/*==============================================================*/
/* Table: teacher_check                                         */
/*==============================================================*/
create table teacher_check
(
   teacher_check_teacher_id varchar(32) not null,
   teacher_check_admin_id varchar(32) not null,
   ispassed             bool,
   primary key (teacher_check_teacher_id, teacher_check_admin_id)
);

/*==============================================================*/
/* Table: test                                                  */
/*==============================================================*/
create table test
(
   test_id              varchar(32) not null,
   test_course_id       varchar(32) not null,
   test_name            varchar(64) not null,
   primary key (test_id)
);

/*==============================================================*/
/* Table: test_question                                         */
/*==============================================================*/
create table test_question
(
   question_id          varchar(32) not null,
   question_subject_id  varchar(32) not null,
   question_name        varchar(1024) not null,
   question_answer      varchar(2048) not null,
   question_type        varchar(256) not null,
   primary key (question_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              varchar(32) not null,
   user_name            varchar(16),
   user_email           varchar(64),
   user_pswd            varchar(32),
   user_sex             bool,
   user_introduction    text,
   user_birthday        date,
   primary key (user_id)
);

/*==============================================================*/
/* Table: video                                                 */
/*==============================================================*/
create table video
(
   video_id             varchar(32) not null,
   video_course_id      varchar(32) not null,
   video_name           varchar(64) not null,
   video_introduction   text not null,
   video_length         time not null,
   video_upload_date    date not null,
   video_play_count     int not null,
   primary key (video_id)
);

alter table ad_check add constraint FK_ad_check foreign key (ad_check_admin_id)
      references administrator (admin_id) on delete restrict on update restrict;

alter table ad_check add constraint FK_ad_check foreign key (ad_check_ad_id)
      references advertisment (ad_id) on delete restrict on update restrict;

alter table advertisment add constraint FK_advertise foreign key (ad_company_id)
      references company (company_id) on delete restrict on update restrict;

alter table apply add constraint FK_apply foreign key (apply_ad_id)
      references advertisment (ad_id) on delete restrict on update restrict;

alter table apply add constraint FK_apply foreign key (apply_user_id)
      references user (user_id) on delete restrict on update restrict;

alter table company_check add constraint FK_company_check foreign key (company_check_admin_id)
      references administrator (admin_id) on delete restrict on update restrict;

alter table company_check add constraint FK_company_check foreign key (company_check_company_id)
      references company (company_id) on delete restrict on update restrict;

alter table consist add constraint FK_consist foreign key (consist_test_id)
      references test (test_id) on delete restrict on update restrict;

alter table consist add constraint FK_consist foreign key (consist_question_id)
      references test_question (question_id) on delete restrict on update restrict;

alter table course add constraint FK_include foreign key (course_subject_id)
      references subject (subject_id) on delete restrict on update restrict;

alter table course add constraint FK_teach foreign key (course_teacher_id)
      references teacher (teacher_id) on delete restrict on update restrict;

alter table employ_question add constraint FK_store foreign key (employ_company_id)
      references company (company_id) on delete restrict on update restrict;

alter table interview add constraint FK_issue foreign key (interview_company_id)
      references company (company_id) on delete restrict on update restrict;

alter table participate add constraint FK_participate foreign key (participate_test_id)
      references test (test_id) on delete restrict on update restrict;

alter table participate add constraint FK_participate foreign key (participate_user_id)
      references user (user_id) on delete restrict on update restrict;

alter table receive add constraint FK_receive foreign key (receive_interview_id)
      references interview (interview_id) on delete restrict on update restrict;

alter table receive add constraint FK_receive foreign key (receive_user_id)
      references user (user_id) on delete restrict on update restrict;

alter table take add constraint FK_take foreign key (take_course_id)
      references course (course_id) on delete restrict on update restrict;

alter table take add constraint FK_take foreign key (take_user_id)
      references user (user_id) on delete restrict on update restrict;

alter table teacher_check add constraint FK_teacher_check foreign key (teacher_check_admin_id)
      references administrator (admin_id) on delete restrict on update restrict;

alter table teacher_check add constraint FK_teacher_check foreign key (teacher_check_teacher_id)
      references teacher (teacher_id) on delete restrict on update restrict;

alter table test add constraint FK_setup foreign key (test_course_id)
      references course (course_id) on delete restrict on update restrict;

alter table test_question add constraint FK_has foreign key (question_subject_id)
      references subject (subject_id) on delete restrict on update restrict;

alter table video add constraint FK_belong foreign key (video_course_id)
      references course (course_id) on delete restrict on update restrict;

