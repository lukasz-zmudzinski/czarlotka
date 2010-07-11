package com.appspot.czarlotka.server.lotto;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-11
 * Time: 15:11:54
 */
public class LottoGuiceServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new LottoIntegrationModule());
    }
}
