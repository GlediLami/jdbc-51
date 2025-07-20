package org.sda.hibernate.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sda.hibernate.Employee;

import java.util.List;

public class UserDaoImpl implements UserDao{
    private Session session;

    public UserDaoImpl() {
        session = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory()
                .openSession();
    }

    @Override
    public void save(User user) {
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }

    @Override
    public User findById(Long id) {
        return session.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return session.createQuery("FROM User").getResultList();
    }

    @Override
    public void update(User user) {
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        session.beginTransaction();
        User user = this.findById(id);
        session.remove(user);
        session.getTransaction().commit();
    }

    public void close() {
        session.close();
    }
}
