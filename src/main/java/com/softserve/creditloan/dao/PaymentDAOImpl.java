package com.softserve.creditloan.dao;

import com.softserve.creditloan.model.CreditLine;
import com.softserve.creditloan.model.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PaymentDAOImpl class performs CRUD operations on {@link Payment} instance in the database
 */

@Repository
public class PaymentDAOImpl implements PaymentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public PaymentDAOImpl() {

    }

    public PaymentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Saves Payment instance to the database
     */
    @Override
    public void savePayment(Payment payment, CreditLine creditLine) {

        payment.setCreditLine(creditLine);
        getCurrentSession().saveOrUpdate(payment);
    }

    /**
     * Loads all Payment instances from the database
     */
    @Override
    public List<Payment> loadAllPayments(int id) {

        String hql = "from Payment where creditLineId=" + id;
        @SuppressWarnings("unchecked")
        List<Payment> list = (List<Payment>) getCurrentSession().createQuery(hql).list();
        return list;
    }
}