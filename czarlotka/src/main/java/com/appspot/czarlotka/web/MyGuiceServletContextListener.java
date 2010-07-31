package com.appspot.czarlotka.web;

import com.appspot.czarlotka.server.MessagesModule;
import com.appspot.czarlotka.server.notification.NotificationModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-30
 * Time: 22:53:05
 */
public class MyGuiceServletContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        System.out.println("Context initiated");
        return Guice.createInjector(
                new MessagesServletModule(),
                new MessagesModule(),
                new NotificationModule());
    }
}
