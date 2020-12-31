package com.wupx.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.holder.ReadSheetHolder;
import com.wupx.entity.UserEntity;
import com.wupx.service.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wupx
 * @date 2020/12/15 23:45
 */
public class UserDataListener extends AnalysisEventListener<UserEntity> {
    private static final Logger logger = LoggerFactory.getLogger(UserDataListener.class);
    List<UserEntity> userEntities = new ArrayList<>();
    private final UserService userService;

    /**
     * 每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param userService
     */
    public UserDataListener(UserService userService) {
        this.userService = userService;
    }

    /**
     * 每一行数据解析都会调用
     *
     * @param userEntity
     * @param context
     */
    @Override
    public void invoke(UserEntity userEntity, AnalysisContext context) {
        logger.info("解析到一条数据：{}", userEntity);
        userEntities.add(userEntity);
    }

    /**
     * 所有数据解析完成了会调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        ReadSheetHolder readSheetHolder = context.readSheetHolder();
        if (CollectionUtils.isNotEmpty(userEntities)) {
            userService.saveBatch(userEntities);
        }
        logger.info("{}数据解析完成", readSheetHolder.getSheetName());
        userEntities.clear();
    }
}
