package com.jetminds.service.SendMessageToBroker;

import javax.jms.JMSException;
import java.util.Map;

public interface SendMessageToBroker {

    void send(Map<String, String> o) throws JMSException;
}
