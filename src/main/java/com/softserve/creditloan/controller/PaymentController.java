package com.softserve.creditloan.controller;

import com.softserve.creditloan.model.CreditLine;
import com.softserve.creditloan.model.Payment;
import com.softserve.creditloan.service.PaymentService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * PaymentController class represents {@code Payment} MVC Controller. Handles and retrieves Payment pages depending on the URI template
 * @author Viktor Somka
 */

@Controller
@RequestMapping(value = "payments/private_persons")
public class PaymentController {

    private static final String PAYMENTS = "payments";

    @Autowired
    private PaymentService paymentService;

    /**
     * Retrieves page with existing Payment instance
     * @param id identifies {@link CreditLine} instance which dependencies {@link Payment} to be loaded
     * @param viewType determines name of view
     * @param model {@link Model} object
     * @return name of view
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String showPayments(@PathVariable(value = "id") int id, @RequestParam("viewType") int viewType, Model model) {

        List<Payment> payments = paymentService.loadAllPayments(id);
        if (!CollectionUtils.isNotEmpty(payments)) {
            paymentService.countPayments(id);
            payments = paymentService.loadAllPayments(id);
        }
        model.addAttribute(PAYMENTS, payments);

        if (viewType == 1) {
            return "table";
        }
        return "graphic";
    }
}