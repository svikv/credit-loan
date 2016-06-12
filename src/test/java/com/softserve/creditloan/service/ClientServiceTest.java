package com.softserve.creditloan.service;

import com.softserve.creditloan.dao.ClientDAO;
import com.softserve.creditloan.model.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 *  Unit testing of ClientService class with mock object
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    private static final int ONCE = 1;
    private static final int ID = 1;

    @Mock
    private ClientDAO clientDAO;

    @InjectMocks
    ClientService clientService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Spy
    Client client = new Client();

    @Test
    public void loadAllClientsTest() {

        List<Client> clients = new ArrayList<>();
        clients.add(new Client());
        clients.add(new Client());
        int expected = clients.size();

        when(clientDAO.loadAllClients()).thenReturn(clients);
        assertEquals(clients, clientDAO.loadAllClients());
        verify(clientDAO, times(ONCE)).loadAllClients();
        assertTrue(clientService.loadAllClients().size() == expected);
    }

    @Test
    public void loadClientTest() {

        when(clientDAO.loadClient(ID)).thenReturn(client);
        assertEquals(client, clientDAO.loadClient(ID));
        verify(clientDAO, times(ONCE)).loadClient(ID);
    }

    @Test
    public void saveOrUpdateClientTest() {

        doNothing().when(clientDAO).saveOrUpdateClient(client);
        clientService.saveOrUpdateClient(client);
        verify(clientDAO, times(ONCE)).saveOrUpdateClient(client);
    }

    @Test
    public void deleteClientTest() {

        doNothing().when(clientDAO).deleteClient(ID);
        clientService.deleteClient(ID);
        verify(clientDAO, times(ONCE)).deleteClient(ID);
    }

    @Test
    public void isClientIdentificationNumberFreeTest() {

        boolean value=false;
        String identificationNumber ="";
        when(clientDAO.isClientIdentificationNumberFree(identificationNumber)).thenReturn(value);
        assertEquals(value, clientDAO.isClientIdentificationNumberFree(identificationNumber));
        verify(clientDAO, times(ONCE)).isClientIdentificationNumberFree(identificationNumber);
    }
}