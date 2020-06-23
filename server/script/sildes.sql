create table sildes
(
    id  int not null primary key AUTO_INCREMENT,
    img_url varchar(100) not null comment '图片地址',
    target_url varchar(200) comment '点击图片跳转地址',
    title   varchar(100) comment '图片标题',
    content varchar(500) comment '图片文字内容',
    active_flag tinyint default 1 not null comment '是否生效。0否1是',
    page_type tinyint not null comment '页面类型。对应关系代码中找',
    order_num smallint comment '顺序，数字小在前',
    group_id tinyint not null comment '区分同一页面内的哪个轮播组件，123..来表示',
    create_time datetime comment '图片上传时间'
);


INSERT INTO `sildes` (`id`, `img_url`, `target_url`, `title`, `content`, `active_flag`, `page_type`, `order_num`, `group_id`, `create_time`) VALUES ('1', 'http://a3.att.hudong.com/14/75/01300000164186121366756803686.jpg', NULL, '中博1345', '大大7645123123123235999999', '1', '1', '1', '1', '2020-04-26 13:38:08');
INSERT INTO `sildes` (`id`, `img_url`, `target_url`, `title`, `content`, `active_flag`, `page_type`, `order_num`, `group_id`, `create_time`) VALUES ('2', 'http://a0.att.hudong.com/64/76/20300001349415131407760417677.jpg', NULL, '666666666666666', '88888888888888888', '1', '1', '1', '1', '2020-04-26 13:40:36');

#------------200507------------------
alter table sildes modify content text null comment '图片文字内容';
