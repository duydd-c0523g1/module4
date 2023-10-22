package com.springboot.blog_app.service;

import com.springboot.blog_app.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    List<Blog> findBockByName(String name);
    Blog displayBlogById(Integer id);
    void addNewBlog(Blog blog);
    void removeBlog(Integer id);
    void updateBlog(Blog blog);
}
