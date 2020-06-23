create table logo
(
	id int auto_increment,
	logo_url varchar(100) null,
	create_time datetime null,
	active_flag int default 1 null comment '是否激活',
	constraint logo_pk
		primary key (id)
)
comment 'logo信息表';

----------------- 200515---------------
alter table logo add padding_left int null comment '向右移动的像素';

