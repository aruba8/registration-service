package com.jetminds.service.SendMessageService;

import javax.jms.JMSException;
import java.util.Map;

public interface SendMessageService {

    void send(Map<String, String> o) throws JMSException;
}
