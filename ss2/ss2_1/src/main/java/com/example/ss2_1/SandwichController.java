package com.example.ss2_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class SandwichController {
    @GetMapping
    public String displayHome() {
        return "home";
    }
    @PostMapping("/save")
    public String save (Model model, @RequestParam(value = "ingredient", required = false, defaultValue = "") String[] ingredient) {
        model.addAttribute("result", ingredient);
        return "sandwich";
    }
}
