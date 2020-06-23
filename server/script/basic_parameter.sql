create table basic_parameter (
id                int(10) primary key not null auto_increment,
param_type        varchar(50) not null  comment '参数组的type',
param_name        varchar(100) comment '参数名',
param_key         varchar(50) not null comment '参数key，param_type + param_key确定唯一数据',
param_value       varchar(100) not null comment '参数值',
lan_code          int(1) default 1 comment '语言，1中文，2英文',
order_num         int(3) not null comment '顺序，按照所填数字排序',
remark            varchar(200) comment '备注',
add_no            varchar(50) default '000001' not null comment '添加人编号',
add_name          varchar(50) default 'system' not null comment '添加人姓名',
add_time          DATETIME not null comment '添加时间',
update_no         varchar(50) comment '修改人编号',
update_name       varchar(50) comment '修改人姓名',
update_time       DATETIME comment '修改时间'
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment='参数表';
