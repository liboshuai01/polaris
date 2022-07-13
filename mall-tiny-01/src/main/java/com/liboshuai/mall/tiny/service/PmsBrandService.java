package com.liboshuai.mall.tiny.service;

import com.liboshuai.mall.tiny.common.vo.PmsBrandVO;
import com.liboshuai.mall.tiny.domain.dao.PmsBrandDAO;
import com.liboshuai.mall.tiny.domain.dto.PmsBrandDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-07-10 23:12
 * @Description: 品牌服务接口
 */
@Service
public interface PmsBrandService {

    /**
     * 查询全部 品牌 数据
     *
     * @return 品牌数据集合
     */
    List<PmsBrandDAO> listAllBrand();

    /**
     * 添加单条 品牌 数据
     *
     * @param pmsBrandVO 品牌vo象
     * @return 添加成功的行数
     */
    int createPmsBrand(PmsBrandVO pmsBrandVO);

    /**
     * 更新单条 品牌 数据
     *
     * @param pmsBrandVO 品牌vo对象
     * @return 更新成功的行数
     */
    int updatePmsBrand(PmsBrandVO pmsBrandVO);

    /**
     * 删除单条 品牌 数
     *
     * @param id 主键id
     * @return 删除成功的行数
     */
    int deleteBrand(Long id);

    /**
     * 分页查询 品牌 数据
     *
     * @param pageNum  当前页数
     * @param pageSize 一页数据数
     * @return 分页查询的品牌数据集合
     */
    List<PmsBrandDAO> listBrand(int pageNum, int pageSize);

    /**
     * 根据主键id查询品牌数据
     *
     * @param id 主键id
     * @return 品牌数据
     */
    PmsBrandDTO findById(Long id);
}
