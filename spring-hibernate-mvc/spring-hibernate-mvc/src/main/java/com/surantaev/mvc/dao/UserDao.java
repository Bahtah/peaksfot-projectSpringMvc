package com.surantaev.mvc.dao;

import com.surantaev.mvc.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    void update(User user, int id);

    void delete(int id);
}
