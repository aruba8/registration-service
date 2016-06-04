package com.jetminds.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * Class configuration queue.
 */
@Configuration
public class QueueConfig {

    /**
     * Name queue.
     */
    public static final String NAME_QUEUE = "message_queue";

    /**
     * Bean queue.
     * @return Queue.
     */
    @Bean
    public Queue getQueueBroker() {
        return new ActiveMQQueue(NAME_QUEUE);
    }
}
