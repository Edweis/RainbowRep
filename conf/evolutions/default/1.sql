# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table project (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  folder                        varchar(255),
  constraint pk_project primary key (id)
);

create table project_user (
  project_id                    bigint not null,
  user_email                    varchar(255) not null,
  constraint pk_project_user primary key (project_id,user_email)
);

create table task (
  id                            bigint auto_increment not null,
  title                         varchar(255),
  done                          tinyint(1) default 0,
  due_date                      datetime(6),
  assigned_to_email             varchar(255),
  folder                        varchar(255),
  project_id                    bigint,
  constraint pk_task primary key (id)
);

create table user (
  email                         varchar(255) not null,
  name                          varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (email)
);

alter table project_user add constraint fk_project_user_project foreign key (project_id) references project (id) on delete restrict on update restrict;
create index ix_project_user_project on project_user (project_id);

alter table project_user add constraint fk_project_user_user foreign key (user_email) references user (email) on delete restrict on update restrict;
create index ix_project_user_user on project_user (user_email);

alter table task add constraint fk_task_assigned_to_email foreign key (assigned_to_email) references user (email) on delete restrict on update restrict;
create index ix_task_assigned_to_email on task (assigned_to_email);

alter table task add constraint fk_task_project_id foreign key (project_id) references project (id) on delete restrict on update restrict;
create index ix_task_project_id on task (project_id);


# --- !Downs

alter table project_user drop foreign key fk_project_user_project;
drop index ix_project_user_project on project_user;

alter table project_user drop foreign key fk_project_user_user;
drop index ix_project_user_user on project_user;

alter table task drop foreign key fk_task_assigned_to_email;
drop index ix_task_assigned_to_email on task;

alter table task drop foreign key fk_task_project_id;
drop index ix_task_project_id on task;

drop table if exists project;

drop table if exists project_user;

drop table if exists task;

drop table if exists user;

