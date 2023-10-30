package com.springboot.blog_app.repository;

import com.springboot.blog_app.model.Blog;
import com.springboot.blog_app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> searchBlogByTitleContaining(String string);
    List<Blog> searchBlogByCategoryName(String name);
    List<Blog> searchBlogByCategoryId(Integer id);
    Blog findBlogById(Integer id);
    List<Blog> findAll();
}
