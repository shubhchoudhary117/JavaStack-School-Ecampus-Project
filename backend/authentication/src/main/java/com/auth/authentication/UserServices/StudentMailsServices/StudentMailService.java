package com.auth.authentication.UserServices.StudentMailsServices;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class StudentMailService {

    public Boolean doEmail(String from, String to, String subject, String message) {

        String host = "smtp.gmail.com";

        // set the properties
        Properties properties = System.getProperties();
        // set the some extra properties
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // setp-1 to get the session object
        Session session = Session.getInstance(properties, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // TODO Auto-generated method stub
                return new PasswordAuthentication("shubhamakky711@gmail.com", "oehyokifoorwkifr");
            }

        });

        session.setDebug(true);
        // step2- composs the message
        MimeMessage m = new MimeMessage(session);
        // set the email  message content
        try{
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            m.setSubject(subject);
            m.setText(message);

            // send the message to Transport call
            Transport.send(m);
            System.out.println("send success");
        }
       catch(Exception e){
        e.printStackTrace();
       }
        return true;
    }
}
