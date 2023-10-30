package com.springboot.blog_app.service;

import com.springboot.blog_app.model.Blog;
import com.springboot.blog_app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findBlogByName(String name);
    List<Blog> findBlogByCategory(String name);
    List<Blog> searchBlogByCategoryId(Integer id);
    Blog displayBlogById(Integer id);
    void addNewBlog(Blog blog);
    void removeBlog(Integer id);
    void updateBlog(Blog blog);
    List<Blog> findAll();
}
