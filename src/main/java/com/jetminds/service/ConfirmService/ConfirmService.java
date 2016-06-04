package com.jetminds.service.ConfirmService;


/**
 * Service will handle confirmation for user.
 *
 * @author Erik Khalimov.
 */
public interface ConfirmService {

    /**
     * Method will confirm user.
     *
     * @param uuid - hash to check
     *
     * @return
     *  true if confirmed
     */
    Boolean confirmUser(String uuid);
}
