package com.softserve.creditloan.controller;

import com.softserve.creditloan.model.Client;
import com.softserve.creditloan.service.ClientService;
import com.softserve.creditloan.validator.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClientController class represents {@code Client} MVC Controller. Handles and retrieves Client pages depending on the URI template
 * @author Viktor Somka
 */

@Controller
@RequestMapping(value = "clients/private_persons")
public class ClientController {

    private static final String CLIENTS = "clients";
    private static final String CLIENT = "client";
    private static final String IS_UPDATE = "isUpdate";

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientValidator clientValidator;

    @InitBinder("client")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(clientValidator);
    }

    /**
     * Retrieves page with existing Client instances
     * @param model {@link Model} object
     * @return name of view
     */
    @RequestMapping(method = RequestMethod.GET)
    public String clientList(Model model) {

        List<Client> clients = clientService.loadAllClients();
        model.addAttribute(CLIENTS, clients);
        return "client/list";
    }

    /**
     * Retrieves Client modify page
     * @param id identifier of modifying {@link Client} instance
     * @param model {@link Model} object
     * @return name of view
     */
    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String getClient(@PathVariable(value = "id") int id, Model model) {

        Client client = clientService.loadClient(id);
        model.addAttribute(IS_UPDATE, true);
        model.addAttribute(CLIENT, client);
        return "client/update";
    }

    /**
     * Retrieves new Client creation page
     * @param model {@link Model} object
     * @return name of view
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createClient(Model model) {

        model.addAttribute(IS_UPDATE, false);
        model.addAttribute(CLIENT, new Client());
        return "client/update";
    }

    /**
     * Handles creating new Client instance
     * @param client {@link Client} instance to be saved
     * @param result {@link BindingResult} validation handle object
     * @param model {@link Model} object
     * @return name of view
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveCreatedClient(@Validated @ModelAttribute("client") Client client, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute(IS_UPDATE, false);
            return "client/update";
        }

        clientService.saveOrUpdateClient(client);
        return "redirect:/clients/private_persons";
    }

    /**
     * Handles modifying an existing Client instance
     * @param client {@link Client} instance to be saved
     * @param result {@link BindingResult} validation handle object
     * @param model {@link Model} object
     * @return Client main page if success, in case of validation errors returns to modifying page
     */
    @RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
    public String saveUpdatedClient(@Validated @ModelAttribute("client") Client client, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute(IS_UPDATE, true);
            return "client/update";
        }

        clientService.saveOrUpdateClient(client);
        return "redirect:/clients/private_persons";
    }

    /**
     * Retrieves Client deleting page
     * @param id identifies {@link Client} instance to be deleted
     * @return if success, redirects to Client main page
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteClient(@PathVariable(value = "id") int id) {

        clientService.deleteClient(id);
        return "redirect:/clients/private_persons";
    }
}