create table user
(
	id int auto_increment,
	username varchar(20) not null,
	password varchar(20) not null,
	create_time datetime null,
	update_time datetime null,
	constraint user_pk
		primary key (id)
)
comment '用户表';

create unique index user_username_uindex
	on user (username);

INSERT INTO `user` (`id`, `username`, `password`, `create_time`, `update_time`) VALUES ('1', 'zblsy', 'zblsy123.', '2020-04-29 14:30:48', '2020-04-29 14:30:50');
