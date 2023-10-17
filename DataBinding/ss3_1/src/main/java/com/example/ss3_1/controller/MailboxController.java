package com.example.ss3_1.controller;

import com.example.ss3_1.model.MailBox;
import com.example.ss3_1.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class MailboxController {
    @Autowired
    private IMailboxService mailboxService;
    @GetMapping
    public String homePage(Model model) {
        MailBox mailBox = new MailBox();
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        List<Integer> numberList = new ArrayList<>();
        numberList.add(5);
        numberList.add(10);
        numberList.add(15);
        numberList.add(25);
        numberList.add(50);
        numberList.add(100);
        model.addAttribute("languageList", languageList);
        model.addAttribute("numberList", numberList);
        model.addAttribute("mailBox", mailBox);
        return "home";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MailBox mailBox, RedirectAttributes redirectAttributes, Model model) {
//        redirectAttributes.addFlashAttribute("mailBox", mailBox);
        model.addAttribute("mailBox", mailBox);
        return "result";
    }
}
