package com.appspot.czarlotka.server.lotto;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-11
 * Time: 01:58:56
 */
public class LotteryDateNotFoundException extends RuntimeException {
    public LotteryDateNotFoundException(Exception e) {
        super(e);
    }
}
