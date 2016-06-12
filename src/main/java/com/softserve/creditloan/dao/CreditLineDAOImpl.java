package com.softserve.creditloan.dao;

import com.softserve.creditloan.model.Client;
import com.softserve.creditloan.model.CreditLine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CreditLineDAOImpl class performs CRUD operations on {@link CreditLine} instance in the database
 */

@Repository
public class CreditLineDAOImpl implements CreditLineDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public CreditLineDAOImpl() {

    }

    public CreditLineDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Loads all CreditLine instances from the database
     */
    @Override
    public List<CreditLine> loadAllCreditLines(int id) {

        String hql = "from CreditLine where clientId=" + id;
        @SuppressWarnings("unchecked")
        List<CreditLine> list = (List<CreditLine>) getCurrentSession().createQuery(hql).list();
        return list;
    }

    /**
     * Saves or updates CreditLine instance in the database
     */
    @Override
    public void saveCreditLine(CreditLine creditLine, Client client) {

        creditLine.setClient(client);
        getCurrentSession().saveOrUpdate(creditLine);
    }

    /**
     * Loads CreditLine instance from the database by its identifier
     */
    @Override
    public CreditLine loadCreditLine(int id) {
        return getCurrentSession().get(CreditLine.class, id);
    }
}