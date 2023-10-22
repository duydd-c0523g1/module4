package com.springboot.blog_app.controller;

import com.springboot.blog_app.model.Blog;
import com.springboot.blog_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ModelAndView showHomePage () {
        List<Blog> blogList = blogService.findAll();
        return new ModelAndView("home", "blogList", blogList);
    }
    @GetMapping("/add")
    public ModelAndView showAddBlogPage() {
        return new ModelAndView("add", "blog", new Blog());
    }
    @PostMapping("add")
    public String addNewBlog(@ModelAttribute Blog blog) {
        blogService.addNewBlog(blog);
        return "redirect:/";
    }
    @GetMapping("/{id}/update")
    public ModelAndView updateBlog(@PathVariable Integer id) {
        Blog blog = blogService.displayBlogById(id);
        return new ModelAndView("update", "blog", blog);
    }
    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog) {
        blogService.updateBlog(blog);
        return "redirect:/";
    }
    @GetMapping("/{id}/read")
    public ModelAndView readBlog(@PathVariable Integer id) {
        Blog blog = blogService.displayBlogById(id);
        return new ModelAndView("read", "blog", blog);
    }
    @GetMapping("/{id}/delete")
    public String deleteBlog(@PathVariable Integer id) {
        blogService.removeBlog(id);
        return "redirect:/";
    }
    @GetMapping("/search")
    public ModelAndView searchBlog(@RequestParam String input) {
        List<Blog> blogList = blogService.findBlogByName(input);
        return new ModelAndView("home", "blogList", blogList);
    }
}
