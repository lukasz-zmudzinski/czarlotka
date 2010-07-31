package com.appspot.czarlotka.client;

import com.appspot.czarlotka.api.Message;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.Collection;

public interface MessagesServiceAsync {

    void getAll(AsyncCallback<Collection<Message>> callback);

    void create(Message message, AsyncCallback<Void> callback);

    void deleteById(Long id, AsyncCallback<Void> callback);

}
