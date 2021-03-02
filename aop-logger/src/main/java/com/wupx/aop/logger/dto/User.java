package com.wupx.aop.logger.dto;

import lombok.Data;

/**
 * 用户
 *
 * @author wupx
 * @since 2020-12-15
 */
@Data
public class User {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮件
     */
    private String email;
}
