package com.softserve.creditloan.service;

import com.softserve.creditloan.dao.CreditLineDAO;
import com.softserve.creditloan.dao.PaymentDAO;
import com.softserve.creditloan.model.CreditLine;
import com.softserve.creditloan.model.Payment;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class PaymentServiceTest {

    private static final int ONCE = 1;
    private static final int TWICE = 2;
    private static final int ID = 1;

    @Mock
    private PaymentDAO paymentDAO;

    @Mock
    private CreditLineDAO creditLineDAO;

    @InjectMocks
    PaymentService paymentService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void countPaymentsTest() {

        CreditLine creditLine = new CreditLine();
        creditLine.setRepayType("annuity");
        when(creditLineDAO.loadCreditLine(ID)).thenReturn(creditLine);
        assertEquals(creditLine, creditLineDAO.loadCreditLine(ID));
        verify(creditLineDAO, times(ONCE)).loadCreditLine(ID);
        paymentService.countPayments(ID);
        verify(creditLineDAO, times(TWICE)).loadCreditLine(ID);
    }

    @Test
    public void cauntAnnuityPaymentTest() {

        double amount = 100_000;
        double period = 60;
        double rate = 16;
        int paymentAmountExpected = 2_431;
        int paymentAmountResult;
        double mounthRate = rate/(12*100);
        paymentAmountResult = (int) (((mounthRate*(Math.pow(1+mounthRate,period))/((Math.pow(1+mounthRate,period))-1)))*amount);

        assertEquals(paymentAmountExpected, paymentAmountResult);
    }

    @Test
    public void cauntClassicalPaymentTest() {

        double amount = 100_000;
        double period = 60;
        double rate = 16;
        int monthPeriod;
        int paymentAmount;
        int paymentAmountFirstMonthExpected = 3000;
        int paymentAmountLastMonthExpected = 1688;
        int paymentAmountFirstMonthResult;
        int paymentAmountLastMonthResult;

        double mounthRate = rate/(12*100);
        List<Payment> payments = new ArrayList<>();

        for(monthPeriod=0; monthPeriod<period; monthPeriod++){
            paymentAmount = (int) ((amount/period) + (amount - (amount/period)*monthPeriod)*mounthRate);
            Payment paymentObj = new Payment(monthPeriod+1, paymentAmount);
            payments.add(paymentObj);
        }

        paymentAmountFirstMonthResult = payments.get(0).getPaymentAmount();
        paymentAmountLastMonthResult = payments.get(payments.size()-1).getPaymentAmount();
        assertEquals(paymentAmountFirstMonthExpected, paymentAmountFirstMonthResult);
        assertEquals(paymentAmountLastMonthExpected, paymentAmountLastMonthResult);
    }

    @Test
    public void loadAllPaymentsTest() {

        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment());
        payments.add(new Payment());
        int expected = payments.size();

        when(paymentDAO.loadAllPayments(ID)).thenReturn(payments);
        assertEquals(payments, paymentDAO.loadAllPayments(ID));
        verify(paymentDAO, times(ONCE)).loadAllPayments(ID);
        assertTrue(paymentService.loadAllPayments(ID).size() == expected);
    }

    @Test
    public void savePaymentTest() {

        Payment payment = new Payment();
        CreditLine creditLine = new CreditLine();
        doNothing().when(paymentDAO).savePayment(payment, creditLine);
        paymentService.savePayment(payment, creditLine);
        verify(paymentDAO, times(ONCE)).savePayment(payment, creditLine);
    }
}