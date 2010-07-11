package com.appspot.czarlotka.api;

import java.util.Collection;

public interface Messages {

    public abstract Collection<Message> getAll();

    public abstract void create(Message message);

    public abstract void deleteById(Long id);

}