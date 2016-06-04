package com.jetminds.service.sendMessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.Map;

/**
 * Sender message to broker.
 */
@Service
public class SendMessageServiceImpl implements SendMessageService {

    /**
     * Logger.
     */
    private Logger logger = LoggerFactory.getLogger(SendMessageServiceImpl.class);

    /**
     * Jmstemlate.
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * Queue.
     */
    @Autowired
    private Queue queue;

    /**
     * Send message to queue.
     * @param message send to broker
     */
    @Override
    public void send(Map<String, String> message) {
        jmsTemplate.convertAndSend(queue, message);
        logger.debug("Send message");
    }
}
