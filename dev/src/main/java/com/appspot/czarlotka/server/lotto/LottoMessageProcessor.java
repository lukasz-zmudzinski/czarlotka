package com.appspot.czarlotka.server.lotto;

import com.appspot.czarlotka.server.bets.BetRepository;
import com.google.inject.Inject;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-11
 * Time: 00:56:42
 */
public class LottoMessageProcessor {

    @Inject
    private BetRepository betRepository;

    public void process(LottoMessage message) {
        if (message.isFromLotto() && message.containsLotteryResultsAnnouncement()) {
            betRepository.getActiveBets(message.getLotteryDate());

        }
    }

}
