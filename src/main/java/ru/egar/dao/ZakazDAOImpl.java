package ru.egar.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.egar.model.Zakaz;
import ru.egar.util.HibernateUtil;
import ru.xml.Specification;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ZakazDAOImpl implements ZakazDAO {

    @Override
    public Zakaz getById(Long id) {
        return HibernateUtil.getSessionFactory().openSession().get(Zakaz.class, id);
    }
//
    @Override
    @SuppressWarnings("unchecked")
    public List<Zakaz> allZakaz() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Zakaz.class);
        Root<Zakaz> root = cq.from(Zakaz.class);
        cq.select(root);

        Query query = session.createQuery(cq);
        List<Zakaz> authorList = query.getResultList();
        session.close();
        return authorList;
    }
//
    @Override
    public void add(Zakaz zakaz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(zakaz);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Zakaz zakaz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        session.delete(zakaz);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void edit(Zakaz zakaz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        session.update(zakaz);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void addSpecification(Specification specification) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(specification);
        session.getTransaction().commit();
        session.close();
    }

}
