package com.liboshuai.polaris.oms.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: liboshuai
 * @Date: 2023-01-13 10:49
 * @Description: 测试user实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;

    private Integer age;

    private Integer salary;
}
