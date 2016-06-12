package com.softserve.creditloan.dao;

import com.softserve.creditloan.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClientDAOImpl class performs CRUD operations on Client instance in the database
 */

@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public ClientDAOImpl() {

    }

    public ClientDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Loads all Client instances from the database
     */
    @Override
    public List<Client> loadAllClients() {
        String hql = "from Client";
        @SuppressWarnings("unchecked")
        List<Client> lists = (List<Client>) getCurrentSession().createQuery(hql).list();
        return lists;
    }

    /**
     * Saves or updates Client instance in the database
     */
    @Override
    public void saveOrUpdateClient(Client client) {
        getCurrentSession().saveOrUpdate(client);
    }

    /**
     * Deletes Client instance from the database by its identifier
     */
    @Override
    public void deleteClient(int id) {

        Client clientToDelete = loadClient(id);
        if(clientToDelete!=null){
            getCurrentSession().delete(clientToDelete);
        }
    }

    /**
     * Loads Client instance from the database by its identifier
     */
    @Override
    public Client loadClient(int id) {
        return getCurrentSession().get(Client.class, id);
    }

    /**
     Checks the uniqueness of Client`s identificationNumber
     */
    @Override
    public boolean isClientIdentificationNumberFree(String identificationNumber) {

        String hql = "select count (identificationNumber) from Client where identificationNumber=" + identificationNumber;
        long count = (Long)getCurrentSession().createQuery(hql).uniqueResult();
        return count <= 0;
    }
}