create table slides_info
(
    id  int not null primary key AUTO_INCREMENT,
    height smallint comment '高度像素，单位px',
    width  tinyint comment '宽度百分比，范围0-100',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间',
    active_flag tinyint default 1 not null comment '是否生效。0否1是',
    page_type tinyint not null comment '页面类型。对应关系代码中找',
    group_id tinyint not null comment '区分同一页面内的哪个轮播组件，123..来表示'
);
