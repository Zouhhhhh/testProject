package com.zouhhhhh.service;


import com.zouhhhhh.bean.Admin;
import com.zouhhhhh.bean.Reader;

/**
 * @author zouhao
 * @date 2022/4/17
 */
public interface LoginService {

    /**
     * 获取读者
     * @param userName
     * @param password
     * @return
     */
    Reader getReader(String userName, String password);

    /**
     * 获取管理员
     * @param userName
     * @param password
     * @return
     */
    Admin getAdmin(String userName, String password);


}
