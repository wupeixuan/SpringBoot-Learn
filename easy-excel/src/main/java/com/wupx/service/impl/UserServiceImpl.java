package com.wupx.service.impl;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wupx.entity.UserEntity;
import com.wupx.listener.UserDataListener;
import com.wupx.mapper.UserMapper;
import com.wupx.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 用户服务实现类
 *
 * @author wupx
 * @since 2020-12-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    public void uploadFile(MultipartFile file) {
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
            ExcelReader excelReader = EasyExcelFactory.read(inputStream).build();
            ReadSheet userReadSheet = EasyExcelFactory.readSheet().registerReadListener(new UserDataListener(this)).head(UserEntity.class).build();
            excelReader.read(userReadSheet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}