package com.springboot.blog_app.controller;

import com.springboot.blog_app.model.Category;
import com.springboot.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("show-category")
    public ModelAndView showHomePage() {
        List<Category> categoryList = categoryService.findAllCategory();
        return new ModelAndView("home", "categoryList", categoryList);
    }
}
