package com.appspot.czarlotka.client;

import com.appspot.czarlotka.api.Message;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.Collection;

@RemoteServiceRelativePath("messages")
public interface MessagesService extends RemoteService/*, Messages*/ {

    /*todo nie dziala uwspolniony interfejs w guice*/

    public abstract Collection<Message> getAll();

    public abstract void create(Message message);

    public abstract void deleteById(Long id);

}