package com.appspot.czarlotka.server.notification.email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class EmailSenderImpl implements EmailSender {
    @Override
    public void send(Email email) {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress("czarlotka.serwis@gmail.com", "Serwis Czarlotka"));
            msg.addRecipient(Message.RecipientType.TO, email.getRecipient());
            msg.setSubject(email.getSubject());
            msg.setText(email.getMessage());
            Transport.send(msg);
        } catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        } catch (UnsupportedEncodingException e) {
            // ...
        }
    }
}
