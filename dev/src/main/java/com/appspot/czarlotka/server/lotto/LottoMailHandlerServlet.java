package com.appspot.czarlotka.server.lotto;

import com.google.inject.Inject;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-11
 * Time: 00:30:46
 */
public class LottoMailHandlerServlet extends HttpServlet {
    @Inject
    private LottoMessageProcessor lottoMessageProcessor;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        try {
            MimeMessage message = new MimeMessage(session, request.getInputStream());
            lottoMessageProcessor.process(new LottoMessage(message));
        } catch (MessagingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
