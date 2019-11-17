package com.fq.springcloud.entities;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author qianfang, at 2019-11-13, 19:30
 **/
@Data
@Accessors(chain = true)
public class Dept {
    /**
     * 部门编码 主键
     */
    private Long deptNo;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 数据库名称
     */
    private String dbSource;
}

