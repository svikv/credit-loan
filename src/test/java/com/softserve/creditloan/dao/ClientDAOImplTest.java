package com.softserve.creditloan.dao;

import com.softserve.creditloan.model.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/database-context-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientDAOImplTest {

    @Autowired
    protected ClientDAO clientDAO;

    Client client = new Client();

    @Test
    @Transactional
    @Rollback(true)
    public void loadAllClientsTest() {

        Assert.assertTrue(clientDAO.loadAllClients().size() == 0);
        Client client2 = new Client();
        clientDAO.saveOrUpdateClient(client);
        clientDAO.saveOrUpdateClient(client2);
        Assert.assertTrue(clientDAO.loadAllClients().size() == 2);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void saveOrUpdateClientTest() {

        Assert.assertTrue(clientDAO.loadAllClients().size() == 0);
        clientDAO.saveOrUpdateClient(client);
        Assert.assertTrue(clientDAO.loadAllClients().size() == 1);

        String firstName = "Oleksa";
        client.setFirstName(firstName);
        clientDAO.saveOrUpdateClient(client);
        Client clientLoaded = clientDAO.loadClient(client.getId());
        String firstNameLoaded = clientLoaded.getFirstName();
        Assert.assertTrue(firstName.equals(firstNameLoaded));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void deleteClientTest() {

        Assert.assertTrue(clientDAO.loadAllClients().size() == 0);
        clientDAO.saveOrUpdateClient(client);
        clientDAO.deleteClient(client.getId());
        Assert.assertTrue(clientDAO.loadAllClients().isEmpty());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void loadClientTest() {

        Assert.assertTrue(clientDAO.loadAllClients().size() == 0);
        clientDAO.saveOrUpdateClient(client);
        Client clientLoaded = clientDAO.loadClient(client.getId());
        Assert.assertNotNull(clientLoaded);
        assertEquals(clientLoaded, client);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void isClientIdentificationNumberFreeTest() {

        Assert.assertTrue(clientDAO.loadAllClients().size() == 0);
        Client client1 = new Client("Vasyok", "Popov", "1111111111", "0442504534", "sv@gmail.com");
        clientDAO.saveOrUpdateClient(client1);
        boolean result = clientDAO.isClientIdentificationNumberFree("1111111111");
        assertEquals(false, result);
    }
}