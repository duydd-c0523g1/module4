package com.example.ss2_2.controller;

import com.example.ss2_2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @RequestMapping("")
    public String homePage() {
        return "home";
    }

    @PostMapping("/calculate")
    public ModelAndView calculate(@RequestParam double num1, double num2, String operator) {
        if (num2 == 0) {
            return new ModelAndView("home", "result", "Cannot divide by 0");
        } else {
            return new ModelAndView("home", "result", calculatorService.calculate(num1, num2, operator));
        }
    }
}
