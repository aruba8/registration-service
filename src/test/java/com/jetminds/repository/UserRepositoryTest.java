package com.jetminds.repository;

import com.jetminds.RegistrationServiceApplication;
import com.jetminds.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * @author Erik Khalimov.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RegistrationServiceApplication.class)
@WebAppConfiguration
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        User firstUser = new User("first@email.com", "testpasswordfirst");
        User secondUser = new User("second@email.com", "testpasswordsecond");
        userRepository.deleteAll();
        userRepository.save(firstUser);
        userRepository.save(secondUser);
    }

    @Test
    public void testFindByEmail() throws Exception {
        User firstFoundUser = userRepository.findByEmail("first@email.com");
        User secondFoundUser = userRepository.findByEmail("second@email.com");
        assertEquals("first@email.com", firstFoundUser.getEmail());
        assertEquals("second@email.com", secondFoundUser.getEmail());
        assertEquals("testpasswordfirst", firstFoundUser.getPassword());
        assertEquals("testpasswordsecond", secondFoundUser.getPassword());
    }
}