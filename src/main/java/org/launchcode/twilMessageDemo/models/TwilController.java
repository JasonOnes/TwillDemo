package org.launchcode.twilMessageDemo.models;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        TwillySend.twill_away(messageForm.getMessage());
        return "/sent";
    }
}

