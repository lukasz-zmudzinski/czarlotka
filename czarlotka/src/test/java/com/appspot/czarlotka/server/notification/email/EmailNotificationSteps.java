package com.appspot.czarlotka.server.notification.email;

import com.appspot.czarlotka.api.notification.WinningNotification;
import com.appspot.czarlotka.api.user.User;
import com.google.inject.Inject;
import cuke4duke.StepMother;
import cuke4duke.Steps;
import cuke4duke.annotation.I18n;
import cuke4duke.annotation.Transform;


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
    public void iSendTheEmail() {
//        emailSender.send(null);
    }

    @I18n.EN.Then("^User should receive the email$")
    public void userShouldReceiveTheEmail() {
    }


}