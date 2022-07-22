package com.liboshuai.mall.tiny.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: liboshuai
 * @Date: 2022-07-10 23:13
 * @Description: 品牌Dao类
 */
@Data
@TableName(value = "pms_brand", schema = "mall")
public class PmsBrand {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 首字母
     */
    @TableField(value = "first_letter")
    private String firstLetter;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    @TableField(value = "factory_status")
    private Integer factoryStatus;

    /**
     * 展示状态
     */
    @TableField(value = "show_status")
    private Integer showStatus;

    /**
     * 产品数量
     */
    @TableField(value = "product_count")
    private Integer productCount;

    /**
     * 产品评论数量
     */
    @TableField(value = "product_comment_count")
    private Integer productCommentCount;

    /**
     * 品牌logo
     */
    @TableField(value = "logo")
    private String logo;

    /**
     * 专区大图
     */
    @TableField(value = "big_pic")
    private String bigPic;

    /**
     * 品牌故事
     */
    @TableField(value = "brand_story")
    private String brandStory;
}
