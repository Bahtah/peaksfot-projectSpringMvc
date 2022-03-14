package com.surantaev.mvc.service;

import com.surantaev.mvc.model.User;

import java.util.List;


public interface UserService {

    void saveUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    void update(User user, int id);

    void delete(int id);

}
