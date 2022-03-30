package com.zouhhhhh.service.impl;

import com.zouhhhhh.entity.Reader;
import com.zouhhhhh.repository.ReaderRepository;
import com.zouhhhhh.repository.impl.ReaderRepositoryImpl;
import com.zouhhhhh.service.LoginService;

public class LoginServiceImpl implements LoginService {

    private ReaderRepository readerRepository = new ReaderRepositoryImpl();

    @Override
    public Reader login(String username, String password) {
        return readerRepository.login(username, password);
    }

}
