package com.jetminds.controller;

import com.jetminds.RegistrationServiceApplication;
import com.jetminds.model.User;
import com.jetminds.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;


/**
 * @author Erik Khalimov.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RegistrationServiceApplication.class)
@WebAppConfiguration
public class RegisterControllerTest {

    private MockMvc mockMvc;
    private String email = "test@email.com";

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        User user = new User(email, "password");
        UUID uuid = UUID.randomUUID();
        user.setUuid(uuid.toString());
        user.setIsConfirmed(false);
        userRepository.deleteAll();
        userRepository.save(user);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("");
    }

    @Test
    public void testRegisterPage() throws Exception {
        this.mockMvc.perform(get("/registration")).andExpect(status().isOk());

    }

    @Test
    public void testAddUser() throws Exception {
        this.mockMvc.perform(post("/registration")).andExpect(status().isOk());

    }

    @Test
    public void testConfirm() throws Exception {
        User user = userRepository.findByEmail(email);
        this.mockMvc.perform(get("/confirm/" + user.getUuid()))
                .andExpect(status().isOk())
                .andExpect(xpath("//h1[contains(text(), 'You have successfully entered!')]").exists());
        this.mockMvc.perform(get("/confirm/" + "wrongsmth"))
                .andExpect(status().isOk())
                .andExpect(xpath("//h1[contains(text(), 'Something went wrong!')]").exists());
    }
}