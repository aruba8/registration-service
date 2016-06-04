package com.jetminds.service.SendMessageService;

import javax.jms.JMSException;
import java.util.Map;

/**
 * Service for send message to broker.
 */
public interface SendMessageService {

    /**
     * Send message.
     * @param message send to broker
     * @exception JMSException
     */
    void send(Map<String, String> message) throws JMSException;
}
