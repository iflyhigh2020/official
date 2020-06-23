create table right_footer
(
	id int auto_increment,
	col1 varchar(100) null,
	col2 varchar(100) null,
	col3 varchar(100) null,
	col4 varchar(100) null,
	col5 varchar(100) null,
	col6 varchar(100) null,
	col7 varchar(100) null,
	col8 varchar(100) null,
	active_flag int default 1 null comment '是否激活',
	update_time datetime null,
	create_time datetime null,
	constraint right_footer_pk
		primary key (id)
)
comment '右侧固定悬浮栏';

