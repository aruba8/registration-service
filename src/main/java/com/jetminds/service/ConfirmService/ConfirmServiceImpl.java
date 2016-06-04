package com.jetminds.service.confirmService;

import com.jetminds.model.User;
import com.jetminds.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of confirm service.
 *
 * @author Erik Khalimov.
 */
@Service
public class ConfirmServiceImpl implements ConfirmService {

    /**
     * Logger.
     */
    private Logger logger = LoggerFactory.getLogger(ConfirmServiceImpl.class);

    /**
     * user repo.
     */
    @Autowired
    private UserRepository userRepository;


    /**
     *confirm user implementation.
     *
     * @param uuid - hash to check
     *
     * @return
     *  true if user confirmed
     */
    @Override
    public Boolean confirmUser(String uuid) {
        User user = userRepository.findByUuid(uuid);
        if (user == null) {
            return false;
        } else {
            user.setIsConfirmed(true);
            userRepository.save(user);
            return true;
        }
    }
}
