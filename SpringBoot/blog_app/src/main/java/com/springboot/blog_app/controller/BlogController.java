package com.springboot.blog_app.controller;

import com.springboot.blog_app.model.Blog;
import com.springboot.blog_app.model.Category;
import com.springboot.blog_app.service.IBlogService;
import com.springboot.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    private String showHomePage(@PageableDefault(value = 12) Pageable pageable, Model model) {
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("blogList", blogService.findAll(pageable));
        model.addAttribute("categoryList", categories);
        return "home";
    }
    @GetMapping("/add")
    public ModelAndView showAddBlogPage(Model model) {
        model.addAttribute("categoryList", categoryService.findAllCategory());
        return new ModelAndView("add", "blog", new Blog());
    }
    @PostMapping("add")
    public String addNewBlog(@ModelAttribute Blog blog) {
        blogService.addNewBlog(blog);
        return "redirect:/";
    }
    @GetMapping("/{id}/update")
    public ModelAndView updateBlog(@PathVariable Integer id, Model model) {
        Blog blog = blogService.displayBlogById(id);
        model.addAttribute("categoryList", categoryService.findAllCategory());
        return new ModelAndView("update", "blog", blog);
    }
    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog) {
        blogService.updateBlog(blog);
        return "redirect:/";
    }
    @GetMapping("/{id}/read")
    public ModelAndView readBlog(@PathVariable Integer id, Model model) {
        Blog blog = blogService.displayBlogById(id);
        model.addAttribute("categoryList", categoryService.findAllCategory());
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

    @GetMapping("/category/{name}")
    public ModelAndView displayBlogByCategory(@PathVariable String name, Model model) {
        model.addAttribute("categoryList", categoryService.findAllCategory());
        return new ModelAndView("categorized-blogs", "blogList", blogService.findBlogByCategory(name));
    }
}
