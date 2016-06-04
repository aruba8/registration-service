package com.jetminds.service.SendService;

import java.util.Map;

/**
 * Service snd email.
 */
public interface SendEmailService {

    /**
     * Send email.
     * @param receiveMessage message received.
     * @return flag for test.
     *
     */
    boolean sendEmail(Map<String, String> receiveMessage);
}
