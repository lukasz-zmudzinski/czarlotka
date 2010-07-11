package com.appspot.czarlotka.server.notification.email;

import javax.mail.Address;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-10
 * Time: 19:53:23
 */
public class Email {
    private Address recipient;
    private String subject;
    private String message;

    public Email setRecipient(Address recipient) {
        this.recipient = recipient;
        return this;
    }

    public Email setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Email setMessage(String message) {
        this.message = message;
        return this;
    }

    public Address getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }


    public String getMessage() {
        return message;
    }
}
