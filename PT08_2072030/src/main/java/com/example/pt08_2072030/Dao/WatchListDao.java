package com.example.pt08_2072030.Dao;

import com.example.pt08_2072030.Model.Movie;
import com.example.pt08_2072030.Model.User;
import com.example.pt08_2072030.Model.Watchlist;
import com.example.pt08_2072030.Util.HiberUtility;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class WatchListDao implements DaoInterface<Watchlist> {

    @Override
    public List<Watchlist> getData() {
        List<Watchlist> wList;
        SessionFactory sf = HiberUtility.getSessionFactory();
        Session s = sf.openSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Watchlist.class);
        cq.from(Watchlist.class);
        wList = s.createQuery(cq).getResultList();
        s.close();
        return wList;
    }

    @Override
    public int addData(Watchlist data) {
        return 0;
    }

    @Override
    public int delData(Watchlist data) {
        return 0;
    }

    @Override
    public int updateData(Watchlist data) {
        return 0;
    }

    public List<Watchlist> filterData(User selectedItem) {
        List<Watchlist> wList;
        SessionFactory sf = HiberUtility.getSessionFactory();
        Session s = sf.openSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Watchlist.class);
        Root<Watchlist> r = cq.from(Watchlist.class);
        Predicate p1 = cb.equal(r.get("userByUserIdUser"), selectedItem);
        cq.where(p1);
        wList = s.createQuery(cq).getResultList();
        s.close();
        return wList;
    }
}
