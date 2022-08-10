package com.example.pt08_2072030.Dao;

import com.example.pt08_2072030.Model.Movie;
import com.example.pt08_2072030.Model.User;
import com.example.pt08_2072030.Util.HiberUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDao implements DaoInterface<User> {

    @Override
    public List<User> getData() {
        List<User> uList;
        SessionFactory sf = HiberUtility.getSessionFactory();
        Session s = sf.openSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        cq.from(User.class);
        uList = s.createQuery(cq).getResultList();
        s.close();
        return uList;
    }

    @Override
    public int addData(User data) {
        SessionFactory sf = HiberUtility.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        try {
            s.save(data);
            t.commit();
            return 1;

        } catch (Exception e) {
            t.rollback();
            return 0;

        }
    }

    @Override
    public int delData(User data) {
        SessionFactory sf = HiberUtility.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        try {
            s.delete(data);
            t.commit();
            return 1;

        } catch (Exception e) {
            t.rollback();
            return 0;

        }
    }

    @Override
    public int updateData(User data) {
        SessionFactory sf = HiberUtility.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        try {
            s.update(data);
            t.commit();
            return 1;

        } catch (Exception e) {
            t.rollback();
            return 0;

        }

    }

}
