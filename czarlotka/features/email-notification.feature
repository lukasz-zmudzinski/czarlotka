Feature: Email notification

 # Background:
 #    Given following user
 #


  Scenario: Winning notification sent to user
     Given I have a winning notification for user with email:'lucas.zmudzinski@gmail.com'
     When I send the email to user
     Then User should receive the email