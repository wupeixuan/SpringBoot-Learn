package com.wupx.aop.logger.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wupx.aop.logger.dto.User;
import com.wupx.aop.logger.entity.UserEntity;

import java.util.List;

/**
 * 用户服务类
 *
 * @author wupx
 * @since 2020-12-15
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 添加用户
     *
     * @param userEntity
     * @return
     */
    String addUser(UserEntity userEntity);

    /**
     * 修改用户
     *
     * @param userEntity
     * @return
     */
    String updateUser(UserEntity userEntity);

    /**
     * 查询用户
     *
     * @param id
     * @return
     */
    User getUser(Long id);

    /**
     * 查询用户列表
     *
     * @return
     */
    List<UserEntity> listUser();
}
