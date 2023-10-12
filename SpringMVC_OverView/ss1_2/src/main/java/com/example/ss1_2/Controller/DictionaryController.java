package com.example.ss1_2.Controller;

import com.example.ss1_2.Service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping
    public String displayPage() {
        return "home";
    }
    @GetMapping("/translate")
    public ModelAndView translate(@RequestParam String input) {
        return new ModelAndView("home", "result", dictionaryService.translate(input));
    }
}
