package com.softserve.creditloan.service;

import com.softserve.creditloan.dao.ClientDAO;
import com.softserve.creditloan.model.Client;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClientService class implements CRUD operation on {@link Client} instance in the database
 * The service uses Spring DataSourceTransactionManager for managing transaction with database and log4j for logging
 */

@Service
@Transactional
public class ClientService {

    private static final Logger LOGGER = Logger.getLogger(ClientService.class);

    @Autowired
    private ClientDAO clientDAO;

    /**
     * Loads all stored {@link Client} instances with their main information
     * @return List of {@link Client} instances
     * @throws DataAccessException
     */
    public List<Client> loadAllClients() {

        try {
            return clientDAO.loadAllClients();
        } catch (DataAccessException e) {
            LOGGER.error("Unable to load Client instances", e);
            throw e;
        }
    }

    /**
     * Loads {@link Client} instance from DB
     * @param id of Client instance which stored in the DB
     * @return Client instance
     * @throws DataAccessException when there is no access to the DB
     */
    public Client loadClient(int id) {
        try {
            return clientDAO.loadClient(id);
        } catch (DataAccessException e) {
            LOGGER.error("Unable to load Client instance with next id: " + id, e);
            throw e;
        }
    }

    /**
     * Saves/updates {@link Client} instance to DB.
     * @param client instance which needs to be stored/updated in the DB
     * @throws DataAccessException when there is no access to the DB
     */
    public void saveOrUpdateClient(Client client) {
        try {
            clientDAO.saveOrUpdateClient(client);
        } catch (DataAccessException e) {
            LOGGER.error("Unable to save/update Client instance: ", e);
            throw e;
        }
    }

    /**
     * Deletes {@link Client} instance from DB
     * @param id of Client instance which need to delete
     * @throws DataAccessException when there is no access to the DB
     */
    public void deleteClient(int id) {
        try {
            clientDAO.deleteClient(id);
        } catch (DataAccessException e) {
            LOGGER.error("Unable to delete Client instance with next id: " + id, e);
            throw e;
        }
    }

    /**
     * Checks the uniqueness of client's identificationNumber
     * @param identificationNumber of {@link Client} to be checked
     * @return true if identificationNumber is unique
     * @throws DataAccessException when there is no access to the DB
     */
    public boolean isClientIdentificationNumberFree(String identificationNumber) {

        try {
            return clientDAO.isClientIdentificationNumberFree(identificationNumber);
        } catch (DataAccessException e) {
            LOGGER.error("Unable to check client's identificationNumber " + identificationNumber, e);
            throw e;
        }
    }
}
