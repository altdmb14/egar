package ru.egar.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.egar.model.Zakaz;

import java.util.List;

@Repository
public class ZakazDAOImpl implements ZakazDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Zakaz getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Zakaz.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Zakaz> allZakaz() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Zakaz").list();
    }
}
