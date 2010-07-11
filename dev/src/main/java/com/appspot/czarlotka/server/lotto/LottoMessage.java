package com.appspot.czarlotka.server.lotto;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Responsible for retrieving lotto specific information from mime message
 * <p/>
 * User: lukasz.zmudzinski
 * Date: 2010-07-11
 * Time: 01:30:33
 */
public class LottoMessage extends MimeMessage {

    // TODO refactor all finals to external property
    private final Address lottoAdress = new InternetAddress("wyniki-lotto@lotto.pl");
    private final String lottoLotteryResultsAnnouncementEmailSubject = "Wyniki losowania Lotto";
    private final SimpleDateFormat lotteryDateFormat = new SimpleDateFormat("YYYY-MM-DD");

    public LottoMessage(MimeMessage message) throws MessagingException {
        super(message);
    }

    public boolean isFromLotto() {
        boolean fromLotto = false;
        try {
            for (Address address : getFrom()) {
                if (lottoAdress.equals(address)) {
                    fromLotto = true;
                    break;
                }
            }
        } catch (MessagingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return fromLotto;
    }

    public boolean containsLotteryResultsAnnouncement() {
        boolean containsLotteryResultsAnnouncement = false;
        try {
            containsLotteryResultsAnnouncement = lottoLotteryResultsAnnouncementEmailSubject.equals(getSubject());
        } catch (MessagingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return containsLotteryResultsAnnouncement;
    }

    public Date getLotteryDate() throws LotteryDateNotFoundException {
        try {
            return lotteryDateFormat.parse(getLotteryDateString());
        } catch (ParseException e) {
            throw new LotteryDateNotFoundException(e);
        }
    }

    private String getLotteryDateString() throws LotteryDateNotFoundException {
        String content = convertContentToString();
        int datePrefix = content.indexOf(lottoLotteryResultsAnnouncementEmailSubject);
        if (datePrefix != -1) {

        }
        return "bless";
    }

    private String convertContentToString() {
        StringBuilder sb = new StringBuilder();
        try {
            Multipart content = (Multipart) getContent();
            int count = content.getCount();
            for (int i = 0; i < count; i++) {
                BodyPart part = content.getBodyPart(i);
                if (part.getContent() instanceof String) {
                    sb.append((String) part.getContent());
                }
            }
        } catch (MessagingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return sb.toString();
    }
}
