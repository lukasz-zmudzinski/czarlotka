package com.appspot.czarlotka.server.bets;

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
public class BetRepository {

    PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory("transactions-optional");

    @SuppressWarnings("unchecked")
    public List<BigLotekBet> getActiveBets(Date lotteryDate) {
        PersistenceManager pm = pmfInstance.getPersistenceManager();
        String className = BigLotekBet.class.getName();
        Query query = pm.newQuery("SELECT * from " + className + " " +
                "WHERE activeFrom >= lotteryDate " +
                "AND activeTo <= lotteryDate " +
                "import java.util.Date");
        return (List<BigLotekBet>) query.execute(lotteryDate);
    }
}
