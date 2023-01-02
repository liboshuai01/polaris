ALTER TABLE polaris_dev.sys_user_role ADD COLUMN create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE polaris_dev.sys_user_role ADD COLUMN create_by varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人';
ALTER TABLE polaris_dev.sys_user_role ADD COLUMN update_time datetime DEFAULT NULL COMMENT '修改时间';
ALTER TABLE polaris_dev.sys_user_role ADD COLUMN update_by varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人';

ALTER TABLE polaris_dev.sys_tenant ADD COLUMN update_time datetime DEFAULT NULL COMMENT '修改时间';
ALTER TABLE polaris_dev.sys_tenant ADD COLUMN update_by varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人';