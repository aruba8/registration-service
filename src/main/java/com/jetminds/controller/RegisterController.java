package com.jetminds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Register service controller.
 *
 * @author Erik Khalimov.
 */
@Controller
public class RegisterController {

    /**
     * Render register page.
     * @return
     *  page
     */
    @RequestMapping("/registration")
    public String registerPage() {
        return "register";
    }

}
