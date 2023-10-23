package com.example.blog_upgraded.controller;

import com.example.blog_upgraded.model.Blog;
import com.example.blog_upgraded.service.IBlogService;
import com.example.blog_upgraded.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    private ModelAndView showHomePage(@PageableDefault(value = 1) Pageable pageable) {
        return new ModelAndView("home", "blogList", blogService.findAll(pageable));
    }

    @GetMapping("/search")
    private String findBlogByTitle(@PageableDefault(value = 1) Pageable pageable, @RequestParam String input, Model model) {
        model.addAttribute("input", input);
        model.addAttribute("blogList", blogService.findByTitleContaining(pageable, input));
        return "search-result";

    }

    @GetMapping("/add")
    public ModelAndView showAddBlogPage() {
        return new ModelAndView("add", "blog", new Blog());
    }

    @PostMapping("/add")
    public String addBlog(@ModelAttribute Blog blog) {
        blogService.addBlog(blog);
        return "redirect:/";
    }

    @GetMapping("/show-category")
    public ModelAndView getCategoryList() {
        return new ModelAndView("navbar", "categoryList", categoryService.getCategoryList());
    }
    @GetMapping("/{id}/delete")
    public String deleteBlog(@PathVariable Integer id) {
        blogService.deleteBlog(id);
        return "redirect:/";
    }
}
