package com.wupx.aop.logger.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author wupx
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopLogger {

    /**
     * 描述
     *
     * @return
     */
    String describe() default "";
}
