package com.wupx.controller;

import com.wupx.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/upload-file")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        userService.uploadFile(file);
    }

}

