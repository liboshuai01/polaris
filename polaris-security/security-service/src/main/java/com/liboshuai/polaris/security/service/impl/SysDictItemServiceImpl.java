package com.liboshuai.polaris.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.security.dto.SysDictItemDTO;
import com.liboshuai.polaris.security.entity.SysDictEntity;
import com.liboshuai.polaris.security.entity.SysDictItemEntity;
import com.liboshuai.polaris.security.mapper.SysDictItemMapper;
import com.liboshuai.polaris.security.mapper.SysDictMapper;
import com.liboshuai.polaris.security.service.SysDictItemService;
import com.liboshuai.polaris.security.utils.SysDictItemUtil;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 18:23
 * @Description:
 */
@Service
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItemEntity> implements SysDictItemService {

    @Autowired
    private SysDictMapper sysDictMapper;
    @Autowired
    private SysDictItemMapper sysDictItemMapper;


    /**
     * 查询每个Dict对应的DictItem的值
     */
    @Override
    public ResponseResult<Map<String, List<SysDictItemDTO>>> queryAllDictItems() {
        Map<String, List<SysDictItemDTO>> res = new HashMap(5);
        List<SysDictEntity> ls = sysDictMapper.selectList(null);
        LambdaQueryWrapper<SysDictItemEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysDictItemEntity::getStatus, 1);
        queryWrapper.orderByAsc(SysDictItemEntity::getSortOrder);
        List<SysDictItemEntity> sysDictItemList = sysDictItemMapper.selectList(queryWrapper);

        for (SysDictEntity d : ls) {
            List<SysDictItemDTO> dictModelList = sysDictItemList.stream().filter(s -> d.getId().equals(s.getDictId())).map(item -> {
                SysDictItemDTO sysDictItemDTO = new SysDictItemDTO();
                sysDictItemDTO.setText(item.getItemText());
                sysDictItemDTO.setValue(item.getItemValue());
                return sysDictItemDTO;
            }).collect(Collectors.toList());
            res.put(d.getDictCode(), dictModelList);
        }
        //update-begin-author:taoyan date:2022-7-8 for: 系统字典数据应该包括自定义的java类-枚举
        Map<String, List<SysDictItemDTO>> enumRes = SysDictItemUtil.getEnumDictData();
        res.putAll(enumRes);
        //update-end-author:taoyan date:2022-7-8 for: 系统字典数据应该包括自定义的java类-枚举
        log.debug("-------登录加载系统字典-----" + res.toString());
        return ResponseResult.success(res);
    }
}
