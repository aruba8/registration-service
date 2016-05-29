package com.jetminds.service;

import com.jetminds.model.User;
import com.jetminds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Erik Khalimov.
 */
@Service
public class ConfirmServiceImpl implements ConfirmService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean confirmUser(String uuid) {
        User user = userRepository.findByUuid(uuid);
        if (user == null) {
            return false;
        } else {
            user.setIsConfirmed(true);
            return true;
        }
    }
}
