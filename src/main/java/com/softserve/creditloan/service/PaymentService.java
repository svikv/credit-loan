package com.softserve.creditloan.service;

import com.softserve.creditloan.dao.CreditLineDAO;
import com.softserve.creditloan.dao.PaymentDAO;
import com.softserve.creditloan.model.CreditLine;
import com.softserve.creditloan.model.Payment;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Payment class implements read operation on {@link Payment} instance in the database
 * The service uses Spring DataSourceTransactionManager for managing transaction with database and log4j for logging
 */

@Service
@Transactional
public class PaymentService {

    private static final Logger LOGGER = Logger.getLogger(PaymentService.class);

    @Autowired
    private PaymentDAO paymentDAO;

    @Autowired
    private CreditLineDAO creditLineDAO;

    /**
     * Invokes different methods for calculating, generating and saving Payment instance depending on the payment type(classical or annuity)
     */
    public void countPayments(int creditLineId){

        CreditLine creditLine = creditLineDAO.loadCreditLine(creditLineId);
        if (creditLine.getRepayType().equals("annuity")) {
            cauntAnnuityPayment(creditLine);
        }
        else if (creditLine.getRepayType().equals("classical")) {
            cauntClassicalPayment(creditLine);
        }
    }

    /**
     * Calculates, generates and saves Payment instance to the database in case of classical payment type
     * @param creditLine for which enclosed Payment instance to be generated and saved
     */
    public void cauntClassicalPayment(CreditLine creditLine){

        double amount = creditLine.getAmount();
        double period = creditLine.getPeriod();
        double rate = creditLine.getRate();
        int monthPeriod;
        int paymentAmount;

        double mounthRate = rate/(12*100);
        for(monthPeriod=0; monthPeriod<period; monthPeriod++){
            paymentAmount = (int) ((amount/period) + (amount - (amount/period)*monthPeriod)*mounthRate);
            Payment paymentObj = new Payment(monthPeriod+1, paymentAmount);
            savePayment(paymentObj, creditLine);
        }
    }

    /**
     * Calculates, generates and saves Payment instance to the database in case of annuity payment type
     * @param creditLine for which enclosed Payment instance to be generated and saved
     */
    public void cauntAnnuityPayment(CreditLine creditLine){

        double amount = creditLine.getAmount();
        double period = creditLine.getPeriod();
        double rate = creditLine.getRate();
        int monthPeriod;
        int paymentAmount;

        double mounthRate = rate/(12*100);
        paymentAmount = (int) (((mounthRate*(Math.pow(1+mounthRate,period))/((Math.pow(1+mounthRate,period))-1)))*amount);
        for(monthPeriod=0; monthPeriod<period; monthPeriod++){
            Payment paymentObj = new Payment(monthPeriod+1, paymentAmount);
            savePayment(paymentObj, creditLine);
        }
    }

    /**
     * Saves {@link CreditLine} instance to the database
     * @param payment instance which needs to be stored in the database
     * @throws DataAccessException when there is no access to the database
     */
    public void savePayment(Payment payment, CreditLine creditLine) {

        try {
            paymentDAO.savePayment(payment, creditLine);
        } catch (DataAccessException e) {
            LOGGER.error("Unable to save Payment instance: ", e);
            throw e;
        }
    }

    /**
     * Loads all stored {@link Payment} instances with their main information
     * @return List of {@link Payment} instances
     * @throws DataAccessException
     */
    public List<Payment> loadAllPayments(int creditLineId) {

        try {
            return paymentDAO.loadAllPayments(creditLineId);
        } catch (DataAccessException e) {
            LOGGER.error("Unable to load Payments instances belonging to CreditLine instance with the next id:" +creditLineId, e);
            throw e;
        }
    }
}