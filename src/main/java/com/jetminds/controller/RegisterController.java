package com.jetminds.controller;

import com.jetminds.model.User;
import com.jetminds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Register service controller.
 *
 * @author Erik Khalimov.
 */
@Controller
public class RegisterController {


    /**
     * Render register page.
     *
     * @return
     *  page
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerPage() {
        return "register";
    }

    /**
     * Register user.
     *
     * @param user
     *  user
     *
     * @return result
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@ModelAttribute("user") User user) {
        user.setIsConfirmed(false);
        try {
            userRepository.save(user);
        } catch (Exception ex) {
            return "error";
        }
        return "success";
    }

    /**
     * User repository.
     */
    @Autowired
    private UserRepository userRepository;

}
