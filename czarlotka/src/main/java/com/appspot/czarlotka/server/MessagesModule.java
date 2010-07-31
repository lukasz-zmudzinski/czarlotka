/*
 * Created by IntelliJ IDEA.
 * User: lukasz
 * Date: 2010-07-31
 * Time: 00:21:46
 */
package com.appspot.czarlotka.server;

import com.appspot.czarlotka.api.Messages;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class MessagesModule extends AbstractModule {
    protected void configure() {
        bind(Messages.class).to(MessageRepository.class).in(Scopes.SINGLETON);
    }
}
