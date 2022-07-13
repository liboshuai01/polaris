package com.liboshuai.mall.tiny.service.impl;

import com.liboshuai.mall.tiny.common.query.pmsBrand.PmsBrandCreateBrandQuery;
import com.liboshuai.mall.tiny.common.vo.PmsBrandVO;
import com.liboshuai.mall.tiny.domain.dao.PmsBrandDAO;
import com.liboshuai.mall.tiny.domain.dto.PmsBrandDTO;
import com.liboshuai.mall.tiny.mapper.PmsBrandMapper;
import com.liboshuai.mall.tiny.service.PmsBrandService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-07-11 00:03
 * @Description:
 */
@Service
@Slf4j
@NoArgsConstructor
public class PmsBrandServiceImpl implements PmsBrandService {

    private PmsBrandMapper pmsBrandMapper;

    @Autowired
    public PmsBrandServiceImpl(PmsBrandMapper pmsBrandMapper) {
        this.pmsBrandMapper = pmsBrandMapper;
    }

    /**
     * 查询全部 品牌 数据
     *
     * @return 品牌数据集合
     */
    @Override
    public List<PmsBrandDAO> listAllBrand() {
        return pmsBrandMapper.selectList(null);
    }

    /**
     * 添加单条 品牌 数据
     *
     * @param pmsBrandVO 品牌vo对象
     * @return 添加成功的行数
     */
    @Override
    public int createPmsBrand(PmsBrandVO pmsBrandVO) {
        PmsBrandDAO pmsBrandDAO = pmsBrandVO2DAO(pmsBrandVO);
        return pmsBrandMapper.insert(pmsBrandDAO);
    }

    private PmsBrandDAO pmsBrandVO2DAO(PmsBrandVO pmsBrandVO) {
        BeanCopier pmsBrandBeanCopier = BeanCopier.create(PmsBrandVO.class, PmsBrandDAO.class, false);
        PmsBrandDAO pmsBrandDAO = new PmsBrandDAO();
        pmsBrandBeanCopier.copy(pmsBrandVO, pmsBrandDAO, null);
        return pmsBrandDAO;
    }

    /**
     * 更新单条 品牌 数据
     *
     * @param pmsBrandVO 品牌vo对象
     * @return 更新成功的行数
     */
    @Override
    public int updatePmsBrand(PmsBrandVO pmsBrandVO) {
        return 0;
    }

    /**
     * 删除单条 品牌 数据
     *
     * @param id 主键id
     * @return 删除成功的行数
     */
    @Override
    public int deleteBrand(Long id) {
        return 0;
    }

    /**
     * 分页查询 品牌 数据
     *
     * @param pageNum  当前页数
     * @param pageSize 一页数据数
     * @return 分页查询的品牌数据集合
     */
    @Override
    public List<PmsBrandDAO> listBrand(int pageNum, int pageSize) {
        return null;
    }

    /**
     * 根据主键id查询品牌数据
     *
     * @param id 主键id
     * @return 品牌数据
     */
    @Override
    public PmsBrandDTO findById(Long id) {
        return null;
    }
}
