package com.wupx.service;

import com.wupx.domain.User;

/**
 * 用户服务接口
 *
 * @author wupx
 * @date 2020/07/29
 */
public interface UserService {

    /**
     * 增加用户
     *
     * @param user 用户
     */
    void addUser(User user);

    /**
     * 获取用户
     *
     * @param id 用户 id
     * @return
     */
    User getUserById(Long id);

    /**
     * 修改用户
     *
     * @param user 用户
     * @return
     */
    User updateUser(User user);

    /**
     * 删除用户
     *
     * @param id 用户 id
     */
    void deleteById(Long id);
}
