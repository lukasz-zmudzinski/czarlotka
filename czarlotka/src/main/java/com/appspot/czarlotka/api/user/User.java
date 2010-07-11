package com.appspot.czarlotka.api.user;

import java.io.Serializable;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-01
 * Time: 23:08:26
 */
public class User implements Serializable {

    private String login;
    private String email;

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
