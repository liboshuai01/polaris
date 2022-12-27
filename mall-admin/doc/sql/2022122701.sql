ALTER TABLE `cms_help` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `cms_help` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `cms_help` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `cms_help` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `cms_help` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `cms_help_category` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `cms_help_category` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `cms_help_category` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `cms_help_category` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `cms_help_category` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `cms_member_report` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `cms_member_report` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `cms_member_report` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `cms_member_report` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `cms_member_report` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `cms_prefrence_area` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `cms_prefrence_area` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `cms_prefrence_area` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `cms_prefrence_area` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `cms_prefrence_area` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `cms_prefrence_area_product_relation` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `cms_prefrence_area_product_relation` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `cms_prefrence_area_product_relation` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `cms_prefrence_area_product_relation` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `cms_prefrence_area_product_relation` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `cms_subject` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `cms_subject` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `cms_subject` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `cms_subject` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `cms_subject` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `cms_subject_category` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `cms_subject_category` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `cms_subject_category` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `cms_subject_category` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `cms_subject_category` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `cms_subject_comment` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `cms_subject_comment` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `cms_subject_comment` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `cms_subject_comment` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `cms_subject_comment` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `cms_subject_product_relation` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `cms_subject_product_relation` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `cms_subject_product_relation` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `cms_subject_product_relation` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `cms_subject_product_relation` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `cms_topic` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `cms_topic` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `cms_topic` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `cms_topic` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `cms_topic` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `cms_topic_category` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `cms_topic_category` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `cms_topic_category` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `cms_topic_category` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `cms_topic_category` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `cms_topic_comment` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `cms_topic_comment` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `cms_topic_comment` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `cms_topic_comment` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `cms_topic_comment` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `oms_cart_item` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `oms_cart_item` CHANGE create_date create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `oms_cart_item` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `oms_cart_item` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `oms_cart_item` CHANGE delete_status is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `oms_company_address` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `oms_company_address` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `oms_company_address` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `oms_company_address` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `oms_company_address` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `oms_order` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `oms_order` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `oms_order` ADD submission_time datetime DEFAULT NULL COMMENT '提交时间';
ALTER TABLE `oms_order` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `oms_order` CHANGE modify_time update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `oms_order` CHANGE delete_status is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `oms_order_item` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `oms_order_item` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `oms_order_item` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `oms_order_item` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `oms_order_item` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `oms_order_operate_history` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `oms_order_operate_history` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `oms_order_operate_history` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `oms_order_operate_history` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `oms_order_operate_history` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';


