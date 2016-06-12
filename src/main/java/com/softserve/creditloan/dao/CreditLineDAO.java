package com.softserve.creditloan.dao;

import com.softserve.creditloan.model.Client;
import com.softserve.creditloan.model.CreditLine;

import java.util.List;

public interface CreditLineDAO {
    List<CreditLine> loadAllCreditLines(int id);
    void saveCreditLine(CreditLine creditLine, Client client);
    CreditLine loadCreditLine(int id);
}
