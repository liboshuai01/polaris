package com.liboshuai.polaris.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.polaris.common.utils.ResourceUtil;
import com.liboshuai.polaris.common.vo.SysDictItemVO;
import com.liboshuai.polaris.security.entity.SysDictEntity;
import com.liboshuai.polaris.security.entity.SysDictItemEntity;
import com.liboshuai.polaris.security.mapper.SysDictItemMapper;
import com.liboshuai.polaris.security.mapper.SysDictMapper;
import com.liboshuai.polaris.security.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 18:20
 * @Description:
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDictEntity> implements SysDictService {

    private SysDictMapper sysDictMapper;
    private SysDictItemMapper sysDictItemMapper;

    @Autowired
    public SysDictServiceImpl(SysDictMapper sysDictMapper, SysDictItemMapper sysDictItemMapper) {
        this.sysDictMapper = sysDictMapper;
        this.sysDictItemMapper = sysDictItemMapper;
    }

    @Override
    public Map<String, List<SysDictItemVO>> queryAllDictItems() {
        Map<String, List<SysDictItemVO>> res = new HashMap(5);
        List<SysDictEntity> ls = sysDictMapper.selectList(null);
        LambdaQueryWrapper<SysDictItemEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysDictItemEntity::getStatus, 1);
        queryWrapper.orderByAsc(SysDictItemEntity::getSortOrder);
        List<SysDictItemEntity> sysDictItemList = sysDictItemMapper.selectList(queryWrapper);

        for (SysDictEntity d : ls) {
            List<SysDictItemVO> dictModelList = sysDictItemList.stream().filter(s -> d.getId().equals(s.getDictId())).map(item -> {
                SysDictItemVO dictModel = new SysDictItemVO();
                dictModel.setText(item.getItemText());
                dictModel.setValue(item.getItemValue());
                return dictModel;
            }).collect(Collectors.toList());
            res.put(d.getDictCode(), dictModelList);
        }
        //update-begin-author:taoyan date:2022-7-8 for: 系统字典数据应该包括自定义的java类-枚举
        Map<String, List<SysDictItemVO>> enumRes = ResourceUtil.getEnumDictData();
        res.putAll(enumRes);
        //update-end-author:taoyan date:2022-7-8 for: 系统字典数据应该包括自定义的java类-枚举
        log.debug("-------登录加载系统字典-----" + res.toString());
        return res;
    }
}
