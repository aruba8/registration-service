package com.jetminds.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
public class QueueConfig {

    public static final String NAME_QUEUE = "message_queue";

    @Bean
    public Queue getQueueBroker() {
        return new ActiveMQQueue(NAME_QUEUE);
    }
}
