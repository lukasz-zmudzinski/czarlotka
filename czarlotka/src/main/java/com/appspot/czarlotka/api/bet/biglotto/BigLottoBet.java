package com.appspot.czarlotka.api.bet.biglotto;

import com.appspot.czarlotka.api.user.User;

import javax.jdo.annotations.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-11
 * Time: 02:33:47
 */
@SuppressWarnings({"NonJREEmulationClassesInClientCode"})
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class BigLottoBet implements Serializable {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private User user;

    @Persistent
    private Date activeFrom;

    @Persistent
    private Date activeTo;

    @Persistent
    private Collection<Byte> numbers;
}
