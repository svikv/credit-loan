package com.softserve.creditloan.service;

import com.softserve.creditloan.dao.ClientDAO;
import com.softserve.creditloan.dao.CreditLineDAO;
import com.softserve.creditloan.model.Client;
import com.softserve.creditloan.model.CreditLine;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * CreditLineService class implements read and create operations on {@link CreditLine} instance in the database
 * The service uses Spring DataSourceTransactionManager for managing transaction with database and log4j for logging
 */

@Service
@Transactional
public class CreditLineService {

    private static final Logger LOGGER = Logger.getLogger(CreditLineService.class);

    @Autowired
    private CreditLineDAO creditLineDAO;

    @Autowired
    private ClientDAO clientDAO;

    /*
    Reading values from properties files using Spring @Value annotation
     */
    @Value("#{'${creditLine.period.default}'.split(',')}")
    private List<Integer> defaultPeriods;

    @Value("#{'${creditLine.rate.default}'.split(',')}")
    private List<Integer> defaultRates;

    @Value("#{'${creditLine.repayType.default}'.split(',')}")
    private List<String> defaultRepayTypes;

    public List<Integer> getDefaultPeriods() {
        return defaultPeriods;
    }

    public List<Integer> getDefaultRates() {
        return defaultRates;
    }

    public List<String> getDefaultRepayTypes() {
        return defaultRepayTypes;
    }

    /**
     * Generates current date for CreditLine instance
     */
    public String getCurrentDate(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new java.util.Date());
    }

    /**
     * Loading all stored {@link CreditLine} instances with their main information
     * @return List of {@link CreditLine} instances
     * @throws DataAccessException
     */
    public List<CreditLine> loadAllCreditLines(int clientId) {

        try {
            return creditLineDAO.loadAllCreditLines(clientId);
        } catch (DataAccessException e) {
            LOGGER.error("Unable to load CreditLine instances belonging to Client instance with the next id:" +clientId, e);
            throw e;
        }
    }

    /**
     * Saves {@link CreditLine} instance to DB.
     * @param creditLine instance which needs to be stored in the DB
     * @throws DataAccessException when there is no access to the DB
     */
    public void saveCreditLine(CreditLine creditLine, int clientId) {

        try {
            Client client = clientDAO.loadClient(clientId);
            creditLineDAO.saveCreditLine(creditLine, client);
        } catch (DataAccessException e) {
            LOGGER.error("Unable to save creditLine instance: ", e);
            throw e;
        }
    }
}