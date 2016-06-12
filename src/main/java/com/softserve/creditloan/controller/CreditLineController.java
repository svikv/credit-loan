package com.softserve.creditloan.controller;

import com.softserve.creditloan.model.Client;
import com.softserve.creditloan.model.CreditLine;
import com.softserve.creditloan.service.CreditLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * CreditLineController class represents {@code CreditLine} MVC Controller. Handles and retrieves CreditLine pages depending on the URI template
 * @author Viktor Somka
 */

@Controller
@RequestMapping(value = "creditLines/private_persons")
public class CreditLineController {

    private static final String CREDIT_LINES = "creditLines";
    private static final String CREDIT_LINE = "creditLine";
    private static final String CLIENT_ID = "clientid";
    private static final String PERIODS = "periods";
    private static final String RATES = "rates";
    private static final String REPAY_TYPES = "repayTypes";

    @Autowired
    private CreditLineService creditLineService;

    /**
     * Retrieves page with existing CreditLine instance
     * @param id identifies {@link Client} instance which dependencies {@link CreditLine} to be loaded
     * @param model {@link Model} object
     * @return name of view
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String getCreditLinesList(@PathVariable(value = "id") int id, Model model) {

        List<CreditLine> creditLines = creditLineService.loadAllCreditLines(id);
        model.addAttribute(CLIENT_ID, id);
        model.addAttribute(CREDIT_LINES, creditLines);
        return "creditLine/list";
    }

    /**
     * Retrieves new CreditLine creation page.
     * @param id identifies {@link Client} instance which dependencies {@link CreditLine} to be loaded
     * @param model container with CreditLine object
     * @return name of view
     */
    @RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
    public String getCreditLine(@PathVariable int id, Model model) {

        model.addAttribute(CLIENT_ID, id);
        CreditLine creditLine = new CreditLine();
        creditLine.setOpeningDate(creditLineService.getCurrentDate());

        model.addAttribute(CREDIT_LINE, creditLine);
        List<Integer> periods = creditLineService.getDefaultPeriods();
        List<Integer> rates = creditLineService.getDefaultRates();
        List<String> repayTypes = creditLineService.getDefaultRepayTypes();

        model.addAttribute(PERIODS, periods);
        model.addAttribute(RATES, rates);
        model.addAttribute(REPAY_TYPES, repayTypes);
        return "creditLine/create";
    }

    /**
     * Handles creating new CreditLine instance
     * @param creditLine {@link CreditLine} instance to be saved
     * @param result {@link BindingResult} validation handle object
     * @param id identifies {@link Client} instance which dependencies {@link CreditLine} to be loaded
     * @param model {@link Model} object
     * @return name of view
     */
    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    public String saveCreditLine(@Validated @ModelAttribute("creditLine") CreditLine creditLine, BindingResult result, @PathVariable int id, Model model) {

        if (result.hasErrors()) {
            model.addAttribute(CLIENT_ID, id);
            return "creditLine/create";
        }

        creditLineService.saveCreditLine(creditLine, id);
        return "redirect:/creditLines/private_persons/get/{id}";
    }
}