package com.zouhhhhh.service.impl;

import com.zouhhhhh.entity.Reader;
import com.zouhhhhh.repository.AdminRepository;
import com.zouhhhhh.repository.ReaderRepository;
import com.zouhhhhh.repository.impl.AdminRepositoryImpl;
import com.zouhhhhh.repository.impl.ReaderRepositoryImpl;
import com.zouhhhhh.service.LoginService;

public class LoginServiceImpl implements LoginService {

    private ReaderRepository readerRepository = new ReaderRepositoryImpl();

    private AdminRepository adminRepository = new AdminRepositoryImpl();

    @Override
    public Object login(String username, String password, String type) {
        Object object = null;
        switch (type) {
            case "reader":
                object = readerRepository.login(username, password);
                break;
            case "admin":
                object = adminRepository.login(username, password);
        }
        return object;
    }

}
