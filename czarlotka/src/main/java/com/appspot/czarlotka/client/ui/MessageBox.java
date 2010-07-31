package com.appspot.czarlotka.client.ui;

import com.appspot.czarlotka.api.Message;
import com.appspot.czarlotka.client.MessagesServiceAsync;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.Collection;
import java.util.List;

/**
 * @author drone
 * @version 1.0
 */
public class MessageBox extends VerticalPanel {

    private MessagesServiceAsync messagesServiceAsync;

    public void setMessagesService(MessagesServiceAsync messagesServiceAsync) {
        this.messagesServiceAsync = messagesServiceAsync;
    }

    public void update() {
        AsyncCallback<Collection<Message>> callback = new AsyncCallback<Collection<Message>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("failure: " + caught.getMessage());
            }

            @Override
            public void onSuccess(Collection<Message> result) {
                update(result);
            }
        };

        messagesServiceAsync.getAll(callback);
    }

    protected void update(Collection<Message> messages) {
        clear();

        for (Message message : messages) {
            Panel panel = new FlowPanel();
            panel.setStyleName("message");

            Label messageText = new Label(message.getText());
            messageText.setStyleName("messageText");
            panel.add(messageText);

            Button button = new Button("Delete");
            button.addStyleName("deleteButton");
            button.addClickHandler(new DeleteClickHandler(message.getId()));

            panel.add(button);

            add(panel);
        }
    }

    protected class DeleteClickHandler implements ClickHandler {

        private Long id;

        public DeleteClickHandler(Long id) {
            this.id = id;
        }

        @Override
        public void onClick(ClickEvent event) {
            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                @Override
                public void onFailure(Throwable caught) {
                    update();
                }

                @Override
                public void onSuccess(Void result) {
                    update();
                }
            };

            messagesServiceAsync.deleteById(id, callback);
        }
    }
}
