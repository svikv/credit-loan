package com.softserve.creditloan.controller;

import com.softserve.creditloan.model.CreditLine;
import com.softserve.creditloan.service.CreditLineService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.beans.PropertyEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 *  Unit testing of CreditLine class with mock objects
 */
@RunWith(MockitoJUnitRunner.class)
public class CreditLineControllerTest {

    private static final int ONCE = 1;
    private static final int ID = 1;

    @Mock
    private CreditLineService creditLineService;

    @InjectMocks
    CreditLineController creditLineController;

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
    CreditLine creditLine = new CreditLine();
    BindingResult result = new BindingResult() {
        @Override
        public Object getTarget() {
            return null;
        }

        @Override
        public Map<String, Object> getModel() {
            return null;
        }

        @Override
        public Object getRawFieldValue(String s) {
            return null;
        }

        @Override
        public PropertyEditor findEditor(String s, Class<?> aClass) {
            return null;
        }

        @Override
        public PropertyEditorRegistry getPropertyEditorRegistry() {
            return null;
        }

        @Override
        public void addError(ObjectError objectError) {

        }

        @Override
        public String[] resolveMessageCodes(String s) {
            return new String[0];
        }

        @Override
        public String[] resolveMessageCodes(String s, String s1) {
            return new String[0];
        }

        @Override
        public void recordSuppressedField(String s) {

        }

        @Override
        public String[] getSuppressedFields() {
            return new String[0];
        }

        @Override
        public String getObjectName() {
            return null;
        }

        @Override
        public void setNestedPath(String s) {

        }

        @Override
        public String getNestedPath() {
            return null;
        }

        @Override
        public void pushNestedPath(String s) {

        }

        @Override
        public void popNestedPath() throws IllegalStateException {

        }

        @Override
        public void reject(String s) {

        }

        @Override
        public void reject(String s, String s1) {

        }

        @Override
        public void reject(String s, Object[] objects, String s1) {

        }

        @Override
        public void rejectValue(String s, String s1) {

        }

        @Override
        public void rejectValue(String s, String s1, String s2) {

        }

        @Override
        public void rejectValue(String s, String s1, Object[] objects, String s2) {

        }

        @Override
        public void addAllErrors(Errors errors) {

        }

        @Override
        public boolean hasErrors() {
            return false;
        }

        @Override
        public int getErrorCount() {
            return 0;
        }

        @Override
        public List<ObjectError> getAllErrors() {
            return null;
        }

        @Override
        public boolean hasGlobalErrors() {
            return false;
        }

        @Override
        public int getGlobalErrorCount() {
            return 0;
        }

        @Override
        public List<ObjectError> getGlobalErrors() {
            return null;
        }

        @Override
        public ObjectError getGlobalError() {
            return null;
        }

        @Override
        public boolean hasFieldErrors() {
            return false;
        }

        @Override
        public int getFieldErrorCount() {
            return 0;
        }

        @Override
        public List<FieldError> getFieldErrors() {
            return null;
        }

        @Override
        public FieldError getFieldError() {
            return null;
        }

        @Override
        public boolean hasFieldErrors(String s) {
            return false;
        }

        @Override
        public int getFieldErrorCount(String s) {
            return 0;
        }

        @Override
        public List<FieldError> getFieldErrors(String s) {
            return null;
        }

        @Override
        public FieldError getFieldError(String s) {
            return null;
        }

        @Override
        public Object getFieldValue(String s) {
            return null;
        }

        @Override
        public Class<?> getFieldType(String s) {
            return null;
        }
    };

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCreditLinesListTest() {

        String expected = "creditLine/list";
        when(creditLineService.loadAllCreditLines(ID)).thenReturn(new ArrayList<CreditLine>());
        assertEquals(creditLineController.getCreditLinesList(ID, model), expected);
        verify(creditLineService, times(ONCE)).loadAllCreditLines(ID);
    }

    @Test
    public void getCreditLineTest() {

        String date = "";
        String expected = "creditLine/create";
        when(creditLineService.getCurrentDate()).thenReturn(date);
        when(creditLineService.getDefaultPeriods()).thenReturn(new ArrayList<>());
        when(creditLineService.getDefaultRates()).thenReturn(new ArrayList<>());
        when(creditLineService.getDefaultRepayTypes()).thenReturn(new ArrayList<>());
        assertEquals(creditLineController.getCreditLine(ID, model), expected);
        verify(creditLineService, times(ONCE)).getDefaultPeriods();
        verify(creditLineService, times(ONCE)).getDefaultRates();
        verify(creditLineService, times(ONCE)).getDefaultRepayTypes();
        verify(creditLineService, times(ONCE)).getCurrentDate();
    }

    @Test
    public void saveCreditLineTest() {

        String expected = "redirect:/creditLines/private_persons/get/{id}";
        doNothing().when(creditLineService).saveCreditLine(creditLine, ID);

        assertEquals(creditLineController.saveCreditLine(creditLine, result, ID, model), expected);
        verify(creditLineService, times(ONCE)).saveCreditLine(creditLine, ID);
    }
}
