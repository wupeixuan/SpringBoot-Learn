package com.wupx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wupx.entity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户 服务类
 *
 * @author wupx
 * @since 2020-12-15
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 上传文件
     *
     * @param file
     */
    void uploadFile(MultipartFile file);
}
