package com.softserve.creditloan.validator;

import com.softserve.creditloan.model.Client;
import com.softserve.creditloan.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Implementation of {@link Validator} interface for additional checking {@link Client} instance. Checks the uniqueness of
 * Client`s identificationNumber.
 */
@Component
public class ClientValidator implements Validator {

    @Autowired
    private ClientService clientService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    /**
     * Checks if Client object with this identificationNumber already exists in the DB
     * @param object to be checked for validity
     * @param errors determines message when Client object with such identificationNumber already exists
     */

    @Override
    public void validate(Object object, Errors errors) {

        Client client = (Client) object;
        String identificationNumber = client.getIdentificationNumber();

        if (identificationNumber.length() < 10 || identificationNumber.length() > 10){
            errors.rejectValue("identificationNumber", "Size.client.identificationNumber");
        }

        else if (!clientService.isClientIdentificationNumberFree(identificationNumber)) {
            errors.rejectValue("identificationNumber", "NotUnique.client.identificationNumber");
        }
    }
}