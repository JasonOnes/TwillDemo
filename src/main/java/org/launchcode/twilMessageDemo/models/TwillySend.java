package org.launchcode.twilMessageDemo.models;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class TwillySend {


    // Setup your own account for personal SID, TOKEN, and phone number
    public static final String ACCOUNT_SID = "AXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    public static final String AUTH_TOKEN = "eXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";


    public static void twill_away(String message) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message twill_message = Message.creator(new PhoneNumber("1234567890"),//number to (receiving)
                new PhoneNumber("1234567890"),//number from (this will be your Twillio number)
                message).create();//message from form and passed via model

        System.out.println(twill_message.getSid());
    }
}