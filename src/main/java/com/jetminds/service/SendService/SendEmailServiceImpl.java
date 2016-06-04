package com.jetminds.service.SendService;

import com.jetminds.config.QueueConfig;
import com.jetminds.model.BodyEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Map;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    /*
    Logger
     */
    private Logger logger = LoggerFactory.getLogger(SendEmailServiceImpl.class);

    @Autowired
    private JavaMailSenderImpl mailSender;

    /*
    listener queue
    @param received message
     */
    @JmsListener(destination = QueueConfig.NAME_QUEUE)
    public void receiveMessage(Map<String, String> receiveMessage) {
        logger.debug("Receive message with queue to failed");
        sendEmail(receiveMessage);
    }

    public boolean sendEmail(Map<String, String> receiveMessage) {

        /*
        the sender's e-mail
         */
        String emailFrom = "";
        BodyEmail bodyEmail = new BodyEmail();

        String passwordUser = receiveMessage.get("password");
        String emailUser = receiveMessage.get("email");
        String codeUser = receiveMessage.get("code");
        bodyEmail.setParameter(passwordUser, emailUser, codeUser);

        mailSender.setProtocol("smtp");

        MimeMessage emailMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(emailMessage);
        try {
            emailMessage.setContent(bodyEmail.getBodyEmail(), "text/html");
            messageHelper.setTo(emailUser);
            messageHelper.setFrom(emailFrom);
            mailSender.send(emailMessage);
            logger.debug("Send email" + emailUser);
            return true;
        } catch (MessagingException e) {
            logger.debug("Error send email " + e.toString());
            return false;
        }
    }
}
