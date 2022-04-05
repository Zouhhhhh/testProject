package com.zouhhhhh.repository;

import com.zouhhhhh.entity.Admin;

public interface AdminRepository {
    Admin login(String username, String password);
}
