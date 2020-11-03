package com.portfolio.bappy.controller;

import com.portfolio.bappy.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    MailService mailService;

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value="/home",method= RequestMethod.GET)
    public String home() {
        return "redirect:/";
    }

    @RequestMapping(value="/sendMail",method=RequestMethod.POST)
    public String sendMessage(Model model, @RequestParam("name") String name, @RequestParam("email") String email,
                              @RequestParam("subject") String subject,@RequestParam("message") String message) {

        if (!StringUtils.isEmpty(name) || !StringUtils.isEmpty(email) || !StringUtils.isEmpty(subject) || !StringUtils.isEmpty(message)) {
            try {
                mailService.sendEmail(email, name, subject, message);
            }catch (Exception e){
                System.out.println("Error in sending Email !!");
            }
        }
        model.addAttribute("replay","Successfully Sent!!!");
        return "index";
        }
    }

