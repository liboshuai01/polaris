package com.liboshuai.mall.tiny.module.ums.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.module.ums.domain.entity.UmsAdmin;
import com.liboshuai.mall.tiny.module.ums.domain.dto.UmsAdminDTO;
import com.liboshuai.mall.tiny.module.ums.domain.vo.UmsAdminVO;
import com.liboshuai.mall.tiny.module.ums.mapper.UmsAdminMapper;
import com.liboshuai.mall.tiny.module.ums.service.UmsAdminService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    @Autowired
    private UmsAdminMapper umsAdminMapper;


    /**
     * 根据用户名称查询用户id
     */
    @Override
    public Long findUserIdByUserName(String userName) {
        LambdaQueryWrapper<UmsAdmin> umsMemberLambdaQueryWrapper = new LambdaQueryWrapper<>();
        umsMemberLambdaQueryWrapper.eq(UmsAdmin::getUsername, userName);
        return umsAdminMapper.selectOne(umsMemberLambdaQueryWrapper).getId();
    }

    /**
     * 根据用户名称查询用户全部信息
     */
    @Override
    public UmsAdminDTO findByUserName(String username) {
        LambdaQueryWrapper<UmsAdmin> umsMemberLambdaQueryWrapper = new LambdaQueryWrapper<>();
        umsMemberLambdaQueryWrapper.eq(UmsAdmin::getUsername, username);
        UmsAdmin umsAdmin = umsAdminMapper.selectOne(umsMemberLambdaQueryWrapper);
        UmsAdminDTO umsAdminDTO = new UmsAdminDTO();
        BeanUtils.copyProperties(umsAdmin, umsAdminDTO);
        return umsAdminDTO;
    }

    /**
     * 用户信息下载接口
     */
    @Override
    public void userDataExport(List<Long> userIdList) {
        List<UmsAdmin> umsAdminList = umsAdminMapper.selectBatchIds(userIdList);
        UmsAdminVO umsAdminVO = new UmsAdminVO();
        BeanUtils.copyProperties(umsAdminList, umsAdminVO);
        Workbook workbook = ExcelExportUtil.exportExcel(
                new ExportParams("导出测试", null, "测试网"),
                UmsAdminVO.class,
                umsAdminList);
        try (OutputStream ot = new FileOutputStream("C:\\Users\\李博帅\\Desktop\\umsAdminVO.xls")){
            workbook.write(ot);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
