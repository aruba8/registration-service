package com.jetminds.controller;

import com.jetminds.model.User;
import com.jetminds.repository.UserRepository;
import com.jetminds.service.confirmService.ConfirmService;
import com.jetminds.service.sendMessageService.SendMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Register service controller.
 *
 * @author Erik Khalimov.
 */
@Controller
public class RegisterController {

    /**
     * Logger.
     */
    private Logger logger = LoggerFactory.getLogger(RegisterController.class);


    /**
     * Render register page.
     *
     * @return page
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerPage() {
        return "register";
    }

    /**
     * Register user.
     *
     * @param user user
     * @return result
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@ModelAttribute("user") User user) {
        user.setIsConfirmed(false);
        user.setUuid(UUID.randomUUID().toString());
        try {
            logger.debug(user.getUuid());
            userRepository.save(user);
        } catch (Exception ex) {
            return "error";
        }

        Map<String, String> message = new HashMap<>();
        message.put("email", user.getEmail());
        message.put("password", user.getPassword());
        message.put("code", user.getUuid());
        sendMessageToBroker.send(message);

        return "success";
    }

    /**
     * Confirm user.
     *
     * @param uuid - uuid to check
     * @return result
     */
    @RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
    public String confirm(@PathVariable String uuid) {
        if (confirmService.confirmUser(uuid)) {
            return "successPage";
        } else {
            return "errorPage";
        }
    }

    /**
     * User repository.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Service to confirm user.
     */
    @Autowired
    private ConfirmService confirmService;

    /**
     * Service to send message.
     */
    @Autowired
    private SendMessageService sendMessageToBroker;

}
