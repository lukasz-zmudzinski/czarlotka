package com.appspot.czarlotka.server.bets.biglotto;

import com.appspot.czarlotka.api.bet.biglotto.BigLottoBet;
import pl.zmudzinski.orm.jdo.GenericDaoJdo;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import java.util.Date;
import java.util.List;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-11
 * Time: 02:32:49
 */
public class BigLottoBetRepository extends GenericDaoJdo<BigLottoBet, Long> {

    PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory("transactions-optional");

    @SuppressWarnings("unchecked")
    public List<BigLottoBet> getActiveBets(Date lotteryDate) {
        PersistenceManager pm = pmfInstance.getPersistenceManager();
        Query query = pm.newQuery(BigLottoBet.class);
        query.setFilter("activeFrom >= lotteryDate && activeTo <= lotteryDate");
        return (List<BigLottoBet>) query.execute(lotteryDate);
    }
}
