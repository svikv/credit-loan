package com.softserve.creditloan.service;

import com.softserve.creditloan.dao.ClientDAO;
import com.softserve.creditloan.dao.CreditLineDAO;
import com.softserve.creditloan.model.Client;
import com.softserve.creditloan.model.CreditLine;
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

public class CreditLineServiceTest {

    private static final int ONCE = 1;
    private static final int ID = 1;

    @Mock
    private CreditLineDAO creditLineDAO;

    @Mock
    private ClientDAO clientDAO;

    @InjectMocks
    CreditLineService creditLineService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadAllCreditLinesTest() {

        List<CreditLine> creditLines = new ArrayList<>();
        creditLines.add(new CreditLine());
        creditLines.add(new CreditLine());
        int expected = creditLines.size();

        when(creditLineDAO.loadAllCreditLines(ID)).thenReturn(creditLines);
        assertEquals(creditLines, creditLineDAO.loadAllCreditLines(ID));
        verify(creditLineDAO, times(ONCE)).loadAllCreditLines(ID);
        assertTrue(creditLineService.loadAllCreditLines(ID).size() == expected);
    }

    @Test
     public void saveCreditLineTest() {

        Client client = new Client();
        when(clientDAO.loadClient(ID)).thenReturn(client);
        CreditLine creditLine = new CreditLine();
        doNothing().when(creditLineDAO).saveCreditLine(creditLine, client);

        creditLineService.saveCreditLine(creditLine, ID);
        verify(creditLineDAO, times(ONCE)).saveCreditLine(creditLine, client);
    }
}