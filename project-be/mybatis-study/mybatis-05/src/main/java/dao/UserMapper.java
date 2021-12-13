package main.java.dao;

import main.java.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> getUserList();

    User getUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

}
