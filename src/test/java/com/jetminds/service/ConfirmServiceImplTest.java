package com.jetminds.service;

import com.jetminds.RegistrationServiceApplication;
import com.jetminds.model.User;
import com.jetminds.repository.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.UUID;


/**
 * @author Erik Khalimov.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RegistrationServiceApplication.class)
@WebAppConfiguration
public class ConfirmServiceImplTest {
    
    @Autowired
    private ConfirmService confirmService;
    
    @Autowired
    private UserRepository userRepository;
    
    User testUser1;
    User testUser2;
    UUID uuid1;
    UUID uuid2;

    @Before
    public void setUp() throws Exception{
        testUser1 = new User("test@email.ca", "passwo33rd!");
        testUser2 = new User("test2@email.ca", "passw33ord2!");
        uuid1 = UUID.randomUUID();
        uuid2 = UUID.randomUUID();
        testUser1.setUuid(uuid1.toString());
        testUser2.setUuid(uuid2.toString());
        userRepository.deleteAll();
        userRepository.save(testUser1);
        userRepository.save(testUser2);
    }
    
    @After
    public void tearDown() throws Exception{
        userRepository.deleteAll();
    }

    @Test
    public void testConfirmUser() throws Exception {
        Boolean result = confirmService.confirmUser(uuid1.toString());
        Assert.assertEquals(true, result);
    }

    @Test
    public void testWrongUuid() throws Exception{
        UUID newUuid = UUID.randomUUID();
        Boolean result = confirmService.confirmUser(newUuid.toString());
        Assert.assertEquals(false, result);
    }
    
    

}