package com.example.ss1_1.controller;

import com.example.ss1_1.service.IConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class ConverterController {
    @Autowired
    private IConverterService converterService;

    @GetMapping
    public String displayPage() {
        return "home";
    }
    @GetMapping("/calculate")
    public ModelAndView convert(@RequestParam String currency, double input) {
        if (currency.equals("vnd")) {
            return new ModelAndView("home", "result", converterService.convertVndToUsd(input));
        } else {
            return new ModelAndView("home", "result", converterService.convertUsdToVnd(input));
        }
    }
}
