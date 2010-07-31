/*
 * Created by IntelliJ IDEA.
 * User: lukasz
 * Date: 2010-07-30
 * Time: 22:50:28
 */
package com.appspot.czarlotka.web;

import com.appspot.czarlotka.client.MessagesService;
import com.google.inject.servlet.ServletModule;

public class MessagesServletModule extends ServletModule {
    @Override
    protected void configureServlets() {
        System.out.println("configuring servlets ");
        serve("/messages/messages").with(GuiceRemoteServiceServlet.class);
        bind(MessagesService.class).to(MessagesServiceImpl.class);
    }

}