ALTER TABLE `oms_order_return_apply` ADD application_time datetime DEFAULT NULL COMMENT '申请时间';
ALTER TABLE `oms_order_return_apply` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `oms_order_return_apply` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `oms_order_return_apply` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `oms_order_return_apply` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `oms_order_return_apply` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `oms_order_return_reason` ADD add_time datetime DEFAULT NULL COMMENT '添加时间';
ALTER TABLE `oms_order_return_reason` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `oms_order_return_reason` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `oms_order_return_reason` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `oms_order_return_reason` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `oms_order_return_reason` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `oms_order_setting` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `oms_order_setting` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `oms_order_setting` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `oms_order_setting` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `oms_order_setting` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_album` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_album` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_album` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_album` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_album` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_album_pic` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_album_pic` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_album_pic` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_album_pic` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_album_pic` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_brand` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_brand` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_brand` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_brand` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_brand` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_comment` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_comment` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_comment` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_comment` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_comment` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_comment_replay` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_comment_replay` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_comment_replay` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_comment_replay` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_comment_replay` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_feight_template` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_feight_template` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_feight_template` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_feight_template` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_feight_template` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_member_price` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_member_price` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_member_price` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_member_price` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_member_price` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_product` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_product` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_product` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_product` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_product` CHANGE delete_status is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_product_attribute` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_product_attribute` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_product_attribute` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_product_attribute` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_product_attribute` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_product_attribute_category` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_product_attribute_category` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_product_attribute_category` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_product_attribute_category` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_product_attribute_category` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_product_attribute_value` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_product_attribute_value` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_product_attribute_value` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_product_attribute_value` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_product_attribute_value` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_product_category` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_product_category` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_product_category` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_product_category` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_product_category` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_product_category_attribute_relation` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_product_category_attribute_relation` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_product_category_attribute_relation` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_product_category_attribute_relation` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_product_category_attribute_relation` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_product_full_reduction` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_product_full_reduction` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_product_full_reduction` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_product_full_reduction` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_product_full_reduction` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_product_ladder` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_product_ladder` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_product_ladder` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_product_ladder` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_product_ladder` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_product_operate_log` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_product_operate_log` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_product_operate_log` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_product_operate_log` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_product_operate_log` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_product_vertify_record` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_product_vertify_record` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_product_vertify_record` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_product_vertify_record` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_product_vertify_record` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `pms_sku_stock` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `pms_sku_stock` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `pms_sku_stock` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `pms_sku_stock` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `pms_sku_stock` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `sms_coupon` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `sms_coupon` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `sms_coupon` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `sms_coupon` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `sms_coupon` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `sms_coupon_history` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `sms_coupon_history` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `sms_coupon_history` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `sms_coupon_history` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `sms_coupon_history` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `sms_coupon_product_category_relation` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `sms_coupon_product_category_relation` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `sms_coupon_product_category_relation` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `sms_coupon_product_category_relation` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `sms_coupon_product_category_relation` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `sms_coupon_product_relation` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `sms_coupon_product_relation` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `sms_coupon_product_relation` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `sms_coupon_product_relation` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `sms_coupon_product_relation` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `sms_flash_promotion` ADD flash_sale_time datetime DEFAULT NULL COMMENT '秒杀时间';
ALTER TABLE `sms_flash_promotion` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `sms_flash_promotion` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `sms_flash_promotion` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `sms_flash_promotion` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `sms_flash_promotion` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `sms_flash_promotion_log` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `sms_flash_promotion_log` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `sms_flash_promotion_log` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `sms_flash_promotion_log` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `sms_flash_promotion_log` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `sms_flash_promotion_product_relation` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `sms_flash_promotion_product_relation` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `sms_flash_promotion_product_relation` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `sms_flash_promotion_product_relation` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `sms_flash_promotion_product_relation` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `sms_flash_promotion_session` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `sms_flash_promotion_session` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `sms_flash_promotion_session` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `sms_flash_promotion_session` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `sms_home_advertise` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `sms_home_advertise` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `sms_home_advertise` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `sms_home_advertise` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `sms_home_advertise` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `sms_home_brand` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `sms_home_brand` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `sms_home_brand` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `sms_home_brand` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `sms_home_brand` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `sms_home_new_product` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `sms_home_new_product` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `sms_home_new_product` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `sms_home_new_product` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `sms_home_new_product` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `sms_home_recommend_product` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `sms_home_recommend_product` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `sms_home_recommend_product` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `sms_home_recommend_product` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `sms_home_recommend_product` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `sms_home_recommend_subject` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `sms_home_recommend_subject` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `sms_home_recommend_subject` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `sms_home_recommend_subject` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `sms_home_recommend_subject` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_admin` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_admin` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_admin` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_admin` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_admin_login_log` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_admin_login_log` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_admin_login_log` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_admin_login_log` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_admin_login_log` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_admin_permission_relation` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_admin_permission_relation` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_admin_permission_relation` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_admin_permission_relation` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_admin_permission_relation` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_admin_role_relation` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_admin_role_relation` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_admin_role_relation` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_admin_role_relation` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_admin_role_relation` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_growth_change_history` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_growth_change_history` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_growth_change_history` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_growth_change_history` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_growth_change_history` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_integration_change_history` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_integration_change_history` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_integration_change_history` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_integration_change_history` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_integration_change_history` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_integration_consume_setting` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_integration_consume_setting` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_integration_consume_setting` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_integration_consume_setting` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_integration_consume_setting` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_member` ADD register_time datetime DEFAULT NULL COMMENT '注册时间';
ALTER TABLE `ums_member` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_member` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_member` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_member` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_member` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_member_level` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_member_level` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_member_level` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_member_level` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_member_level` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_member_login_log` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_member_login_log` CHANGE create_time create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_member_login_log` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_member_login_log` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_member_login_log` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_member_member_tag_relation` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_member_member_tag_relation` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_member_member_tag_relation` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_member_member_tag_relation` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_member_member_tag_relation` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_member_product_category_relation` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_member_product_category_relation` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_member_product_category_relation` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_member_product_category_relation` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_member_product_category_relation` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_member_receive_address` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_member_receive_address` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_member_receive_address` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_member_receive_address` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_member_receive_address` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_member_rule_setting` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_member_rule_setting` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_member_rule_setting` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_member_rule_setting` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_member_rule_setting` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_member_statistics_info` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_member_statistics_info` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_member_statistics_info` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_member_statistics_info` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_member_statistics_info` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_member_tag` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_member_tag` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_member_tag` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_member_tag` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_member_tag` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_member_task` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_member_task` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_member_task` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_member_task` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_member_task` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_menu` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_menu` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_menu` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_menu` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_permission` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_permission` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_permission` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_permission` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_resource` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_resource` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_resource` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_resource` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_resource_category` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_resource_category` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_resource_category` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_resource_category` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_role` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_role` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_role` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_role` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_role_menu_relation` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_role_menu_relation` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_role_menu_relation` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_role_menu_relation` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_role_menu_relation` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_role_permission_relation` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_role_permission_relation` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_role_permission_relation` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_role_permission_relation` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_role_permission_relation` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';

ALTER TABLE `ums_role_resource_relation` ADD create_user varchar(64) DEFAULT NULL COMMENT '创建用户';
ALTER TABLE `ums_role_resource_relation` ADD create_time datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE `ums_role_resource_relation` ADD update_user varchar(64) DEFAULT NULL COMMENT '更新用户';
ALTER TABLE `ums_role_resource_relation` ADD update_time datetime DEFAULT NULL COMMENT '更新时间';
ALTER TABLE `ums_role_resource_relation` ADD is_delete char(1) DEFAULT '0' COMMENT '逻辑删除: 0-未删除, 1-已删除';