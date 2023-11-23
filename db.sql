create database db02;

use db02;

create table absent(
    id              int unsigned auto_increment comment 'ID'
        primary key,
    branch_id       int         not null,
    group_id        int         not null,
    employee_id     int         not null,
    branch_admin_id int         not null comment '管理員ID',
    create_date     varchar(20) not null comment '缺勤日期',
    reason          varchar(10) not null comment '缺勤事由'
)comment '員工缺勤表';

create table branch(
    id           int unsigned auto_increment comment 'ID'
        primary key,
    name         varchar(10) not null comment '分公司名稱',
    introduction varchar(20) not null comment '分公司簡介',
    admin_id     int         not null comment '分公司管理員ID',
    constraint region_name_uindex
        unique (name)
)comment '分公司表';

create table branch_admin(
    id        int unsigned auto_increment comment '員工管理員ID'
        primary key,
    username  varchar(20)                  not null comment '員工管理員姓名',
    password  varchar(32) default '123456' null comment '密碼',
    name      varchar(10)                  not null comment '姓名',
    gender    varchar(2)                   not null comment '性別',
    telephone varchar(32)                  not null comment '電話',
    constraint username
        unique (username)
)comment '分公司管理員表';

create table employee(
    id          int unsigned auto_increment comment '員工ID'
        primary key,
    number      varchar(10) not null comment '員工編號',
    name        varchar(10) not null comment '員工姓名',
    gender      varchar(2)  not null comment '性別',
    group_id    int         not null comment '小組ID',
    state       varchar(10) not null comment '在職狀態',
    create_date varchar(20) null comment '就職時間',
    constraint employee_number_uindex
        unique (number)
)comment '員工表';

create table `group`(
    id        int unsigned auto_increment comment 'ID'
        primary key,
    branch_id int         null,
    name      varchar(10) not null comment '小組ID',
    type      int         not null comment '最大人數',
    available int         not null comment '可增派人數',
    telephone varchar(20) not null comment '小組電話'
)comment '小組表';

create table moveout(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    employee_id int         not null,
    group_id    int         not null,
    reason      varchar(10) not null comment '離退原因',
    create_date varchar(20) not null comment '離退日期'
)comment '員工離退紀錄表';

create table system_admin(
    id        int unsigned auto_increment comment '系統管理員ID'
        primary key,
    username  varchar(20)                  not null comment '系統管理員姓名',
    password  varchar(32) default '123456' null comment '密碼',
    name      varchar(10)                  not null comment '姓名',
    telephone varchar(32)                  not null comment '電話',
    constraint username
        unique (username)
)comment '系統管理員表';
