package com.softserve.creditloan.controller;

import com.softserve.creditloan.model.Payment;
import com.softserve.creditloan.service.PaymentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 *  Unit testing of PaymentController class with mock objects
 */
@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

    private static final int ONCE = 1;
    private static final int TWICE = 2;
    private static final int ID = 1;

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    PaymentController paymentController;

    Model model = new Model() {
        @Override
        public Model addAttribute(String s, Object o) {
            return null;
        }

        @Override
        public Model addAttribute(Object o) {
            return null;
        }

        @Override
        public Model addAllAttributes(Collection<?> collection) {
            return null;
        }

        @Override
        public Model addAllAttributes(Map<String, ?> map) {
            return null;
        }

        @Override
        public Model mergeAttributes(Map<String, ?> map) {
            return null;
        }

        @Override
        public boolean containsAttribute(String s) {
            return false;
        }

        @Override
        public Map<String, Object> asMap() {
            return null;
        }
    };

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void showPaymentsTest() {

        String expected = "table";
        when(paymentService.loadAllPayments(ID)).thenReturn(new ArrayList<Payment>());
        assertEquals(paymentController.showPayments(ID, ONCE, model), expected);

        expected = "graphic";
        assertEquals(paymentController.showPayments(ID, TWICE, model), expected);
        verify(paymentService, atLeast(ONCE)).loadAllPayments(ID);
    }
}
