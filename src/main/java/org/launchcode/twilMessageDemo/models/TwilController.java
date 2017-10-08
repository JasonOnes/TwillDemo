package org.launchcode.twilMessageDemo.models;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

@Controller
@RequestMapping(value="twilly")
public class TwilController {

    @RequestMapping(value="")
    public String form(Model model) {
        model.addAttribute("messageForm", new MessageForm());
        return "twilly";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String message(Model model, @ModelAttribute MessageForm messageForm) {
        model.addAttribute("message", messageForm.getMessage());
        Timer timer = new Timer(true); //note makes thread a daemon thread only executes as long as the program is running

        String number = messageForm.getNumber();
        String message = messageForm.getMessage(); //note will only work with my number for now
        //note for this example, message waits 2000 miliseconds, then repeats every 10000 milseconds
        //timer.schedule(new TwillTask.TwillReminder(message, number), 2000, 10000);
        //note can schedule task for specific date at a specific time schedule(Task, Date target)
        //Date(year - 1900, month(0-11), day-of-month, hour(24), minute)
        Date date = new Date(117, 9, 7, 19, 41);//note this Date is deprecated but it works so well!
        System.out.println(date);
        timer.schedule(new TwillTask.TwillReminder(message, number), date); //does this send at midnight?
        System.out.println("+++++++" + message);
        //timer.cancel(); //needed to stop the reminders running all day if time-of-day not stated
        //note can schedule task for date and repeate every year (Task, Date target, long repeat) where repeat = 1year in milliseconds?
        //timer.schedule(new TwillTask.TwillReminder(message, number),10/8,31557600000);//too long !!
        //maybe add a counter function to add date++ to year ?
        return "/sent";
    }



}

