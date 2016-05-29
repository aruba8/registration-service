package com.jetminds.repository;

import com.jetminds.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * User repository interface.
 *
 * @author Erik Khalimov.
 */
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Finds user by email.
     *
     * @param email
     *  email
     * @return
     *  found user
     */
    User findByEmail(String email);
    
    User findByUuid(String uuid);
}
