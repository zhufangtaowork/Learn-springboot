package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 项目名称：springboot_demo
 * 类 名 称：UserServiceImpl
 * 类 描 述：TODO
 * 创建时间：2020/3/11 4:59 下午
 * 创 建 人：ZhuFangTao
 */
@Slf4j
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    private static final String XLS = "^.+\\.(?i)(xls)$";
    private static final String XLS_X = "^.+\\.(?i)(xlsx)$";

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUser(String name, String password) {
        User user = userMapper.findUser(name,password);
        if (user == null){
            return null;
        }
        return user;
    }

    @Override
    public boolean addUser(String name, String encryptPassword) {
        int i = userMapper.addUser(name,encryptPassword);
        return i>0;
    }

    @Override
    public List<User> findUsers(int threadId) {
        List<User> userList = userMapper.findUsers(threadId);
        if (CollectionUtils.isNotEmpty(userList)){
            return userList;
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> userList = userMapper.findAllUsers();
        return userList;
    }

    @Override
    public boolean addUsers(Map<String, Object> params) {
        Integer i = userMapper.addUsers(params);
        return i>0;
    }

    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws IOException {
        boolean notNull = false;
        List<User> userList = new ArrayList<User>();
        if (!fileName.matches(XLS) && !fileName.matches(XLS_X)) {
            log.info("batchImport {}","上传文件格式不正确");
            return false;
        }
        boolean isExcel2003 = true;
        if (fileName.matches(XLS_X)) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }
        User user;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }

            user = new User();
            if( row.getCell(0).getCellType() !=1){
                notNull = false;
                log.info("import error {}","导入失败(第"+(r+1)+"行,姓名请设为文本格式)");
            }
            String name = row.getCell(0).getStringCellValue();

            if(name == null || name.isEmpty()){
                notNull = false;
                log.info("import error {}","导入失败(第"+(r+1)+"行,姓名未填写)");
            }
            row.getCell(1).setCellType(CellType.STRING);
            if( row.getCell(1).getCellType() !=1){
                notNull = false;
                log.info("import error {}","导入失败(第"+(r+1)+"行,密码请设为文本格式)");
            }
            String password = row.getCell(1).getStringCellValue();
            if(password == null || password.isEmpty()){
                notNull = false;
                log.info("import error {}","导入失败(第"+(r+1)+"行,密码未填写)");
            }
            user.setName(name);
            user.setPassword(password);
            user.setStatus(1);
            userList.add(user);
        }
        for (User u : userList) {
//            String name = u.getName();
//            int cnt = userMapper.selectByName(name);
//            if (cnt == 0) {
                userMapper.addUserByObj(u);
//                System.out.println(" 插入 "+userResord);
//            } else {
//                userMapper.updateUserByName(userResord);
//                System.out.println(" 更新 "+userResord);
//            }
        }
        return notNull;
    }
}
