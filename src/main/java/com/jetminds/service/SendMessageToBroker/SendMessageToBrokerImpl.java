package com.jetminds.service.SendMessageToBroker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.Map;

/*
sender message to broker
 */
@Service
public class SendMessageToBrokerImpl implements SendMessageToBroker {

    /*
    logger
     */
    private Logger logger = LoggerFactory.getLogger(SendMessageToBrokerImpl.class);

    /*
    jmstemlate
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    /*
    queue
     */
    @Autowired
    private Queue queue;

    /*
    Send message to queue
     */
    @Override
    public void send(Map<String, String> message) {
        jmsTemplate.convertAndSend(queue, message);
        logger.debug("Send message");
    }
}
