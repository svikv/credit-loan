package com.softserve.creditloan.dao;

import com.softserve.creditloan.model.Client;
import com.softserve.creditloan.model.CreditLine;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/database-context-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CreditLineDAOImplTest {

    @Autowired
    protected CreditLineDAO creditLineDAO;

    @Autowired
    protected ClientDAO clientDAO;

    Client client = new Client();

    @Test
    @Transactional
    @Rollback(true)
    public void loadAllCreditLinesTest() {

        clientDAO.saveOrUpdateClient(client);
        Assert.assertNotNull(client.getId());

        CreditLine creditLine1 = new CreditLine(100, 12, 12, "classical", "2015-06-08", "2016-06-08", true);
        CreditLine creditLine2 = new CreditLine(500, 24, 12, "annuity", "2014-06-08", "2016-06-08", true);
        creditLineDAO.saveCreditLine(creditLine1, client);
        creditLineDAO.saveCreditLine(creditLine2, client);
        List<CreditLine> creditLines = creditLineDAO.loadAllCreditLines(client.getId());
        Assert.assertTrue(creditLines.size() == 2);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void saveCreditLineTest() {

        CreditLine creditLine = new CreditLine(100, 12, 12, "classical", "2015-06-08", "2016-06-08", true);
        creditLineDAO.saveCreditLine(creditLine, client);
        Assert.assertNotNull(creditLine.getId());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void loadCreditLineTest() {

        CreditLine creditLine1 = new CreditLine(100, 12, 12, "classical", "2015-06-08", "2016-06-08", true);
        creditLineDAO.saveCreditLine(creditLine1, client);
        CreditLine creditLineLoaded = creditLineDAO.loadCreditLine(creditLine1.getId());
        Assert.assertNotNull(creditLineLoaded);
        assertEquals(creditLineLoaded, creditLine1);
    }
}