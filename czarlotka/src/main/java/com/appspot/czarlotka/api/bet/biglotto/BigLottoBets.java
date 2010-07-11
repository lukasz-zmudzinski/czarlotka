package com.appspot.czarlotka.api.bet.biglotto;

import com.appspot.czarlotka.api.user.User;

import java.util.Collection;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-11
 * Time: 13:44:52
 */
public interface BigLottoBets {

    public abstract Collection<BigLottoBet> getAllForUser(User user);

    public abstract void create(BigLottoBet bet);

    public abstract void deleteById(Long id);


}
