package com.accountant.repository;

import com.accountant.domain.Accountant;
import com.accountant.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RepositoryAccountantImpl implements  RepositoryAccountant{
    @Override
    public List<Accountant> findAll() {
        List users =
                HibernateSessionFactory
                        .getSessionFactory()
                        .openSession()
                        .createQuery("select a from Accountant a").getResultList();
        return users;
    }

    @Override
    public Accountant findOne(Long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Accountant.class, id);
    }

    @Override
    public Accountant save(Accountant entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        session.save(entity);

        tx1.commit();
        session.close();
        return entity;
    }

    @Override
    public Accountant update(Accountant entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        session.update(entity);

        tx1.commit();
        session.close();
        return entity;
    }

    @Override
    public void delete(Long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Accountant entity =session.get(Accountant.class,id);
        session.delete(entity);

        tx1.commit();
        session.close();
    }

    @Override
    public List<Accountant> findByDateAndNotTracker() {
        return null;
    }

    @Override
    public List<Accountant> findByUserId(Long id) {
        List users =
                HibernateSessionFactory
                        .getSessionFactory()
                        .openSession()
                        .createQuery("select a from Accountant a where a.userId = ?")
                        .setParameter(0,id)
                        .getResultList();
        return users;
    }

    @Override
    public List<Accountant> findByDataAllDeveloper() {
        return null;
    }
}
