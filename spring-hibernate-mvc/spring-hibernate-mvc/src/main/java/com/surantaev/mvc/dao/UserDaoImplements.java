package com.surantaev.mvc.dao;

import com.surantaev.mvc.model.Car;
import com.surantaev.mvc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImplements implements UserDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImplements(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public User getUserById(int id) {
        return sessionFactory.getCurrentSession().find(User.class, id);
    }


    @Override
    public List<User> getAllUsers() {
        return sessionFactory.openSession().createQuery("FROM User").getResultList();
    }

    @Override
    public void update(User user, int id) {
        Session session = null;
        sessionFactory.getCurrentSession();
        User user1 = session.get(User.class, id);
        user1.setName(user.getName());
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(User.class, id));
    }

    /*---------------------------------------------------------Car------------------------------------------------*/

    @Override
    public List<Car> getUserCar() {
        return sessionFactory.openSession().createQuery("FROM Car").getResultList();
    }

}
