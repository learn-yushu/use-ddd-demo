CREATE TABLE t_order_complaint_flow_mapping_0(
    id BIGINT(64) NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    ctime DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
    mtime DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间' ,
    deleted INT(1) NOT NULL  DEFAULT 0 COMMENT '是否删除' ,
    flow_id BIGINT(64) NOT NULL  DEFAULT 0 COMMENT '工作流id' ,
    flow_detail_id BIGINT(64) NOT NULL  DEFAULT 0 COMMENT '工作流明细id' ,
    is_active_flow INT(1) NOT NULL  DEFAULT 0 COMMENT '是否开启工作流' ,
    flow_status VARCHAR(128) NOT NULL  DEFAULT 'init' COMMENT '工作流状态;init-初始化,processing-处理中, approved-已审批' ,
    PRIMARY KEY (id)
)  COMMENT = '支付订单补单工作流映射表';


CREATE TABLE t_order_complaint_flow_mapping_1(
    id BIGINT(64) NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    ctime DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
    mtime DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间' ,
    deleted INT(1) NOT NULL  DEFAULT 0 COMMENT '是否删除' ,
    flow_id BIGINT(64) NOT NULL  DEFAULT 0 COMMENT '工作流id' ,
    flow_detail_id BIGINT(64) NOT NULL  DEFAULT 0 COMMENT '工作流明细id' ,
    is_active_flow INT(1) NOT NULL  DEFAULT 0 COMMENT '是否开启工作流' ,
    flow_status VARCHAR(128) NOT NULL  DEFAULT 'init' COMMENT '工作流状态;init-初始化,processing-处理中, approved-已审批' ,
    PRIMARY KEY (id)
)  COMMENT = '支付订单补单工作流映射表';


create table t_order
(
    id       bigint(64) auto_increment comment '主键'
        primary key,
    ctime    datetime    default current_timestamp() not null comment '创建时间',
    mtime    datetime    default current_timestamp() not null comment '更新时间',
    deleted  int(1)      default 0                   not null comment '是否删除',
    order_id varchar(64) default ''                  not null,
    version  int         default 0                   not null comment '是否开启工作流'
) comment '订单表';


create table t_sharding_user
(
    id       bigint(64) auto_increment comment '主键' primary key,
    ctime    datetime    default current_timestamp() not null comment '创建时间',
    mtime    datetime    default current_timestamp() not null comment '更新时间',
    deleted  int(1)      default 0                   not null comment '是否删除',
    user_Id varchar(64) default ''                  not null,
    version  int         default 0                   not null comment '是否开启工作流'
) comment '用户表';

