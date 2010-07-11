package com.appspot.czarlotka.server.notification;

import com.appspot.czarlotka.server.notification.email.EmailSender;
import com.appspot.czarlotka.server.notification.email.EmailSenderImpl;
import com.google.inject.AbstractModule;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-01
 * Time: 22:03:27
 */
public class NotificationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(EmailSender.class).to(EmailSenderImpl.class);
    }
}
