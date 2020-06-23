----------20200519-------------
create table article (
id                int(10) primary key not null auto_increment,
article_title     varchar(200) comment '文章标题',
page_type           int(10) not null  comment '页面分类',
page_name         varchar(100) comment '页面分类名',
group_id           int(10) not null  comment '页面内的组件',
group_name         varchar(100) comment '页面内的组件名',
content           longtext,
active_flag       tinyint(1) default 0 comment '是否激活。0禁用，1激活',
add_time          DATETIME not null comment '添加时间',
update_time       DATETIME comment '修改时间'
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment='文章表';