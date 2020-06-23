create table img_text
(
    id  int not null primary key AUTO_INCREMENT,
    img_url varchar(100) not null comment '图片地址',
    title   varchar(100) comment '标题',
    content text comment '图片另一侧文字内容',
    active_flag tinyint default 1 not null comment '是否生效。0否1是',
    page_type tinyint not null comment '页面类型。对应关系代码中找',
    group_id tinyint not null comment '区分同一页面内的哪个图文组件，123..来表示',
    create_time datetime comment '创建时间'
);

INSERT INTO `img_text` (`id`, `img_url`, `title`, `content`, `active_flag`, `page_type`, `group_id`, `create_time`) VALUES ('1', 'http://pic.616pic.com/ys_bnew_img/00/40/03/Ay5NF7tE2p.jpg', '核心优势111', '摊位费多少524人', '1', '1', '1', '2020-04-26 13:38:08');
INSERT INTO `img_text` (`id`, `img_url`, `title`, `content`, `active_flag`, `page_type`, `group_id`, `create_time`) VALUES ('2', 'http://image.biaobaiju.com/uploads/20190504/20/1556973965-AEJxpgRBYN.jpeg', '核心优势222', '他打', '1', '1', '2', '2020-04-26 13:40:36');
INSERT INTO `img_text` (`id`, `img_url`, `title`, `content`, `active_flag`, `page_type`, `group_id`, `create_time`) VALUES ('3', 'http://pic42.photophoto.cn/20170106/0005018670919919_b.jpg', '66666', '基金会官方33', '1', '1', '3', '2020-04-26 13:40:36');
INSERT INTO `img_text` (`id`, `img_url`, `title`, `content`, `active_flag`, `page_type`, `group_id`, `create_time`) VALUES ('4', 'http://pic.616pic.com/ys_bnew_img/00/40/03/Ay5NF7tE2p.jpg', '凄凄切切群群群群群群群', '摊位费多少524人', '1', '1', '4', '2020-04-26 13:38:08');


alter table img_text modify content text null comment '图片另一侧文字内容';

-------------------200515----------------------
alter table img_text add height smallint null comment '高度，单位px';
alter table img_text add width tinyint null comment '宽度百分比';


