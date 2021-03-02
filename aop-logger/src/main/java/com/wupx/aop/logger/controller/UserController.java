package com.wupx.aop.logger.controller;

import com.wupx.aop.logger.annotation.AopLogger;
import com.wupx.aop.logger.dto.User;
import com.wupx.aop.logger.entity.UserEntity;
import com.wupx.aop.logger.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户前端控制器
 *
 * @author wupx
 * @since 2020-12-15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 添加用户
     *
     * @param user
     */
    @PostMapping
    @AopLogger(describe = "添加用户")
    public String addUser(@RequestBody User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        return userService.addUser(userEntity);
    }

    /**
     * 修改用户
     *
     * @param user
     */
    @PutMapping
    @AopLogger(describe = "修改用户")
    public String updateUser(@RequestBody User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        return userService.updateUser(userEntity);
    }

    /**
     * 查询用户
     *
     * @param id
     */
    @GetMapping("/{id}")
    @AopLogger(describe = "查询用户")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    /**
     * 查询用户列表
     */
    @GetMapping
    @AopLogger(describe = "查询用户列表")
    public List<UserEntity> listUser() {
        return userService.listUser();
    }
}