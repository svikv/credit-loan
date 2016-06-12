package com.softserve.creditloan.dao;

import com.softserve.creditloan.model.Client;
import com.softserve.creditloan.model.CreditLine;
import com.softserve.creditloan.model.Payment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/database-context-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentDAOImplTest {

    @Autowired
    protected PaymentDAO paymentDAO;

    @Autowired
    protected CreditLineDAO creditLineDAO;

    @Autowired
    protected ClientDAO clientDAO;

    @Test
    @Transactional
    @Rollback(true)
    public void loadAllPaymentsTest() {

        Client client = new Client();
        clientDAO.saveOrUpdateClient(client);
        Assert.assertNotNull(client.getId());

        CreditLine creditLine = new CreditLine(100, 12, 12, "classical", "2015-06-08", "2016-06-08", true);
        creditLineDAO.saveCreditLine(creditLine, client);
        Assert.assertNotNull(creditLine.getId());

        Payment payment1 = new Payment();
        Payment payment2 = new Payment();
        paymentDAO.savePayment(payment1, creditLine);
        paymentDAO.savePayment(payment2, creditLine);
        List<Payment> payments = paymentDAO.loadAllPayments(creditLine.getId());
        Assert.assertTrue(payments.size() == 2);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void savePaymentTest() {

        CreditLine creditLine = new CreditLine();
        Payment payment = new Payment();
        paymentDAO.savePayment(payment, creditLine);
        Assert.assertNotNull(payment.getId());
    }
}