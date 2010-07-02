package com.appspot.czarlotka.notification.email;

import com.appspot.czarlotka.event.WinningNotification;
import com.appspot.czarlotka.user.User;
import com.google.inject.Inject;
import cuke4duke.StepMother;
import cuke4duke.Steps;
import cuke4duke.annotation.I18n;
import cuke4duke.annotation.Pending;
import cuke4duke.annotation.Transform;

/**
 * Created by IntelliJ IDEA.
 * User: lukasz
 * Date: 2010-07-01
 * Time: 22:25:43
 * To change this template use File | Settings | File Templates.
 */
public class EmailNotificationSteps extends Steps {

    @Inject
    private EmailSender emailSender;

    private WinningNotification winningNotification;

    @Inject
    public EmailNotificationSteps(StepMother stepMother) {
        super(stepMother);
    }

    @Transform
    public User transformStringToUserWithEmail(/*String login,*/ String email) {
        return new User(email, email);
    }

    @I18n.EN.Given("^I have a winning notification for user with email:'(.*)'$")
    public void iHaveWinningNotification(User user) {
        winningNotification = new WinningNotification(user);
    }

    @I18n.EN.When("^I send the email to user$")
    @Pending
    public void iSendTheEmail() {
        emailSender.sendEmail(winningNotification);
    }

    @I18n.EN.Then("^User should receive the email$")
    @Pending
    public void userShouldReceiveTheEmail() {
    }


}