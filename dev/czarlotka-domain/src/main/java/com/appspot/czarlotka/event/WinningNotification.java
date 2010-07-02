package com.appspot.czarlotka.event;

import com.appspot.czarlotka.user.User;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-01
 * Time: 22:36:51
 */
public class WinningNotification {
    private User user;


    public WinningNotification(User user) {
        this.user = user;
    }
}
