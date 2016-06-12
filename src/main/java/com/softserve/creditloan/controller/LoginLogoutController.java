package com.softserve.creditloan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * Handles and retrieves login and home pages
 * @author Viktor Somka
 */

@Controller
public class LoginLogoutController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginLogoutController.class);

    /**
     * Retrieves login page
     * @return name of view
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Locale locale) {

        LOGGER.info("Welcome login page! The client locale is {}.", locale);
        if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/";
    }

    /**
     * Retrieves home page
     * @return name of view
     */
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String home(Locale locale) {

        LOGGER.info("Welcome home! The client locale is {}.", locale);
        return "home";
    }

    /**
     * Handles Access denied page
     * @param model {@link Model} object
     * @return name of error view
     */
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String error403(Model model) {

        model.addAttribute("message", "You don't have permission to access this page");
        return "error";
    }
}