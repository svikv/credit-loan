package com.softserve.creditloan.dao;

import com.softserve.creditloan.model.Client;
import com.softserve.creditloan.model.CreditLine;

import java.util.List;

public interface ClientDAO {
    List<Client> loadAllClients();
    Client loadClient(int id);
    void saveOrUpdateClient(Client client);
    void deleteClient(int id);
    boolean isClientIdentificationNumberFree(String identificationNumber);
}
