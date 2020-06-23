create table footer
(
	id int auto_increment,
	title varchar(50) null comment '标题',
	text1 varchar(100) null,
	text2 varchar(100) null,
	text3 varchar(100) null,
	text4 varchar(100) null,
	text5 varchar(100) null,
	bg_color varchar(30) null comment '背景色',
	font_color varchar(30) null comment '字体颜色',
	constraint footer_pk
		primary key (id)
)
comment '页面footer';