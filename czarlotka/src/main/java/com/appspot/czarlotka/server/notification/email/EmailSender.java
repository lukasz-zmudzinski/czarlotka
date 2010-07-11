package com.appspot.czarlotka.server.notification.email;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-10
 * Time: 21:18:26
 */
public interface EmailSender {
    void send(Email email);
}
