create table timeline
(
    id  int not null primary key AUTO_INCREMENT,
    title   varchar(500) comment '标题',
    title_en   varchar(200) comment '标题',
    bg_url varchar(100) comment '背景图地址，不填则无背景图',
    bg_color varchar(100) comment '背景图颜色，不填则无背景色',
    content varchar(500) comment '内容文字（预留一下）',
    active_flag tinyint default 1 not null comment '是否生效。0否1是',
    page_type tinyint not null comment '页面类型。对应关系代码中找',
    group_id tinyint not null comment '区分同一页面内的哪个组件，123..来表示',
    create_time datetime comment '创建时间'
);

create table timeline_detail
(
    id  int not null primary key AUTO_INCREMENT,
    timeline_id int not null comment '对应timeline.id',
    date_node   date not null comment '对应显示的时间节点',
    title  varchar(50) comment '显示的事件标题',
    content  varchar(400) comment '对应事件内容'
);