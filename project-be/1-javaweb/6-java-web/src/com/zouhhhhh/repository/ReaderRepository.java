package com.zouhhhhh.repository;

import com.zouhhhhh.entity.Reader;

public interface ReaderRepository {

    public Reader login(String username, String password);

}
