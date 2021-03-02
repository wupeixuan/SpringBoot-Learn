package com.wupx.aop.logger.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wupx.aop.logger.dto.User;
import com.wupx.aop.logger.entity.UserEntity;
import com.wupx.aop.logger.mapper.UserMapper;
import com.wupx.aop.logger.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 *
 * @author wupx
 * @since 2020-12-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    /**
     * 添加用户
     *
     * @param userEntity
     */
    @Override
    public String addUser(UserEntity userEntity) {
        this.save(userEntity);
        return String.valueOf(userEntity.getId());
    }

    /**
     * 修改用户
     *
     * @param userEntity
     * @return
     */
    @Override
    public String updateUser(UserEntity userEntity) {
        this.updateById(userEntity);
        return String.valueOf(userEntity.getId());
    }

    /**
     * 查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User getUser(Long id) {
        UserEntity userEntity = this.getById(id);
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }

    /**
     * 查询用户列表
     *
     * @return
     */
    @Override
    public List<UserEntity> listUser() {
        return this.list(new QueryWrapper<>());
    }
}