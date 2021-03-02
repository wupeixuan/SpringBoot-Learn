package com.wupx.aop.logger.aspect;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wupx.aop.logger.annotation.AopLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author wupx
 * @date 2021/1/6 14:17
 */
@Aspect
@Component
public class AopLoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.wupx.aop.logger.annotation.AopLogger)")
    public void aopLoggerAspect() {
    }

    /**
     * 环绕触发
     *
     * @param point
     * @return
     */
    @Around("aopLoggerAspect()")
    public Object doAround(ProceedingJoinPoint point) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        Object result = null;
        long startTime = System.currentTimeMillis();
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.error(throwable.getMessage());
        }
        String describe = getAopLoggerDescribe(point);
        if (StringUtils.isBlank(describe)) {
            describe = "-";
        }
        // 打印请求相关参数
        logger.info("========================================== Start ==========================================");
        logger.info("Describe       : {}", describe);
        // 打印请求 url
        logger.info("URL            : {}", request.getRequestURL());
        logger.info("URI            : {}", request.getRequestURI());
        // 打印 Http method
        logger.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info("Class Method   : {}.{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());
        // 打印请求的 IP
        logger.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        logger.info("Request Args   : {}", point.getArgs());
        // 打印请求出参
        logger.info("Response Args  : {}", result);
        logger.info("Time Consuming : {} ms", System.currentTimeMillis() - startTime);
        logger.info("=========================================== End ===========================================");
        return result;
    }

    /**
     * 获取注解中对方法的描述信息
     *
     * @param joinPoint 切点
     * @return describe
     */
    public static String getAopLoggerDescribe(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        AopLogger controllerLog = method.getAnnotation(AopLogger.class);
        return controllerLog.describe();
    }
}