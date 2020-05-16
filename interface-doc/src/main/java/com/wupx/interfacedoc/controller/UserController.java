package com.wupx.interfacedoc.controller;

import com.wupx.interfacedoc.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author wupx
 * @date 2020/5/16
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户管理接口")
public class UserController {

    Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @GetMapping("/")
    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    public List<User> getUserList() {
        return new ArrayList<>(users.values());
    }

    @PostMapping("/")
    @ApiOperation(value = "创建用户")
    public String addUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取指定 id 的用户")
    @ApiImplicitParam(name = "id", value = "用户 id", paramType = "query", dataTypeClass = Long.class, defaultValue = "999", required = true)
    public User getUserById(@PathVariable Long id) {
        return users.get(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据 id 更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户 id", defaultValue = "1"),
            @ApiImplicitParam(name = "name", value = "用户姓名", defaultValue = "wupx"),
            @ApiImplicitParam(name = "age", value = "用户年龄", defaultValue = "18")
    })
    public User updateUserById(@PathVariable Long id, @RequestParam String name, @RequestParam Integer age) {
        User user = users.get(id);
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户", notes = "根据 id 删除用户")
    @ApiImplicitParam(name = "id", value = "用户 id", dataTypeClass = Long.class, required = true)
    public String deleteUserById(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
