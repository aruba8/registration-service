package com.jetminds.service;

import java.util.Map;

/**
 * Service for send message to broker.
 */
public interface SendMessageService {
    /**
     * Send message.
     * @param message send to broker
     */
    void send(Map<String, String> message);
}
