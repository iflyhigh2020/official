create table list_show
(
    id  int not null primary key AUTO_INCREMENT,
    img_url varchar(100) not null comment '图片地址',
    target_url varchar(200) comment '点击跳转地址',
    title   varchar(100) comment '标题',
    content varchar(500) comment '文字内容',
    active_flag tinyint default 1 not null comment '是否生效。0否1是',
    page_type tinyint not null comment '页面类型。对应关系代码中找',
    order_num smallint comment '顺序，数字小在前',
    group_id tinyint not null comment '区分同一页面内的哪个列表组件，123..来表示',
    create_time datetime comment '创建时间'
);



INSERT INTO `list_show` (`id`, `img_url`, `target_url`, `title`, `content`, `active_flag`, `page_type`, `order_num`, `group_id`, `create_time`) VALUES ('1', 'http://pic.616pic.com/ys_bnew_img/00/40/03/Ay5NF7tE2p.jpg', NULL, '核心优势111', '摊位费多少524人', '1', '1', '1', '1', '2020-04-26 13:38:08');
INSERT INTO `list_show` (`id`, `img_url`, `target_url`, `title`, `content`, `active_flag`, `page_type`, `order_num`, `group_id`, `create_time`) VALUES ('2', 'http://image.biaobaiju.com/uploads/20190504/20/1556973965-AEJxpgRBYN.jpeg', NULL, '核心优势222', '他打', '1', '1', '1', '1', '2020-04-26 13:40:36');
INSERT INTO `list_show` (`id`, `img_url`, `target_url`, `title`, `content`, `active_flag`, `page_type`, `order_num`, `group_id`, `create_time`) VALUES ('3', 'http://pic42.photophoto.cn/20170106/0005018670919919_b.jpg', NULL, '66666', '基金会官方33', '1', '1', '1', '1', '2020-04-26 13:40:36');
INSERT INTO `list_show` (`id`, `img_url`, `target_url`, `title`, `content`, `active_flag`, `page_type`, `order_num`, `group_id`, `create_time`) VALUES ('4', 'http://pic.616pic.com/ys_bnew_img/00/40/03/Ay5NF7tE2p.jpg', NULL, '凄凄切切群群群群群群群', '摊位费多少524人', '1', '1', '1', '1', '2020-04-26 13:38:08');


# --------200507-----------
alter table list_show modify content mediumtext null comment '文字内容';



