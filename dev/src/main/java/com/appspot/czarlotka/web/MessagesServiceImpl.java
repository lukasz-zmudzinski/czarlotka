package com.appspot.czarlotka.web;

import com.appspot.czarlotka.api.Message;
import com.appspot.czarlotka.api.Messages;
import com.appspot.czarlotka.client.MessagesService;
import com.appspot.czarlotka.server.MessageRepository;
import com.appspot.czarlotka.server.notification.email.Email;
import com.appspot.czarlotka.server.notification.email.EmailSender;
import com.appspot.czarlotka.server.notification.email.EmailSenderImpl;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.Collection;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class MessagesServiceImpl extends RemoteServiceServlet implements
        MessagesService {

    private Messages messageRepository = new MessageRepository();


    private EmailSender emailSender = new EmailSenderImpl();

    @Override
    public void create(Message message) {
        System.out.println(message);
        try {
            Email email = new Email();
            email.setMessage("wiadomość:" + message.getText());
            email.setRecipient(new InternetAddress("lucas.zmudzinski@gmail.com"));
            email.setSubject("Testowy email");
            emailSender.send(email);
        } catch (AddressException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        messageRepository.create(message);
    }

    @Override
    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public Collection<Message> getAll() {
        return messageRepository.getAll();
    }
}
