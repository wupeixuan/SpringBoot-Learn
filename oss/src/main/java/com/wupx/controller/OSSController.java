package com.wupx.controller;

import com.wupx.service.OSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.util.List;

/**
 * @author wupx
 * @date 2020/07/09
 */
@RestController
@RequestMapping("/oss")
public class OSSController {

    @Autowired
    private OSSService ossService;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/uploadFiles")
    public String uploadFiles(@RequestParam("file") MultipartFile file) {
        return ossService.uploadFile(file, "imgs");
    }

    /**
     * 下载文件
     *
     * @param fileName
     */
    @PostMapping(value = "/exportFile")
    public void exportFile(OutputStream os, @RequestParam("fileName") String fileName) {
        ossService.exportFile(os, fileName);
    }

    /**
     * 删除文件
     *
     * @param fileName
     */
    @PostMapping(value = "/deleteFile")
    public void deleteFile(@RequestParam("fileName") String fileName) {
        ossService.deleteFile(fileName);
    }

    /**
     * 查看文件列表
     *
     * @return
     */
    @PostMapping(value = "/listObjects")
    public List<String> listObjects() {
        return ossService.listObjects();
    }

    /**
     * 判断文件是否存在
     *
     * @param fileName
     */
    @PostMapping(value = "/doesObjectExist")
    public boolean doesObjectExist(@RequestParam("fileName") String fileName) {
        return ossService.doesObjectExist(fileName);
    }

    /**
     * 获取 url
     *
     * @param fileName
     * @param expSeconds
     */
    @PostMapping(value = "/getSingeNatureUrl")
    public String getSingeNatureUrl(@RequestParam("fileName") String fileName, @RequestParam("expSeconds") int expSeconds) {
        return ossService.getSingeNatureUrl(fileName, expSeconds);
    }
}
