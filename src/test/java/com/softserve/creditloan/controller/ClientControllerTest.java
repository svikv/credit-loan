package com.softserve.creditloan.controller;

import com.softserve.creditloan.dao.ClientDAO;
import com.softserve.creditloan.model.Client;
import com.softserve.creditloan.service.ClientService;
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
 *  Unit testing of ClientController class with mock objects
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientControllerTest {

    private static final int ONCE = 1;
    private static final int ID = 1;

    @Mock
    private ClientService clientService;

    @Mock
    private ClientDAO clientDAO;

    @InjectMocks
    ClientController clientController;

    List<Client> clients = new ArrayList<Client>();
    Client client = new Client();
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
    public void clientListTest() {

        String expected = "client/list";
        when(clientService.loadAllClients()).thenReturn(clients);
        assertEquals(clientController.clientList(model), expected);
        verify(clientService, times(ONCE)).loadAllClients();
    }

    @Test
    public void getClientTest() {

        String expected = "client/update";
        when(clientService.loadClient(ID)).thenReturn(client);
        assertEquals(clientController.getClient(ID, model), expected);
        verify(clientService, times(ONCE)).loadClient(ID);
    }

    @Test
    public void createClientTest() {

        String expected = "client/update";
        assertEquals(clientController.createClient(model), expected);
    }

    @Test
    public void saveCreatedClientTest() {

        String expected = "redirect:/clients/private_persons";
        doNothing().when(clientService).saveOrUpdateClient(client);
        assertEquals(clientController.saveCreatedClient(client, result, model), expected);
        verify(clientService, times(ONCE)).saveOrUpdateClient(client);
    }

    @Test
    public void saveUpdatedClientTest() {

        String expected = "redirect:/clients/private_persons";
        doNothing().when(clientService).saveOrUpdateClient(client);
        assertEquals(clientController.saveUpdatedClient(client, result, model), expected);
        verify(clientService, times(ONCE)).saveOrUpdateClient(client);
    }

    @Test
    public void deleteClientTest() {

        String expected = "redirect:/clients/private_persons";
        doNothing().when(clientService).deleteClient(ID);
        assertEquals(clientController.deleteClient(ID), expected);
        verify(clientService, times(ONCE)).deleteClient(ID);
    }
}
