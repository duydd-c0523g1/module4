package com.springboot.blog_app.controller;

import com.springboot.blog_app.model.Blog;
import com.springboot.blog_app.model.Category;
import com.springboot.blog_app.service.IBlogService;
import com.springboot.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RestBlogController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> showCategoryList() {
        List<Category> categoryList = categoryService.findAllCategory();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        }
    }
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> showBlogList() {
        List<Blog> blogList= blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> showBlogByCategory(@PathVariable Integer id) {
        List<Blog> blogList = blogService.searchBlogByCategoryId(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> showBlogDetail(@PathVariable Integer id) {
        Blog blog = blogService.displayBlogById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<List<Blog>> findBlogByName(@RequestParam String title) {
        List<Blog> blogList = blogService.findBlogByName(title);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }
}
