package com.wupx.service.impl;

import com.wupx.domain.User;
import com.wupx.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wupx
 * @date 2020/07/29
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<>());

    @Override
    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    @Cacheable(key = "#id")
    public User getUserById(Long id) {
        if (!userMap.containsKey(id)) {
            return null;
        }
        return userMap.get(id);
    }

    @Override
    @CachePut(key = "#user.id")
    public User updateUser(User user) {
        if (!userMap.containsKey(user.getId())) {
            throw new RuntimeException("不存在该用户");
        }
        User newUser = userMap.get(user.getId());
        newUser.setPassword(user.getPassword());
        userMap.put(newUser.getId(), newUser);
        return newUser;
    }

    @Override
    @CacheEvict(key = "#id")
    public void deleteById(Long id) {
        userMap.remove(id);
    }
}
