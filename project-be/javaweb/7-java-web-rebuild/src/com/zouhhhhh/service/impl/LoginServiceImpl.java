package com.zouhhhhh.service.impl;

import com.zouhhhhh.bean.Admin;
import com.zouhhhhh.bean.Reader;
import com.zouhhhhh.dao.LoginRepository;
import com.zouhhhhh.dao.impl.LoginRepositoryImpl;
import com.zouhhhhh.service.LoginService;


/**
 * @author zouhao
 * @date 2022/4/17
 */
public class LoginServiceImpl implements LoginService {

    LoginRepository loginRepository = new LoginRepositoryImpl();

    @Override
    public Reader getReader(String userName, String password) {
        return loginRepository.getReader(userName, password);
    }

    @Override
    public Admin getAdmin(String userName, String password) {
        return loginRepository.getAdmin(userName, password);
    }
}
