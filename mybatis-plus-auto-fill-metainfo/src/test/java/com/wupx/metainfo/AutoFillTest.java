package com.wupx.metainfo;

import com.wupx.metainfo.entity.UserEntity;
import com.wupx.metainfo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 测试字段自动填充
 *
 * @author wupx
 * @date 2020/12/30 22:03
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoFillTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test() throws InterruptedException {
        UserEntity user = new UserEntity();
        user.setName("wupx");
        user.setAge(18);
        user.setEmail("wupx@qq.com");
        userMapper.insert(user);
        Long id = user.getId();
        UserEntity beforeUser = userMapper.selectById(id);
        log.info("before user:{}", beforeUser);
        Assert.assertNotNull(beforeUser.getCreateTime());
        Assert.assertNotNull(beforeUser.getModifyTime());
        beforeUser.setAge(19);
        Thread.sleep(1000L);
        userMapper.updateById(beforeUser);
        log.info("query user:{}", userMapper.selectById(id));
        // 清除测试数据
        userMapper.deleteById(id);
    }
}