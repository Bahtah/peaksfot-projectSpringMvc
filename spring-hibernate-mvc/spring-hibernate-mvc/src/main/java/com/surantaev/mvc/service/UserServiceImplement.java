package com.surantaev.mvc.service;

import com.surantaev.mvc.dao.UserDao;
import com.surantaev.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImplement implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void update(User user, int id) {
        userDao.update(user, id);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}

