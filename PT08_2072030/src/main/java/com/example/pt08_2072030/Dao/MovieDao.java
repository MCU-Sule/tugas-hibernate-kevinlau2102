package com.example.pt08_2072030.Dao;

import com.example.pt08_2072030.Model.Movie;
import com.example.pt08_2072030.Util.HiberUtility;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class MovieDao implements DaoInterface<Movie> {
    @Override
    public List<Movie> getData() {
        List<Movie> mList;
        SessionFactory sf = HiberUtility.getSessionFactory();
        Session s = sf.openSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Movie.class);
        cq.from(Movie.class);
        mList = s.createQuery(cq).getResultList();
        s.close();
        return mList;
    }

    @Override
    public int addData(Movie data) {
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
    public int delData(Movie data) {
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
    public int updateData(Movie data) {
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

    public List<Movie> filterMovie(String value) {
        List<Movie> mList;
        SessionFactory sf = HiberUtility.getSessionFactory();
        Session s = sf.openSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Movie.class);
        Root<Movie> r = cq.from(Movie.class);
        Predicate p1 = cb.like(r.get("genre"), "%" + value + "%");
        cq.where(p1);
        mList = s.createQuery(cq).getResultList();
        s.close();
        return mList;
    }
}
