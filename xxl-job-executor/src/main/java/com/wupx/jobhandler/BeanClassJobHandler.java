package com.wupx.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

/**
 * BEAN模式（类形式）
 * 开发步骤：
 * 1、继承"IJobHandler"：“com.xxl.job.core.handler.IJobHandler”；
 * 2、注册到执行器工厂：在 "XxlJobConfiguration.xxlJobExecutor" 中手动注册，注解key值对应的是调度中心新建任务的JobHandler属性的值。
 * 3、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 *
 * @author wupx
 * @date 2020/09/08
 */
@Component
public class BeanClassJobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("bean class jobhandler running...");
        return ReturnT.SUCCESS;
    }
}
