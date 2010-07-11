package com.appspot.czarlotka.client;

import com.appspot.czarlotka.api.Messages;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("messages")
public interface MessagesService extends RemoteService, Messages {
    // marker interface
}
