package org.launchcode.twilMessageDemo.models;

import java.util.TimerTask;
import java.util.Timer;

import static org.launchcode.twilMessageDemo.models.TwillySend.twill_away;


class TwillTask {
    Timer timer;

    public void TwillSendExample(int seconds) {
        timer = new Timer();
        String message = null;
        String number = null;
        timer.schedule(new TwillReminder(message, number), seconds + 1000); //note wait time in milliseconds
    }


    static class TwillReminder extends TimerTask {
        String message;
        String number;

        public TwillReminder(String message, String number) {
            this.message = message;
            this.number = number;
        }
    @Override
    public void run() {
        twill_away(message, number);
        //timer.cancel(); //cancel in controller
    }

    }

}




