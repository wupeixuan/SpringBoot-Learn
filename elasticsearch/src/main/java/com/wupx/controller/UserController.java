package com.wupx.controller;

import com.wupx.document.UserDocument;
import com.wupx.dto.UserCityDTO;
import com.wupx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wupx
 * @date 2020/07/02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 创建索引
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/createUserIndex")
    public ResponseEntity<Boolean> createUserIndex(@RequestParam(value = "index") String index) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUserIndex(index));
    }

    /**
     * 删除索引
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/deleteUserIndex")
    public ResponseEntity<Boolean> deleteUserIndex(@RequestParam(value = "index") String index) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.deleteUserIndex(index));
    }

    /**
     * 新增文档
     *
     * @param document
     * @return
     * @throws Exception
     */
    @PostMapping("/createUserDocument")
    public ResponseEntity<Boolean> createUserDocument(@RequestBody UserDocument document) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUserDocument(document));
    }

    /**
     * 批量新增文档
     *
     * @param document
     * @return
     * @throws Exception
     */
    @PostMapping("/bulkCreateUserDocument")
    public ResponseEntity<Boolean> bulkCreateUserDocument(@RequestBody List<UserDocument> document) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.bulkCreateUserDocument(document));
    }

    /**
     * 删除文档
     *
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("/deleteUserDocument")
    public String deleteUserDocument(@RequestParam String id) throws Exception {
        return userService.deleteUserDocument(id);
    }

    /**
     * 更新文档
     *
     * @param document
     * @return
     * @throws Exception
     */
    @PostMapping("/updateUserDocument")
    public ResponseEntity<Boolean> updateUserDocument(@RequestBody UserDocument document) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUserDocument(document));
    }

    /**
     * 获取文档
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/getUserDocument")
    public UserDocument getUserDocument(@RequestParam String id) throws Exception {
        return userService.getUserDocument(id);
    }

    /**
     * 用户列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getUserList")
    public List<UserDocument> getUserList() throws Exception {
        return userService.getUserList();
    }

    /**
     * 城市聚合
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/aggregationsSearchUser")
    public List<UserCityDTO> aggregationsSearchUser() throws Exception {
        return userService.aggregationsSearchUser();
    }

    /**
     * 根据姓名搜索用户
     *
     * @param city
     * @return
     * @throws Exception
     */
    @GetMapping("/searchUserByCity")
    public List<UserDocument> searchUserByCity(@RequestParam(value = "city") String city) throws Exception {
        return userService.searchUserByCity(city);
    }
}
