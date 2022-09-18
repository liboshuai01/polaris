package com.liboshuai.mall.tiny.module.ums.domain.mapStruct;

import com.liboshuai.mall.tiny.module.ums.domain.dto.UmsAdminDTO;
import com.liboshuai.mall.tiny.module.ums.domain.entity.UmsAdmin;
import com.liboshuai.mall.tiny.module.ums.domain.vo.UmsAdminVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-09-19 07:18
 * @Description: UmsAdmin对象转化器
 */
@Mapper
public interface UmsAdminConverter {

    UmsAdminVO entityToVO(UmsAdmin umsAdmin);

    UmsAdminDTO entityToDTO(UmsAdmin umsAdmin);

    List<UmsAdminVO> entityListToVOList(List<UmsAdmin> umsAdminList);

    List<UmsAdminDTO> entityListToDTOList(List<UmsAdmin> umsAdminList);
}
