package com.jetminds.controller;

import com.jetminds.RegistrationServiceApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


/**
 * @author Erik Khalimov.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RegistrationServiceApplication.class)
@WebAppConfiguration
public class RegisterControllerTest {

    final String BASE_URL = "http://localhost:8080/";

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = standaloneSetup(new RegisterController()).build();
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
}